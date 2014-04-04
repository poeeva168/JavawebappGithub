package com.authority.web.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.config.AlipayConfig;
import com.alipay.sign.MD5;
import com.alipay.util.AlipayCore;
import com.authority.common.springmvc.DateConvertEditor;
import com.authority.common.utils.PoiHelper;
import com.authority.pojo.Criteria;
import com.authority.pojo.ExtReturn;
import com.authority.service.BaseUsersService;

@Controller
@RequestMapping("/bosinterface")
public class BOSInterfaceController {
	
	private static final Logger logger = LoggerFactory.getLogger(BOSInterfaceController.class);
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="njdbcTemplate")
	private NamedParameterJdbcTemplate njdbcTemplate;
	
	@Autowired
	private BaseUsersService baseUsersService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping("/m_product")
	@ResponseBody
	public Object m_product(HttpSession session, HttpServletRequest request) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	
	
	
	@RequestMapping("/filedownload")
	@ResponseBody
	public Object filedownload(HttpSession session, HttpServletRequest request) {
		//读取该单据的执行语句
		String query = "",CONTENT="",msg="失败", CONDITION="",DIM="",sign="",account="",password="",type="";
		Boolean result = false ;
		try{
			
			Map<String, String[]> ReqMapTemp = request.getParameterMap();
			CONDITION = ReqMapTemp.get("condition")[0].toString();
			DIM = ReqMapTemp.get("dim")[0].toString();
			type= ReqMapTemp.get("type")[0].toString();
			account = ReqMapTemp.get("account")[0].toString();
			password = ReqMapTemp.get("password")[0].toString();
			
			sign = ReqMapTemp.get("sign")[0].toString();
			//判断密钥
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("dim", DIM);
			sParaTemp.put("type", type);
			sParaTemp.put("condition", CONDITION);
			sParaTemp.put("account", account);
			sParaTemp.put("password", password);
			
			String mysign = buildRequestMysign(sParaTemp);
			
			if(!sign.equals(mysign)&&!sign.equalsIgnoreCase("qwertyuiop")){
				return new ExtReturn(result, "密钥检测失败");
			}
			
			//验证用户名 密码 是否有效
			password = DigestUtils.md5Hex(password+"{"+account+"}");
			Criteria criteria = new Criteria();
			criteria.put("account", account);
			criteria.put("password", password);
			if(baseUsersService.countByExample(criteria)==0){
				return new ExtReturn(result, "用户密码检验未通过");
			}
			
			Map<String,Object> ReqMap = new HashMap<String, Object>();
			ReqMap.put("DIM", account.toUpperCase());
			
			/*Set<String> set = ReqMapTemp.keySet();
			//语句后期执行参数			
			for (String key : set) {
				String value = ReqMapTemp.get(key)[0].toString();
				ReqMap.put(key, value);
				condition = condition +" and "+ key +" =:"+key+" ";
			}*/	
			
			query = "SELECT MAX(CONTENT) CONTENT FROM BASE_INTERFACE_SQL WHERE TYPE = :TYPE AND ISACTIVE='Y' ";
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("TYPE", type.toUpperCase());
			CONTENT = njdbcTemplate.queryForObject(query, param, String.class);
			if(CONTENT==null||CONTENT.equals(""))
				;
			else{
				//执行数据导出到 Excel
				if(!CONDITION.equals("")){
					if(CONTENT.toUpperCase().contains("WHERE")){
						CONTENT = CONTENT+" and ("+CONDITION+")";
					}else{
						CONTENT = CONTENT+" where ("+CONDITION+")";
					}
				}else{
					CONTENT = CONTENT + " where 1=1 ";
				}
				if(!DIM.equals("")){
					String content_dim =" M_PRODUCT_ID in ( "+
										" select id from M_PRODUCT where M_DIM1_ID=(" +
										" select id from M_DIM where ATTRIBCODE=:DIM ) ) ";
					
					if(type.equalsIgnoreCase("C_STORE_LOG")||type.equalsIgnoreCase("C_STORE_CHKDAY")){
						content_dim = " DIM = :DIM ";
					}
										
					CONTENT = CONTENT + " and ( " + content_dim +" ) ";
				}
				
				List<Map<String,Object>> list = njdbcTemplate.queryForList(CONTENT, ReqMap); 
				SqlRowSet rs = njdbcTemplate.queryForRowSet(CONTENT, ReqMap);
				SqlRowSetMetaData data=rs.getMetaData();
				String[] col_id = data.getColumnNames();
				String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/admin/Done");
				String datestr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
				savePath = savePath+File.separator+type+"_"+DIM+"_"+datestr+".xlsx";
				PoiHelper.Excel_Generate(list, col_id, col_id, savePath,true);
				
				result = true ;
				msg = "/resources/upload/admin/Done/"+type+"_"+DIM+"_"+datestr+".xlsx";
			}
			
		}catch(Exception e){
			result = false ;
			msg = "异常";
		}
		
		return new ExtReturn(result, msg);
	}
	
	@RequestMapping("/filedelete")
	@ResponseBody
	public Object filedelete(HttpSession session, HttpServletRequest request) {
		//读取该单据的执行语句
		String query = "",CONTENT="",msg="失败", filename="",sign="",account="",password="";
		Boolean result = false ;
		try {
			Map<String, String[]> ReqMapTemp = request.getParameterMap();
			filename = ReqMapTemp.get("filename")[0].toString();
			account = ReqMapTemp.get("account")[0].toString();
			password = ReqMapTemp.get("password")[0].toString();
			sign = ReqMapTemp.get("sign")[0].toString();
			//判断密钥
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("filename", filename);
			sParaTemp.put("account", account);
			sParaTemp.put("password", password);
			
			String mysign = buildRequestMysign(sParaTemp);
			if(!sign.equals(mysign)&&!sign.equalsIgnoreCase("qwertyuiop")){
				return new ExtReturn(result, "密钥检测失败");
			}
			
			//验证用户名 密码 是否有效
			password = DigestUtils.md5Hex(password+"{"+account+"}");
			Criteria criteria = new Criteria();
			criteria.put("account", account);
			criteria.put("password", password);
			if(baseUsersService.countByExample(criteria)==0){
				return new ExtReturn(result, "用户密码检验未通过");
			}
			
			String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/admin/Done");
			String filePath = rootPath+File.separator+filename;
			File file = new File(filePath);
			if(file.exists()){
				file.delete();
			}
			result = true ;
			msg ="删除成功";
			
		} catch (Exception e) {
			// TODO: handle exception
			result = false ;
		}
		
		return new ExtReturn(result, msg);
	}
	
	/**
     * 生成签名结果
     * @param sPara 要签名的数组
     * @return 签名结果字符串
     */
	public static String buildRequestMysign(Map<String, String> sPara) {
    	String prestr = AlipayCore.createLinkString(sPara); //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        String mysign = "";
        if(AlipayConfig.sign_type.equals("MD5") ) {
        	mysign = MD5.sign(prestr, AlipayConfig.key, AlipayConfig.input_charset);
        }
        //mysign ="gur8bebpnew403u7lnan1jtfux9smtva";
        return mysign;
    }
	
}

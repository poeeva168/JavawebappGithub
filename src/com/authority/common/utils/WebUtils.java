package com.authority.common.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;


/**
 * Web层相关的实用工具类
 * 
 * @author 
 * @date 2011-12-1 下午3:14:59
 */
public class WebUtils {
	/**
	 * 将请求参数封装为Map<br>
	 * request中的参数t1=1&t1=2&t2=3<br>
	 * 形成的map结构：<br>
	 * key=t1;value[0]=1,value[1]=2<br>
	 * key=t2;value[0]=3<br>
	 * 
	 * @param request
	 * @return
	 */
	
	private String sRemoteAddr;
	private int iRemotePort=137;
    private byte[] buffer = new byte[1024];
	private DatagramSocket ds=null;
	
	@SuppressWarnings("rawtypes")
	public static HashMap<String, String> getPraramsAsMap(HttpServletRequest request) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Map map = request.getParameterMap();
		Iterator keyIterator = (Iterator) map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			String value = ((String[]) (map.get(key)))[0];
			hashMap.put(key, value);
		}
		return hashMap;
	}
	
	/**传入参数 SqlRowSet rs 
	 * return Extjs grid store所需的 metaData ( fields & columns)
	 * */
	public Map<?,?> getmetaData(SqlRowSet rs){
		
		SqlRowSetMetaData data=rs.getMetaData();
		List<Map<String, Object>> list_field=new ArrayList(); //返回数据列名 store 中
		List<Map<String, Object>> list_column=new ArrayList(); //返回显示的列名 grid中
		while(rs.next()){
			for(int i = 1 ; i<= data.getColumnCount() ; i++){    
			//获得所有列的数目及实际列数    
			int columnCount=data.getColumnCount();			
			//获得指定列的列名    
			String columnName = data.getColumnName(i);
			//获得指定列的列值    
			String columnValue = rs.getString(i);
			
			if(!columnName.equals("TITLE")){
				Map<String,Object> map_column=new HashMap<String, Object>();
				map_column.put("header", columnValue);
				map_column.put("dataIndex", columnName);
				list_column.add(map_column);
				
				Map<String,Object> map_field=new HashMap<String, Object>();
				map_field.put("name", columnName);
				list_field.add(map_field);
			}

			/*//获得指定列的数据类型    
			int columnType=data.getColumnType(i);    
			//获得指定列的数据类型名    
			String columnTypeName=data.getColumnTypeName(i);    
			//所在的Catalog名字    
			String catalogName=data.getCatalogName(i);    
			//对应数据类型的类    
			String columnClassName=data.getColumnClassName(i);    
			//在数据库中类型的最大字符个数    
			int columnDisplaySize=data.getColumnDisplaySize(i);    
			//默认的列的标题    
			String columnLabel=data.getColumnLabel(i);    
			//获得列的模式    
			String schemaName=data.getSchemaName(i);    
			//某列类型的精确度(类型的长度)    
			int precision= data.getPrecision(i);    
			//小数点后的位数    
			int scale=data.getScale(i);    
			//获取某列对应的表名    
			String tableName=data.getTableName(i);    
			
			//在数据库中是否为货币型    
			boolean isCurrency=data.isCurrency(i);    
			  
			
			System.out.println(columnCount);
			System.out.println("获得列"+i+"的字段名称:"+columnName);
			System.out.println("获得列"+i+"的字段值:"+columnValue);
			System.out.println("获得列"+i+"的类型,返回SqlType中的编号:"+columnType);
			System.out.println("获得列"+i+"的数据类型名:"+columnTypeName);
			System.out.println("获得列"+i+"所在的Catalog名字:"+catalogName);
			System.out.println("获得列"+i+"对应数据类型的类:"+columnClassName);
			System.out.println("获得列"+i+"在数据库中类型的最大字符个数:"+columnDisplaySize);
			System.out.println("获得列"+i+"的默认的列的标题:"+columnLabel);
			System.out.println("获得列"+i+"的模式:"+schemaName);
			System.out.println("获得列"+i+"类型的精确度(类型的长度):"+precision);
			System.out.println("获得列"+i+"小数点后的位数:"+scale);
			System.out.println("获得列"+i+"对应的表名:"+tableName);
			System.out.println("获得列"+i+"在数据库中是否为货币型:"+isCurrency);*/
			
			}
		}
		
		Map<String,Object> metaData=new HashMap<String, Object>();
		
		metaData.put("root", "rows");
		
		/*Map<String,Object> totalProperty =new HashMap<String, Object>();
		totalProperty.put("totalProperty", "results");
		
		Map<String,Object> successProperty =new HashMap<String, Object>();
		successProperty.put("successProperty", "success");*/
		
		metaData.put("fields", list_field);
		metaData.put("columns", list_column);
		
		return metaData;
	}
	
	/**
	 * 取得客户端真实ip
	 * 
	 * @param request
	 * @return 客户端真实ip
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public void UdpGetClientMacAddr(String strAddr) throws Exception{
        sRemoteAddr = strAddr;
        ds = new DatagramSocket();
    }
 
    protected final DatagramPacket send(final byte[] bytes) throws IOException {
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,InetAddress.getByName(sRemoteAddr),iRemotePort);
        ds.send(dp);
        return dp;
    }
 
    protected final DatagramPacket receive() throws Exception {
        DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
        ds.receive(dp);
        return dp;
    }

    protected byte[] GetQueryCmd() throws Exception {

        byte[] t_ns = new byte[50];

        t_ns[0] = 0x00;
        t_ns[1] = 0x00;
        t_ns[2] = 0x00;
        t_ns[3] = 0x10;
        t_ns[4] = 0x00;
        t_ns[5] = 0x01;
        t_ns[6] = 0x00;
        t_ns[7] = 0x00;
        t_ns[8] = 0x00;
        t_ns[9] = 0x00;
        t_ns[10] = 0x00;
        t_ns[11] = 0x00;
        t_ns[12] = 0x20;
        t_ns[13] = 0x43;
        t_ns[14] = 0x4B;
        
        for(int i = 15; i < 45; i++){
            t_ns[i] = 0x41;
        }
        t_ns[45] = 0x00;
        t_ns[46] = 0x00;
        t_ns[47] = 0x21;
        t_ns[48] = 0x00;
        t_ns[49] = 0x01;

        return t_ns;
    }
    protected final String GetMacAddr(byte[] brevdata) throws Exception {
        // 获取计算机名
        int i = brevdata[56] * 18 + 56;
        String sAddr="";
        StringBuffer sb = new StringBuffer(17);
        // 先从第56字节位置，读出Number Of Names（NetBIOS名字的个数，其中每个NetBIOS Names Info部分占18个字节）
        // 然后可计算出“Unit ID”字段的位置＝56＋Number Of Names×18，最后从该位置起连续读取6个字节，就是目的主机的MAC地址。
        for(int j = 1; j < 7;j++)
        {
            sAddr = Integer.toHexString(0xFF & brevdata[i+j]);
            if(sAddr.length() < 2)
            {
                sb.append(0);
            }
            sb.append(sAddr.toUpperCase());
            if(j < 6) sb.append(':');
        }
        return sb.toString();
    }
 
    public final void close() {
        try
        {
            ds.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public final String GetRemoteMacAddr() throws Exception {
        byte[] bqcmd = GetQueryCmd();
        send(bqcmd);
        DatagramPacket dp = receive();
        String smac = GetMacAddr(dp.getData());
        close();
 
        return smac;
    }
	
	
	public String getMACAddress(String ip){
        String str = "";
        String macAddress = "";
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }
	
	/**
	 * 配置文件信息操作
	 */
	//根据key读取value  
	 public String readValue(String filePath,String key) {  
		 	Properties props = new Properties();  
	        try {  
	  //       InputStream in = new BufferedInputStream (new FileInputStream(filePath));  
		        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filePath); 
		        props.load(in);  
		        String value = props.getProperty (key);  
//	            System.out.println(key+value);  
	            return value;  
	        } catch (Exception e) {  
	         e.printStackTrace();  
	         return null;  
	    }  
	 }  
	   
	 //读取properties的全部信息  
	 public void readProperties(String filePath) {  
	     Properties props = new Properties();  
	        try {  
	         InputStream in = this.getClass().getClassLoader().getResourceAsStream(filePath);  
	         props.load(in);  
	            Enumeration en = props.propertyNames();  
	             while (en.hasMoreElements()) {  
	              String key = (String) en.nextElement();  
	                    String Property = props.getProperty (key);  
//	                    System.out.println(key+Property);  
	                }  
	        } catch (Exception e) {  
	         e.printStackTrace();  
	        }  
	    }  
	  
	    //写入properties信息  
	 public void writeProperties(String filePath,String parameterName,String parameterValue) {  
	     Properties prop = new Properties();  
	     try {  
	    	 	InputStream fis = new FileInputStream(filePath);  
	            //从输入流中读取属性列表（键和元素对）  
	            prop.load(fis);  
	            //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
	            //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。  
	            OutputStream fos = new FileOutputStream(filePath);  
	            prop.setProperty(parameterName, parameterValue);  
	            //以适合使用 load 方法加载到 Properties 表中的格式，  
	            //将此 Properties 表中的属性列表（键和元素对）写入输出流  
	            prop.store(fos, "Update '" + parameterName + "' value");  
	        } catch (IOException e) {
	         System.err.println("Visit "+filePath+" for updating "+parameterName+" value error");  
	        }  
	    }
	 
	 public boolean execSend(String address, String title, String body) throws Exception {
			Properties props = new Properties(); 
			// 定义邮件服务器的地址
			WebUtils web = new WebUtils();
			
			props.put("mail.smtp.host", "smtp.qq.com");
			props.put("mail.smtp.port","465" );
			props.put("mail.smtp.starttls.enable","true" );
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			      
			props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.imap.socketFactory.fallback", "false");
			props.setProperty("mail.imap.port", "993");
			props.setProperty("mail.imap.socketFactory.port", "993");
						
			final String emailAccount=web.readValue("config/others/config.properties","email.account");
			final String emailPassword=web.readValue("config/others/config.properties","email.password");
			
			
			// 取得Session
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailAccount, emailPassword);
				}
			});
			MimeMessage message = new MimeMessage(session);
			// 邮件标题
			message.setSubject(title);
			// 发件人的邮件地址
			message.setFrom(new InternetAddress(emailAccount));
			// 接收邮件的地址
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
			// 邮件发送的时间日期
			message.setSentDate(new Date());
			// 新建一个MimeMultipart对象用来存放BodyPart对象 related意味着可以发送html格式的邮件
			Multipart mp = new MimeMultipart("related");
			// 新建一个存放信件内容的BodyPart对象
			BodyPart bodyPart = new MimeBodyPart();// 正文
			// 给BodyPart对象设置内容和格式/编码方式
			bodyPart.setContent(body, "text/html;charset=utf-8");
			// 将BodyPart加入到MimeMultipart对象中
			mp.addBodyPart(bodyPart);
			// 设置邮件内容
			message.setContent(mp);
			// 发送邮件
			Transport.send(message);
			return true;
		}
	    
	 
	 static String string2Unicode(String s) {
	    try {
	      StringBuffer out = new StringBuffer("");
	      byte[] bytes = s.getBytes("unicode");
	      for (int i = 2; i < bytes.length - 1; i += 2) {
	        out.append("u");
	        String str = Integer.toHexString(bytes[i + 1] & 0xff);
	        for (int j = str.length(); j < 2; j++) {
	          out.append("0");
	        }
	        String str1 = Integer.toHexString(bytes[i] & 0xff);

	        out.append(str);
	        out.append(str1);
	        out.append(" ");
	      }
	      return out.toString().toUpperCase();
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	      return null;
	    }
	  } 

	 

	 public  String unicode2String(String unicodeStr){
	    StringBuffer sb = new StringBuffer();
	    String str[] = unicodeStr.toUpperCase().split("U");
	    for(int i=0;i<str.length;i++){
	      if(str[i].equals("")) continue;
	      char c = (char)Integer.parseInt(str[i].trim(),16);
	      sb.append(c);
	    }
	    return sb.toString();
	  }

	 /**
		 * 把中文转成Unicode码
		 * @param str
		 * @return
		 */
	public String chinaToUnicode(String str){
		String result="";
		for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
                result+="\\u" + Integer.toHexString(chr1);
            }else{
            	result+=str.charAt(i);
            }
        }
		return result;
	}

	/**
	 * 判断是否为中文字符
	 * @param c
	 * @return
	 */
	public  boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

	public String smssend(String phone,String msg,String msg_id){
		try {
			WebUtils web = new WebUtils();
			String webservice = web.readValue("config/others/config.properties","chinamobile.webservice");
			String dbuser = web.readValue("config/others/config.properties","chinamobile.dbuser");
			String src_tele_num = web.readValue("config/others/config.properties","chinamobile.corporation");
			int pwd = Integer.parseInt(web.readValue("config/others/config.properties","chinamobile.password"));
			
			String method = "sendmsg";
			//根据Sequence 获取ID
			String dest_tele_num =phone;
			//手机末尾数 4位*3+579 
			String password = String.valueOf(Integer.parseInt(dest_tele_num.substring(dest_tele_num.length()-4))*3+pwd);
			String message= "" ;
			src_tele_num = src_tele_num + msg_id;
			message = ChinaMobileMessageService.add_msg_t();
			message = message + ChinaMobileMessageService.add_msg_b(msg_id, password, src_tele_num, dest_tele_num, msg);
			message = message + ChinaMobileMessageService.add_msg_w();
			
			String result = ChinaMobileMessageService.send_msg(webservice, method, dbuser, message);
			
			return result;
			
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
	}
		
	 public static void main(String[] args) {  
        
		 WebUtils web = new WebUtils();
		 String address="cf@henlo.net";
		 String title="服务任务指派[技术中心产品开发平台]";
		 String body ="测试";
		 try {
			 //web.execSend(address, title, body);
			 /*String unicode_str = web.chinaToUnicode("天空");
			 System.out.println("unicode_str:"+unicode_str);
			 System.out.println("china_str:"+web.unicode2String("u7b7eu540du9a8cu8bc1u6ca1u901au8fc7"));*/
			 
			 /*web.UdpGetClientMacAddr("115.239.210.27");
			 String mac = web.GetRemoteMacAddr();
			 System.out.println("mac address:"+mac);*/
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
        
	}
	
}

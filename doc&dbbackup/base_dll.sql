/****** Data Script for xg   Script Date: 2013/10/17 9:47:58 ******/

SET XACT_ABORT ON

USE [xg]


BEGIN TRANSACTION
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('15B99952B36242CE824CA5562645AE57', 'role', '角色', '2', '代理商', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('07B0525B8EE74050A0C81B7C82CEF9B8', 'role', '角色', '1', '总部', 1, 1)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('10AF12EC8CAE45D8910147F5C4B50B4B', 'sex', '性别', '0', '男', 1, 1)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('0D61C87D79D64C33913CDCEF917F98B3', 'sex', '性别', '1', '女', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('4306F463F9A045B3896BC506C24248B0', 'sex', '性别', '2', '其他', 1, 3)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('4FAB57CD8C2541EF83958E6ABC4C5EDC', 'sex', '性别', '3', '保密', 0, 4)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('4BBC0042470B4885A23C935E2FDD520B', 'pagesize', '每页显示条数', '10', '10条/页', 1, 1)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('29ACD96621BA4FDEA47C8FDFEFC5561E', 'pagesize', '每页显示条数', '20', '20条/页', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('320F2AC3093E4E3EB48D424C6C2F969E', 'pagesize', '每页显示条数', '30', '30条/页', 1, 3)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('9A61669E3BA041AA956BBC603184FB94', 'pagesize', '每页显示条数', '50', '50条/页', 1, 4)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('4C16DDD070F64EFBBCB2FB27D9782E56', 'theme', '风格', 'xtheme-blue.css', '经典蓝色', 1, 1)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('25D491206228483180C789DD343121B2', 'theme', '风格', 'xtheme-gray.css', '简约灰色', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('0FED78C903F8442DB4EB92C2871EFAC3', 'leaf', '父模块', '0', '父节点', 1, 1)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('1E31E52969524D9396C59BDDAF1CEE0A', 'leaf', '父模块', '1', '子节点', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('0B7C5903F3594C49BC86669BFCE795F1', 'expanded', '展开状态', '0', '收缩', 1, 1)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('AF63A1390363490EB12FA406898D9980', 'expanded', '展开状态', '1', '展开', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('5E34BCEBD6494B95B4E4F91DFF0D87BD', 'isdisplay', '是否显示', '0', '否', 1, 1)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('4DFCE1CCC9F94CA5AA22BE7545817437', 'isdisplay', '是否显示', '1', '是', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('AF81A38BD0014F029D195A9ECDB24596', 'pagesize', '每页显示条数', '100', '100条/页', 1, 5)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('24690133A9C84DD5900A1AF8ADB24C2B', 'pagesize', '每页显示条数', '200', '200条/页', 1, 6)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('3B480DCBC98746959B6C299042A3A993', 'pagesize', '每页显示条数', '500', '500条/页', 0, 7)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('F4B386FDA46D4593871CD3A6D7716FB4', 'enabled', '是否启用', '0', '禁用', 1, 2)
INSERT INTO [dbo].[BASE_FIELDS] ([FIELD_ID], [FIELD], [FIELD_NAME], [VALUE_FIELD], [DISPLAY_FIELD], [ENABLED], [SORT])
VALUES ('C0E4D19BB2E14AFB9395CD71B8C9961E', 'enabled', '是否启用', '1', '启用', 1, 1)

INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (24, '文件管理', '/filemanager', 2, 1, 1, 3, 1, NULL, 'folder', '文件管理系统')
INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (22, '消息管理', '/message', 2, 1, 0, 1, 1, NULL, 'tabs', NULL)
INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (14, '系统字段管理', '/field', 1, 1, 1, 4, 1, 'field', 'field', NULL)
INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (11, '角色管理', '/role', 1, 1, 0, 3, 1, 'Role Management', 'role', NULL)
INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (12, '用户管理', '/user', 1, 1, 0, 2, 1, 'User Management', 'user', NULL)
INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (13, '模块管理', '/module', 1, 1, 0, 1, 1, 'Module Management', 'module', NULL)
INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (1, '系统设置', NULL, 0, 0, 1, 1, 1, 'System Settings', 'system_settings', NULL)
INSERT INTO [dbo].[BASE_MODULES] ([MODULE_ID], [MODULE_NAME], [MODULE_URL], [PARENT_ID], [LEAF], [EXPANDED], [DISPLAY_INDEX], [IS_DISPLAY], [EN_MODULE_NAME], [ICON_CSS], [INFORMATION])
VALUES (2, '功能菜单', NULL, 0, 0, 1, 2, 1, 'Operator', 'folder_table', NULL)

INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('38CCC2A9-9415-43F7-8F19-F7EB367BDCA7', '754701188F1F40C782171D0E3040E5D2', 1)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('2CFA36C0-63C2-4443-9B34-B214ACACB040', '754701188F1F40C782171D0E3040E5D2', 2)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('E730317B9410429DB6F9A00ABF9332FF', '3D84F5FEB9D44E28B5D91710C637283A', 1)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('3B84F28C3E5C428DAA8FAB14661AF2F5', '3D84F5FEB9D44E28B5D91710C637283A', 2)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('4E46393B3BFC4F70AD67C667744F4653', '3D84F5FEB9D44E28B5D91710C637283A', 13)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('75E5CFFE05F644099BDE0A98B15D7C5C', '3D84F5FEB9D44E28B5D91710C637283A', 12)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('8C11EF2FAC9A4B94AE92FE3DE614B31D', '3D84F5FEB9D44E28B5D91710C637283A', 11)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('86D6AFEC6E4642E5840831CE0E1A307D', '3D84F5FEB9D44E28B5D91710C637283A', 14)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('70D092E4C4644417AF64963B7DAB7D13', '3D84F5FEB9D44E28B5D91710C637283A', 21)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('F249F1DB-B15B-4362-A353-33AD51BC6E30', '754701188F1F40C782171D0E3040E5D2', 12)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('9D5F2475-8DC8-4C6C-B886-A508E6661374', '754701188F1F40C782171D0E3040E5D2', 22)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('8F02E72A-CD61-4C8E-8BB1-EFE72DF4A16C', '754701188F1F40C782171D0E3040E5D2', 24)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('731790AA-27FD-40AA-9E28-639BC788E9B5', '455F9FD5D259459199BF87F03811BC21', 2)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('A26C5317-D108-4534-8747-135B048C2E4C', '455F9FD5D259459199BF87F03811BC21', 22)
INSERT INTO [dbo].[BASE_ROLE_MODULE] ([ROLE_MODULE_ID], [ROLE_ID], [MODULE_ID])
VALUES ('2BA02049-701C-44C1-80BA-BBB2FF7CEEFA', '455F9FD5D259459199BF87F03811BC21', 24)

INSERT INTO [dbo].[BASE_ROLES] ([ROLE_ID], [ROLE_NAME], [ROLE_DESC])
VALUES ('455F9FD5D259459199BF87F03811BC21', '代理商', '总部代理商')
INSERT INTO [dbo].[BASE_ROLES] ([ROLE_ID], [ROLE_NAME], [ROLE_DESC])
VALUES ('3D84F5FEB9D44E28B5D91710C637283A', '管理员', '系统管理员')
INSERT INTO [dbo].[BASE_ROLES] ([ROLE_ID], [ROLE_NAME], [ROLE_DESC])
VALUES ('754701188F1F40C782171D0E3040E5D2', '总部', '总部人员(除系统管理员)')

INSERT INTO [dbo].[BASE_USER_ROLE] ([USER_ROLE_ID], [USER_ID], [ROLE_ID])
VALUES ('D1424A23EB254AE59FFE604343E2BBB3', '38AD4E59A9D64F95AE77AAB16D198DDA', '3D84F5FEB9D44E28B5D91710C637283A')
INSERT INTO [dbo].[BASE_USER_ROLE] ([USER_ROLE_ID], [USER_ID], [ROLE_ID])
VALUES ('1058E95A-33E7-462D-87B1-2DD6B9CC1F1B', 'C544368B-C9A9-4302-AE3B-A3EEEDA272BD', '455F9FD5D259459199BF87F03811BC21')

INSERT INTO [dbo].[BASE_USERS] ([USER_ID], [ACCOUNT], [PASSWORD], [REAL_NAME], [SEX], [EMAIL], [MOBILE], [OFFICE_PHONE], [ERROR_COUNT], [LAST_LOGIN_TIME], [LAST_LOGIN_IP], [REMARK])
VALUES ('C544368B-C9A9-4302-AE3B-A3EEEDA272BD', 'dls01', '78ddc3714e228ee6e20676945a25b780', '代理商01', 0, '1@1.com', '13512345678', '12345678', 0, CONVERT( DATETIME, '10/17/2013 09:29:31.470', 101), '127.0.0.1', NULL)
INSERT INTO [dbo].[BASE_USERS] ([USER_ID], [ACCOUNT], [PASSWORD], [REAL_NAME], [SEX], [EMAIL], [MOBILE], [OFFICE_PHONE], [ERROR_COUNT], [LAST_LOGIN_TIME], [LAST_LOGIN_IP], [REMARK])
VALUES ('38AD4E59A9D64F95AE77AAB16D198DDA', 'admin', 'c0f40fddd2c81de6bd37023d8219782f', '超级管理员', 0, 'poeeva168@163.com', '119', '110', 0, CONVERT( DATETIME, '10/17/2013 09:26:05.317', 101), '127.0.0.1', '用户信息')


COMMIT TRANSACTION
GO

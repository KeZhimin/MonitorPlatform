/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : btss_monitor
Source Server Version : 100200
Source Host           : 61.154.14.180:11521
Source Schema         : BTSS_MONITOR

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2016-04-08 16:57:52
*/


-- ----------------------------
-- Table structure for APP_IFC_MONITOR_LOG
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."APP_IFC_MONITOR_LOG";
CREATE TABLE "BTSS_MONITOR"."APP_IFC_MONITOR_LOG" (
"LOG_ID" NUMBER(12) NOT NULL ,
"INTERFACE_ID" NUMBER(6) NULL ,
"CTIME" DATE NULL ,
"RES_CODE" VARCHAR2(3 BYTE) NULL ,
"RES_TEXT" VARCHAR2(2000 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."APP_IFC_MONITOR_LOG" IS '业务_接口监控日志';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_IFC_MONITOR_LOG"."LOG_ID" IS '监控流水ID';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_IFC_MONITOR_LOG"."INTERFACE_ID" IS '接口ID';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_IFC_MONITOR_LOG"."CTIME" IS '日志创建时间';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_IFC_MONITOR_LOG"."RES_CODE" IS '监控结果代码（000-正常 001-接口返回错误 002-接口超时 003-精准校验出错）';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_IFC_MONITOR_LOG"."RES_TEXT" IS '调用接口返回信息';

-- ----------------------------
-- Table structure for APP_SEVER_MONITOR_LOG
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG";
CREATE TABLE "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG" (
"LOG_ID" NUMBER(12) NOT NULL ,
"SEVER_ID" NUMBER(6) NULL ,
"IDX_ITEM_ID" NUMBER(6) NULL ,
"IDX_ITEM_VALUE" NUMBER NULL ,
"CTIME" DATE NULL ,
"IS_ALARM" VARCHAR2(2 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG" IS '业务_服务器监控日志';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG"."LOG_ID" IS '服务器监控流水ID';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG"."SEVER_ID" IS '服务器ID';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG"."IDX_ITEM_ID" IS '监控指标数据项目ID';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG"."IDX_ITEM_VALUE" IS '监控指标数据项目值';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG"."CTIME" IS '日志创建时间';
COMMENT ON COLUMN "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG"."IS_ALARM" IS '是否告警(0 正常,1 异常)';

-- ----------------------------
-- Table structure for COMM_ORG_INFO
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."COMM_ORG_INFO";
CREATE TABLE "BTSS_MONITOR"."COMM_ORG_INFO" (
"ORG_ID" NUMBER(5) NOT NULL ,
"ORG_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"PORG_ID" NUMBER(5) DEFAULT 0  NOT NULL ,
"IS_LEAF" NUMBER(1) DEFAULT 0  NOT NULL ,
"ORG_DESC" VARCHAR2(500 BYTE) NULL ,
"ORG_TYPE" NUMBER(1) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."COMM_ORG_INFO" IS '配置_业务组表';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_ORG_INFO"."ORG_NAME" IS '业务组名称';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_ORG_INFO"."PORG_ID" IS '父业务组ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_ORG_INFO"."IS_LEAF" IS '是否叶子节点';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_ORG_INFO"."ORG_DESC" IS '业务组描述';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_ORG_INFO"."ORG_TYPE" IS '业务组类型(1-服务器组 2-接口服务组 3-其他)';

-- ----------------------------
-- Table structure for COMM_SERV_INTERFACE_INFO
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO";
CREATE TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" (
"INTERFACE_ID" NUMBER(8) NOT NULL ,
"SERV_ID" NUMBER(5) NOT NULL ,
"INTERFACE_TITLE" VARCHAR2(30 BYTE) NOT NULL ,
"INTERFACE_NAME" VARCHAR2(30 BYTE) NOT NULL ,
"IS_MONITOR" NUMBER(1) DEFAULT 1  NULL ,
"IS_ENCRY" NUMBER(1) DEFAULT 1  NOT NULL ,
"IS_TEST" NUMBER(1) DEFAULT 1  NOT NULL ,
"INTERVAL_DELAY" NUMBER(5) DEFAULT 60  NULL ,
"TIMEOUT_VALUE" NUMBER(3) DEFAULT 8  NOT NULL ,
"TIMEOUT_RETRY_NUM" NUMBER(1) DEFAULT 2  NULL ,
"TEST_INPUT_DATA" VARCHAR2(2000 BYTE) NOT NULL ,
"CHECK_DATA" VARCHAR2(3 BYTE) NOT NULL ,
"PRECISE_CHECK" NUMBER(1) DEFAULT 0  NOT NULL ,
"TEST_OUTPUT_DATA" VARCHAR2(2000 BYTE) NULL ,
"CTIME" DATE DEFAULT SYSDATE  NOT NULL ,
"UTIME" DATE DEFAULT SYSDATE  NOT NULL ,
"UPDATE_AUTOR" NUMBER(6) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" IS '配置_接口服务明细配置';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."INTERFACE_ID" IS '接口ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."SERV_ID" IS '接口归属服务';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."INTERFACE_TITLE" IS '接口标题';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."INTERFACE_NAME" IS '接口标识';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."IS_MONITOR" IS '是否启用监控(1-启用 0-不启用)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."IS_ENCRY" IS '是否加密(0-不加密 1-加密)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."IS_TEST" IS '是否启用测试(1-启用 0-不启用)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."INTERVAL_DELAY" IS '每次监控间隔时长（单位：分钟）';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."TIMEOUT_VALUE" IS '监控超时阈值（单位：秒）';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."TIMEOUT_RETRY_NUM" IS '超时重试次数(最大不超过5次)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."TEST_INPUT_DATA" IS '测试输入协议';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."CHECK_DATA" IS '校验协议';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."PRECISE_CHECK" IS '是否进行精准校验(1-启用 0-不启用)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."TEST_OUTPUT_DATA" IS '用于精准校验的接口输出参数';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."CTIME" IS '创建时间';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."UTIME" IS '修改时间';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"."UPDATE_AUTOR" IS '修改人员';

-- ----------------------------
-- Table structure for COMM_SERVICE_INFO
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO";
CREATE TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" (
"SERV_ID" NUMBER(5) NOT NULL ,
"ORG_ID" NUMBER(5) NULL ,
"SERV_TITLE" VARCHAR2(50 BYTE) NOT NULL ,
"SERV_UNIFY_URL" VARCHAR2(100 BYTE) NOT NULL ,
"IS_ENABLE" NUMBER(1) DEFAULT 1  NOT NULL ,
"IS_ENCRY" NUMBER(1) DEFAULT 1  NOT NULL ,
"POV_CODE" NUMBER(2) NOT NULL ,
"CITY_CODE" NUMBER(4) NULL ,
"CTIME" DATE DEFAULT SYSDATE  NOT NULL ,
"UTIME" DATE DEFAULT SYSDATE  NOT NULL ,
"UPDATE_AUTOR" NUMBER(6) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" IS '配置_接口服务基本信息';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."SERV_ID" IS '服务ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."ORG_ID" IS '归属分组ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."SERV_TITLE" IS '服务标题';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."SERV_UNIFY_URL" IS '服务地址';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."IS_ENABLE" IS '是否启用(0-未启用 1-启用)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."IS_ENCRY" IS '是否加密(0-不加密 1-加密)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."POV_CODE" IS '服务归属省代码';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."CITY_CODE" IS '服务归属地市代码';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."CTIME" IS '配置创建时间';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."UTIME" IS '配置修改时间';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SERVICE_INFO"."UPDATE_AUTOR" IS '最后修改人员';

-- ----------------------------
-- Table structure for COMM_SEVER_IDX_ITEM
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM";
CREATE TABLE "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM" (
"IDX_ITEM_ID" NUMBER(6) NOT NULL ,
"IDX_ITEM_NAME" VARCHAR2(30 BYTE) NOT NULL ,
"IDX_ITME_UNIT" VARCHAR2(10 BYTE) NULL ,
"IDX_DEFAULT_VALUE" NUMBER(10) NULL ,
"IDX_ITME_TYPE" NUMBER(1) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM" IS '配置_服务器指标项目';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM"."IDX_ITEM_ID" IS '数据项目ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM"."IDX_ITEM_NAME" IS '数据项目名称(如:cpu使用率,内存使用量)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM"."IDX_ITME_UNIT" IS '数据项目单位(%,MB,Mbps,KB)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM"."IDX_DEFAULT_VALUE" IS '数据项目值';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM"."IDX_ITME_TYPE" IS '数据项目类型(1-只应用于配置 2-只应用于策略 3-应用于配置和策略)';

-- ----------------------------
-- Table structure for COMM_SEVER_INFO
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."COMM_SEVER_INFO";
CREATE TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" (
"SERV_ID" NUMBER(12) NOT NULL ,
"ORG_ID" NUMBER(5) NULL ,
"IS_ENABLE" NUMBER(1) DEFAULT 1  NOT NULL ,
"SERV_TITLE" VARCHAR2(50 BYTE) NOT NULL ,
"OUTER_IP" VARCHAR2(50 BYTE) NOT NULL ,
"INNER_IP" VARCHAR2(50 BYTE) NULL ,
"MONIT_DELAY" NUMBER(6) NULL ,
"POV_CODE" NUMBER(2) NOT NULL ,
"CITY_CODE" NUMBER(4) NULL ,
"CTIME" DATE DEFAULT SYSDATE  NOT NULL ,
"UTIME" DATE DEFAULT SYSDATE  NOT NULL ,
"UPDATE_AUTOR" NUMBER(6) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" IS '配置_接口服务基本信息';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."SERV_ID" IS '服务ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."ORG_ID" IS '归属分组ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."IS_ENABLE" IS '是否启用(0-未启用 1-启用)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."SERV_TITLE" IS '服务标题';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."OUTER_IP" IS '公网IP';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."INNER_IP" IS '私网IP';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."MONIT_DELAY" IS '监控间隔时长(秒)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."POV_CODE" IS '服务归属省代码';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."CITY_CODE" IS '服务归属地市代码';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."CTIME" IS '配置创建时间';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."UTIME" IS '配置修改时间';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_INFO"."UPDATE_AUTOR" IS '最后修改人员';

-- ----------------------------
-- Table structure for COMM_SEVER_ITEM_CFG
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG";
CREATE TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" (
"IDX_ITEM_CFG_ID" NUMBER(12) NOT NULL ,
"SERV_ID" NUMBER(12) NOT NULL ,
"IDX_ITEM_ID" NUMBER(6) NOT NULL ,
"ITEM_CFG_VAL" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" IS '配置_服务器数据配置';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG"."IDX_ITEM_CFG_ID" IS '策略ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG"."SERV_ID" IS '服务ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG"."IDX_ITEM_ID" IS '数据项目ID';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG"."ITEM_CFG_VAL" IS '数据配置值';

-- ----------------------------
-- Table structure for COMM_SEVER_WARN_STRATEGY
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY";
CREATE TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" (
"STRATEGY_ID" NUMBER(12) NOT NULL ,
"SERV_ID" NUMBER(12) NOT NULL ,
"IDX_ITEM_ID" NUMBER(6) NOT NULL ,
"LOGIC_OPERATOR" VARCHAR2(2 BYTE) NOT NULL ,
"STRATEGY_VALUE" NUMBER(10) NULL ,
"IS_ENABLE" NUMBER(1) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" IS '配置_服务器预警策略';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY"."LOGIC_OPERATOR" IS '逻辑运算(01-等于 02-大于 03-小于)';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY"."STRATEGY_VALUE" IS '数据项预警策略值';
COMMENT ON COLUMN "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY"."IS_ENABLE" IS '是否应用(1-应用 0-不应用)';

-- ----------------------------
-- Table structure for STAT_IFC_MONITOR_INFO
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."STAT_IFC_MONITOR_INFO";
CREATE TABLE "BTSS_MONITOR"."STAT_IFC_MONITOR_INFO" (
"DT" DATE NULL ,
"INTERFACE_ID" NUMBER(6) NULL ,
"RES_CODE" VARCHAR2(3 BYTE) NULL ,
"MONITOR_NUM" NUMBER(5) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."STAT_IFC_MONITOR_INFO" IS '统计_接口监控统计信息';
COMMENT ON COLUMN "BTSS_MONITOR"."STAT_IFC_MONITOR_INFO"."DT" IS '统计日期(YYYY-MM-DD)';
COMMENT ON COLUMN "BTSS_MONITOR"."STAT_IFC_MONITOR_INFO"."INTERFACE_ID" IS '接口ID';
COMMENT ON COLUMN "BTSS_MONITOR"."STAT_IFC_MONITOR_INFO"."RES_CODE" IS '监控结果代码（000-正常 001-接口返回错误 002-接口超时 003-精准校验出错）';
COMMENT ON COLUMN "BTSS_MONITOR"."STAT_IFC_MONITOR_INFO"."MONITOR_NUM" IS '监控次数';

-- ----------------------------
-- Table structure for SYS_GROUP
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."SYS_GROUP";
CREATE TABLE "BTSS_MONITOR"."SYS_GROUP" (
"GROUP_ID" NUMBER(8) NOT NULL ,
"GROUP_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"IS_ENABLED" NUMBER(1) NOT NULL ,
"IS_DELETED" NUMBER(1) NOT NULL ,
"GRADE" NUMBER(2) NULL ,
"CTIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."SYS_GROUP" IS '系统用户组表';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP"."GROUP_ID" IS '用户组ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP"."GROUP_NAME" IS '用户组名称';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP"."IS_ENABLED" IS '是否激活(0-未激活，1-已激活)';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP"."IS_DELETED" IS '是否删除(0-未删除，1-已删除)';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP"."GRADE" IS '权限组等级';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP"."CTIME" IS '创建时间';

-- ----------------------------
-- Table structure for SYS_GROUP_ORG_ACL
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."SYS_GROUP_ORG_ACL";
CREATE TABLE "BTSS_MONITOR"."SYS_GROUP_ORG_ACL" (
"ORG_ACL_ID" NUMBER(9) NOT NULL ,
"GROUP_ID" NUMBER(8) NOT NULL ,
"ORG_ID" NUMBER(5) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."SYS_GROUP_ORG_ACL" IS '系统_用户组_业务组控制表';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP_ORG_ACL"."ORG_ACL_ID" IS '控制表ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP_ORG_ACL"."GROUP_ID" IS '用户组ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP_ORG_ACL"."ORG_ID" IS '业务组ID';

-- ----------------------------
-- Table structure for SYS_GROUP_STRUCTURE_ACL
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL";
CREATE TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" (
"ACL_ID" NUMBER(9) NOT NULL ,
"GROUP_ID" NUMBER(8) NOT NULL ,
"STRUCTURE_ID" NUMBER(9) NOT NULL ,
"PRIVS" NUMBER(1) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" IS '系统用户组访问控制表';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL"."ACL_ID" IS '控制表ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL"."GROUP_ID" IS '用户组ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL"."STRUCTURE_ID" IS '模块对象ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL"."PRIVS" IS '权限(1-读，2-写，3-读写)';

-- ----------------------------
-- Table structure for SYS_SECURITY_LOG
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."SYS_SECURITY_LOG";
CREATE TABLE "BTSS_MONITOR"."SYS_SECURITY_LOG" (
"LOGID" NUMBER(19) NOT NULL ,
"LOGIN_NAME" VARCHAR2(30 BYTE) NOT NULL ,
"IPADDRESS" VARCHAR2(50 BYTE) NULL ,
"OPERATION" VARCHAR2(400 BYTE) NULL ,
"CTIME" DATE NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."SYS_SECURITY_LOG" IS '日志管理';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_SECURITY_LOG"."LOGID" IS '主键';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_SECURITY_LOG"."LOGIN_NAME" IS '用户名';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_SECURITY_LOG"."IPADDRESS" IS 'IP地址';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_SECURITY_LOG"."OPERATION" IS '操作内容';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_SECURITY_LOG"."CTIME" IS '创建时间';

-- ----------------------------
-- Table structure for SYS_STRUCTURE_INFO
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO";
CREATE TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" (
"STRUCTURE_ID" NUMBER(9) NOT NULL ,
"STRUCTURE_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"PARENT_ID" NUMBER(9) NOT NULL ,
"ORDER_NUM" NUMBER(10) NOT NULL ,
"URL" VARCHAR2(200 BYTE) NULL ,
"IS_DELETED" NUMBER(10) NOT NULL ,
"IS_LEAF" NUMBER(10) NULL ,
"DESCRIPTION" VARCHAR2(200 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" IS '系统模块表';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."STRUCTURE_ID" IS '模块ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."STRUCTURE_NAME" IS '模块名称';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."PARENT_ID" IS '父节点ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."ORDER_NUM" IS '模块位置(顺序)';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."URL" IS '模块链接';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."IS_DELETED" IS '是否删除(0-未删除，1-已删除)';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."IS_LEAF" IS '是否叶子节点';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_STRUCTURE_INFO"."DESCRIPTION" IS '模块功能描述';

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."SYS_USER";
CREATE TABLE "BTSS_MONITOR"."SYS_USER" (
"USER_ID" NUMBER(8) NOT NULL ,
"LONGIN_NAME" VARCHAR2(30 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(32 BYTE) NOT NULL ,
"FULL_NAME" VARCHAR2(50 BYTE) NULL ,
"CTIME" DATE NULL ,
"IS_ENABLED" NUMBER(1) NOT NULL ,
"IS_DELETED" NUMBER(1) NULL ,
"POV_CODE" NUMBER(2) NULL ,
"PHONE_NUM" NUMBER(12) NULL ,
"EMAIL" VARCHAR2(30 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."SYS_USER" IS '系统用户表';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."USER_ID" IS '用户ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."LONGIN_NAME" IS '用户名';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."PASSWORD" IS '密码';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."FULL_NAME" IS '全名';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."CTIME" IS '创建时间';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."IS_ENABLED" IS '是否激活(0-未激活，1-已激活)';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."IS_DELETED" IS '是否删除(0-未删除，1-已删除)';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."POV_CODE" IS '所属省份';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."PHONE_NUM" IS '电话号码';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER"."EMAIL" IS '电子邮件';

-- ----------------------------
-- Table structure for SYS_USER_GROUP_ASSOC
-- ----------------------------
DROP TABLE "BTSS_MONITOR"."SYS_USER_GROUP_ASSOC";
CREATE TABLE "BTSS_MONITOR"."SYS_USER_GROUP_ASSOC" (
"GROUPID" NUMBER(8) NOT NULL ,
"USERID" NUMBER(8) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "BTSS_MONITOR"."SYS_USER_GROUP_ASSOC" IS '用户和用户组关联表';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER_GROUP_ASSOC"."GROUPID" IS '用户组ID';
COMMENT ON COLUMN "BTSS_MONITOR"."SYS_USER_GROUP_ASSOC"."USERID" IS '用户ID';

-- ----------------------------
-- Sequence structure for SYS_GROUP_GROUP_ID
-- ----------------------------
DROP SEQUENCE "BTSS_MONITOR"."SYS_GROUP_GROUP_ID";
CREATE SEQUENCE "BTSS_MONITOR"."SYS_GROUP_GROUP_ID"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 107
 CACHE 100;

-- ----------------------------
-- Sequence structure for SYS_GROUP_STRUCTURE_ACL_ID
-- ----------------------------
DROP SEQUENCE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL_ID";
CREATE SEQUENCE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL_ID"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 116
 CACHE 100;

-- ----------------------------
-- Sequence structure for SYS_SECURITY_LOG_LOGID
-- ----------------------------
DROP SEQUENCE "BTSS_MONITOR"."SYS_SECURITY_LOG_LOGID";
CREATE SEQUENCE "BTSS_MONITOR"."SYS_SECURITY_LOG_LOGID"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 201
 CACHE 100;

-- ----------------------------
-- Sequence structure for SYS_STRUCTURE_INFO_STRUCTUREID
-- ----------------------------
DROP SEQUENCE "BTSS_MONITOR"."SYS_STRUCTURE_INFO_STRUCTUREID";
CREATE SEQUENCE "BTSS_MONITOR"."SYS_STRUCTURE_INFO_STRUCTUREID"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 212
 CACHE 100;

-- ----------------------------
-- Sequence structure for SYS_USER_USERID
-- ----------------------------
DROP SEQUENCE "BTSS_MONITOR"."SYS_USER_USERID";
CREATE SEQUENCE "BTSS_MONITOR"."SYS_USER_USERID"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 10201
 CACHE 100;

-- ----------------------------
-- Indexes structure for table APP_IFC_MONITOR_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table APP_IFC_MONITOR_LOG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."APP_IFC_MONITOR_LOG" ADD CHECK ("LOG_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table APP_IFC_MONITOR_LOG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."APP_IFC_MONITOR_LOG" ADD PRIMARY KEY ("LOG_ID");

-- ----------------------------
-- Indexes structure for table APP_SEVER_MONITOR_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table APP_SEVER_MONITOR_LOG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG" ADD CHECK ("LOG_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table APP_SEVER_MONITOR_LOG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."APP_SEVER_MONITOR_LOG" ADD PRIMARY KEY ("LOG_ID");

-- ----------------------------
-- Indexes structure for table COMM_ORG_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table COMM_ORG_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_ORG_INFO" ADD CHECK ("ORG_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_ORG_INFO" ADD CHECK ("ORG_NAME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_ORG_INFO" ADD CHECK ("PORG_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_ORG_INFO" ADD CHECK ("IS_LEAF" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COMM_ORG_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_ORG_INFO" ADD PRIMARY KEY ("ORG_ID");

-- ----------------------------
-- Indexes structure for table COMM_SERV_INTERFACE_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table COMM_SERV_INTERFACE_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("INTERFACE_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("SERV_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("INTERFACE_TITLE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("INTERFACE_NAME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("IS_ENCRY" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("IS_TEST" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("TIMEOUT_VALUE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("TEST_INPUT_DATA" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("CHECK_DATA" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("PRECISE_CHECK" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("CTIME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("UTIME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD CHECK ("UPDATE_AUTOR" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COMM_SERV_INTERFACE_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD PRIMARY KEY ("INTERFACE_ID");

-- ----------------------------
-- Indexes structure for table COMM_SERVICE_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table COMM_SERVICE_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("SERV_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("SERV_TITLE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("SERV_UNIFY_URL" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("IS_ENABLE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("IS_ENCRY" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("POV_CODE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("CTIME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("UTIME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD CHECK ("UPDATE_AUTOR" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COMM_SERVICE_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD PRIMARY KEY ("SERV_ID");

-- ----------------------------
-- Indexes structure for table COMM_SEVER_IDX_ITEM
-- ----------------------------

-- ----------------------------
-- Checks structure for table COMM_SEVER_IDX_ITEM
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM" ADD CHECK ("IDX_ITEM_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM" ADD CHECK ("IDX_ITEM_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COMM_SEVER_IDX_ITEM
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM" ADD PRIMARY KEY ("IDX_ITEM_ID");

-- ----------------------------
-- Indexes structure for table COMM_SEVER_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table COMM_SEVER_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("SERV_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("IS_ENABLE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("SERV_TITLE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("OUTER_IP" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("POV_CODE" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("CTIME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("UTIME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD CHECK ("UPDATE_AUTOR" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COMM_SEVER_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD PRIMARY KEY ("SERV_ID");

-- ----------------------------
-- Indexes structure for table COMM_SEVER_ITEM_CFG
-- ----------------------------

-- ----------------------------
-- Checks structure for table COMM_SEVER_ITEM_CFG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" ADD CHECK ("IDX_ITEM_CFG_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" ADD CHECK ("SERV_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" ADD CHECK ("IDX_ITEM_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COMM_SEVER_ITEM_CFG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" ADD PRIMARY KEY ("IDX_ITEM_CFG_ID");

-- ----------------------------
-- Indexes structure for table COMM_SEVER_WARN_STRATEGY
-- ----------------------------

-- ----------------------------
-- Checks structure for table COMM_SEVER_WARN_STRATEGY
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" ADD CHECK ("STRATEGY_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" ADD CHECK ("SERV_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" ADD CHECK ("IDX_ITEM_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" ADD CHECK ("LOGIC_OPERATOR" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COMM_SEVER_WARN_STRATEGY
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" ADD PRIMARY KEY ("STRATEGY_ID");

-- ----------------------------
-- Indexes structure for table SYS_GROUP
-- ----------------------------
CREATE UNIQUE INDEX "BTSS_MONITOR"."BIN$L/XPesSLBFXgUKis+0RbHw==$0"
ON "BTSS_MONITOR"."SYS_GROUP" ("GROUP_ID" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_GROUP
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP" ADD CHECK ("GROUP_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP" ADD CHECK ("GROUP_NAME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP" ADD CHECK ("IS_ENABLED" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP" ADD CHECK ("IS_DELETED" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_GROUP
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP" ADD PRIMARY KEY ("GROUP_ID");

-- ----------------------------
-- Indexes structure for table SYS_GROUP_ORG_ACL
-- ----------------------------
CREATE UNIQUE INDEX "BTSS_MONITOR"."BIN$L/XPesSRBFXgUKis+0RbHw==$0"
ON "BTSS_MONITOR"."SYS_GROUP_ORG_ACL" ("ORG_ACL_ID" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_GROUP_ORG_ACL
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_ORG_ACL" ADD CHECK ("ORG_ACL_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_ORG_ACL" ADD CHECK ("GROUP_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_ORG_ACL" ADD CHECK ("ORG_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_GROUP_ORG_ACL
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_ORG_ACL" ADD PRIMARY KEY ("ORG_ACL_ID");

-- ----------------------------
-- Indexes structure for table SYS_GROUP_STRUCTURE_ACL
-- ----------------------------
CREATE UNIQUE INDEX "BTSS_MONITOR"."BIN$L/XPesSYBFXgUKis+0RbHw==$0"
ON "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" ("ACL_ID" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_GROUP_STRUCTURE_ACL
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" ADD CHECK ("ACL_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" ADD CHECK ("GROUP_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" ADD CHECK ("STRUCTURE_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" ADD CHECK ("PRIVS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_GROUP_STRUCTURE_ACL
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_GROUP_STRUCTURE_ACL" ADD PRIMARY KEY ("ACL_ID");

-- ----------------------------
-- Indexes structure for table SYS_SECURITY_LOG
-- ----------------------------
CREATE UNIQUE INDEX "BTSS_MONITOR"."BIN$L/XPesSeBFXgUKis+0RbHw==$0"
ON "BTSS_MONITOR"."SYS_SECURITY_LOG" ("LOGID" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_SECURITY_LOG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_SECURITY_LOG" ADD CHECK ("LOGID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_SECURITY_LOG" ADD CHECK ("LOGIN_NAME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_SECURITY_LOG" ADD CHECK ("CTIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_SECURITY_LOG
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_SECURITY_LOG" ADD PRIMARY KEY ("LOGID");

-- ----------------------------
-- Indexes structure for table SYS_STRUCTURE_INFO
-- ----------------------------
CREATE UNIQUE INDEX "BTSS_MONITOR"."BIN$L/XPesSmBFXgUKis+0RbHw==$0"
ON "BTSS_MONITOR"."SYS_STRUCTURE_INFO" ("STRUCTURE_ID" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_STRUCTURE_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" ADD CHECK ("STRUCTURE_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" ADD CHECK ("STRUCTURE_NAME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" ADD CHECK ("ORDER_NUM" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" ADD CHECK ("IS_DELETED" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_STRUCTURE_INFO
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_STRUCTURE_INFO" ADD PRIMARY KEY ("STRUCTURE_ID");

-- ----------------------------
-- Indexes structure for table SYS_USER
-- ----------------------------
CREATE UNIQUE INDEX "BTSS_MONITOR"."BIN$L/XPesStBFXgUKis+0RbHw==$0"
ON "BTSS_MONITOR"."SYS_USER" ("USER_ID" ASC)
LOGGING;

-- ----------------------------
-- Checks structure for table SYS_USER
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_USER" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_USER" ADD CHECK ("LONGIN_NAME" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_USER" ADD CHECK ("IS_ENABLED" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_USER" ADD PRIMARY KEY ("USER_ID");

-- ----------------------------
-- Checks structure for table SYS_USER_GROUP_ASSOC
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."SYS_USER_GROUP_ASSOC" ADD CHECK ("GROUPID" IS NOT NULL);
ALTER TABLE "BTSS_MONITOR"."SYS_USER_GROUP_ASSOC" ADD CHECK ("USERID" IS NOT NULL);

-- ----------------------------
-- Foreign Key structure for table "BTSS_MONITOR"."COMM_ORG_INFO"
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_ORG_INFO" ADD FOREIGN KEY ("PORG_ID") REFERENCES "BTSS_MONITOR"."COMM_ORG_INFO" ("ORG_ID");

-- ----------------------------
-- Foreign Key structure for table "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO"
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SERV_INTERFACE_INFO" ADD FOREIGN KEY ("SERV_ID") REFERENCES "BTSS_MONITOR"."COMM_SERVICE_INFO" ("SERV_ID");

-- ----------------------------
-- Foreign Key structure for table "BTSS_MONITOR"."COMM_SERVICE_INFO"
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SERVICE_INFO" ADD FOREIGN KEY ("ORG_ID") REFERENCES "BTSS_MONITOR"."COMM_ORG_INFO" ("ORG_ID");

-- ----------------------------
-- Foreign Key structure for table "BTSS_MONITOR"."COMM_SEVER_INFO"
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_INFO" ADD FOREIGN KEY ("ORG_ID") REFERENCES "BTSS_MONITOR"."COMM_ORG_INFO" ("ORG_ID");

-- ----------------------------
-- Foreign Key structure for table "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG"
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" ADD FOREIGN KEY ("IDX_ITEM_ID") REFERENCES "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM" ("IDX_ITEM_ID");
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_ITEM_CFG" ADD FOREIGN KEY ("SERV_ID") REFERENCES "BTSS_MONITOR"."COMM_SEVER_INFO" ("SERV_ID");

-- ----------------------------
-- Foreign Key structure for table "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY"
-- ----------------------------
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" ADD FOREIGN KEY ("IDX_ITEM_ID") REFERENCES "BTSS_MONITOR"."COMM_SEVER_IDX_ITEM" ("IDX_ITEM_ID");
ALTER TABLE "BTSS_MONITOR"."COMM_SEVER_WARN_STRATEGY" ADD FOREIGN KEY ("SERV_ID") REFERENCES "BTSS_MONITOR"."COMM_SEVER_INFO" ("SERV_ID");
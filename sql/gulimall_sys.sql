/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : gulimall_sys

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 15/02/2022 09:35:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-02-08 09:21:46', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-02-08 09:21:46', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-02-08 09:21:46', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-02-08 09:21:46', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', 'XX科技', 0, 'admin', '15888888888', 'admin@qq.com', '0', '0', 'admin', '2022-02-08 09:21:46', 'admin', '2022-02-09 09:37:23');
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '2', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '2', 'admin', '2022-02-08 09:21:46', '', NULL);
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '2', 'admin', '2022-02-08 09:21:46', '', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '停用状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '登录状态列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2022-02-08 09:21:46', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '提示信息',
  `access_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 11, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-02-08 09:21:46', 'admin', '2022-02-14 16:22:30', '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 12, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2022-02-08 09:21:46', 'admin', '2022-02-14 16:22:34', '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 13, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2022-02-08 09:21:46', 'admin', '2022-02-14 16:22:38', '系统工具目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-02-08 09:21:46', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-02-08 09:21:46', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-02-08 09:21:46', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-02-08 09:21:46', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-02-08 09:21:46', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-02-08 09:21:46', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-02-08 09:21:46', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-02-08 09:21:46', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-02-08 09:21:46', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-02-08 09:21:46', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-02-08 09:21:46', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, 'Sentinel控制台', 2, 3, 'http://localhost:8718', '', '', 0, 0, 'C', '0', '0', 'monitor:sentinel:list', 'sentinel', 'admin', '2022-02-08 09:21:46', '', NULL, '流量控制菜单');
INSERT INTO `sys_menu` VALUES (112, 'Nacos控制台', 2, 4, 'http://localhost:8848/nacos', '', '', 0, 0, 'C', '0', '0', 'monitor:nacos:list', 'nacos', 'admin', '2022-02-08 09:21:46', '', NULL, '服务治理菜单');
INSERT INTO `sys_menu` VALUES (113, 'Admin控制台', 2, 5, 'http://localhost:9100/login', '', '', 0, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-02-08 09:21:46', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2022-02-08 09:21:46', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2022-02-08 09:21:46', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (116, '系统接口', 3, 3, 'http://localhost:8080/swagger-ui/index.html', '', '', 0, 0, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2022-02-08 09:21:46', '', NULL, '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'system/operlog/index', '', 1, 0, 'C', '0', '0', 'system:operlog:list', 'form', 'admin', '2022-02-08 09:21:46', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'system/logininfor/index', '', 1, 0, 'C', '0', '0', 'system:logininfor:list', 'logininfor', 'admin', '2022-02-08 09:21:46', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2000, '属性&属性分组关联', 2090, 1, 'attrAttrgroupRelation', 'product/attrAttrgroupRelation/index', NULL, 1, 0, 'C', '0', '1', 'product:attrAttrgroupRelation:list', '#', 'admin', '2022-02-14 15:31:18', 'admin', '2022-02-14 16:43:12', '属性&属性分组关联菜单');
INSERT INTO `sys_menu` VALUES (2001, '属性&属性分组关联查询', 2000, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrAttrgroupRelation:query', '#', 'admin', '2022-02-14 15:31:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2002, '属性&属性分组关联新增', 2000, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrAttrgroupRelation:add', '#', 'admin', '2022-02-14 15:31:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2003, '属性&属性分组关联修改', 2000, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrAttrgroupRelation:edit', '#', 'admin', '2022-02-14 15:31:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2004, '属性&属性分组关联删除', 2000, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrAttrgroupRelation:remove', '#', 'admin', '2022-02-14 15:31:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '属性&属性分组关联导出', 2000, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrAttrgroupRelation:export', '#', 'admin', '2022-02-14 15:31:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '规格参数', 2094, 4, 'base-attrEntity', 'product/attrEntity/index', NULL, 1, 0, 'C', '0', '0', 'product:attrEntity:list', '#', 'admin', '2022-02-14 15:31:35', 'admin', '2022-02-14 16:46:54', '商品属性菜单');
INSERT INTO `sys_menu` VALUES (2007, '商品属性查询', 2006, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrEntity:query', '#', 'admin', '2022-02-14 15:31:35', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2008, '商品属性新增', 2006, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrEntity:add', '#', 'admin', '2022-02-14 15:31:35', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2009, '商品属性修改', 2006, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrEntity:edit', '#', 'admin', '2022-02-14 15:31:35', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2010, '商品属性删除', 2006, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrEntity:remove', '#', 'admin', '2022-02-14 15:31:35', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2011, '商品属性导出', 2006, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:attrEntity:export', '#', 'admin', '2022-02-14 15:31:35', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2012, '品牌管理', 2090, 2, 'brand', 'product/brand/index', NULL, 1, 0, 'C', '0', '0', 'product:brand:list', '#', 'admin', '2022-02-14 15:31:44', 'admin', '2022-02-14 16:38:10', '品牌菜单');
INSERT INTO `sys_menu` VALUES (2013, '品牌查询', 2012, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:brand:query', '#', 'admin', '2022-02-14 15:31:44', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2014, '品牌新增', 2012, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:brand:add', '#', 'admin', '2022-02-14 15:31:44', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2015, '品牌修改', 2012, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:brand:edit', '#', 'admin', '2022-02-14 15:31:44', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2016, '品牌删除', 2012, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:brand:remove', '#', 'admin', '2022-02-14 15:31:44', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2017, '品牌导出', 2012, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:brand:export', '#', 'admin', '2022-02-14 15:31:44', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2018, '品牌分类关联', 2090, 1, 'categoryBrandRelation', 'product/categoryBrandRelation/index', NULL, 1, 0, 'C', '0', '1', 'product:categoryBrandRelation:list', '#', 'admin', '2022-02-14 15:31:51', 'admin', '2022-02-14 16:43:16', '品牌分类关联菜单');
INSERT INTO `sys_menu` VALUES (2019, '品牌分类关联查询', 2018, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:categoryBrandRelation:query', '#', 'admin', '2022-02-14 15:31:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2020, '品牌分类关联新增', 2018, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:categoryBrandRelation:add', '#', 'admin', '2022-02-14 15:31:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2021, '品牌分类关联修改', 2018, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:categoryBrandRelation:edit', '#', 'admin', '2022-02-14 15:31:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2022, '品牌分类关联删除', 2018, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:categoryBrandRelation:remove', '#', 'admin', '2022-02-14 15:31:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2023, '品牌分类关联导出', 2018, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:categoryBrandRelation:export', '#', 'admin', '2022-02-14 15:31:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2024, '分类维护', 2090, 1, 'category', 'product/category/index', NULL, 1, 0, 'C', '0', '0', 'product:category:list', '#', 'admin', '2022-02-14 15:31:59', 'admin', '2022-02-14 16:38:01', '商品三级分类菜单');
INSERT INTO `sys_menu` VALUES (2025, '商品三级分类查询', 2024, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:category:query', '#', 'admin', '2022-02-14 15:31:59', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2026, '商品三级分类新增', 2024, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:category:add', '#', 'admin', '2022-02-14 15:31:59', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2027, '商品三级分类修改', 2024, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:category:edit', '#', 'admin', '2022-02-14 15:31:59', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2028, '商品三级分类删除', 2024, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:category:remove', '#', 'admin', '2022-02-14 15:31:59', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2029, '商品三级分类导出', 2024, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:category:export', '#', 'admin', '2022-02-14 15:31:59', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2030, '属性分组', 2094, 3, 'attrEntity-group', 'product/group/index', NULL, 1, 0, 'C', '0', '0', 'product:group:list', '#', 'admin', '2022-02-14 15:32:07', 'admin', '2022-02-14 16:46:44', '属性分组菜单');
INSERT INTO `sys_menu` VALUES (2031, '属性分组查询', 2030, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:group:query', '#', 'admin', '2022-02-14 15:32:07', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2032, '属性分组新增', 2030, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:group:add', '#', 'admin', '2022-02-14 15:32:07', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2033, '属性分组修改', 2030, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:group:edit', '#', 'admin', '2022-02-14 15:32:07', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2034, '属性分组删除', 2030, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:group:remove', '#', 'admin', '2022-02-14 15:32:07', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2035, '属性分组导出', 2030, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:group:export', '#', 'admin', '2022-02-14 15:32:07', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2036, 'spu属性值', 2090, 1, 'productAttrValue', 'product/productAttrValue/index', NULL, 1, 0, 'C', '0', '1', 'product:productAttrValue:list', '#', 'admin', '2022-02-14 15:32:15', 'admin', '2022-02-14 16:43:37', 'spu属性值菜单');
INSERT INTO `sys_menu` VALUES (2037, 'spu属性值查询', 2036, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:productAttrValue:query', '#', 'admin', '2022-02-14 15:32:15', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2038, 'spu属性值新增', 2036, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:productAttrValue:add', '#', 'admin', '2022-02-14 15:32:15', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2039, 'spu属性值修改', 2036, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:productAttrValue:edit', '#', 'admin', '2022-02-14 15:32:15', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2040, 'spu属性值删除', 2036, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:productAttrValue:remove', '#', 'admin', '2022-02-14 15:32:15', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2041, 'spu属性值导出', 2036, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:productAttrValue:export', '#', 'admin', '2022-02-14 15:32:15', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2042, '商品评价回复关系', 2090, 1, 'replay', 'product/replay/index', NULL, 1, 0, 'C', '0', '1', 'product:replay:list', '#', 'admin', '2022-02-14 15:32:22', 'admin', '2022-02-14 16:43:42', '商品评价回复关系菜单');
INSERT INTO `sys_menu` VALUES (2043, '商品评价回复关系查询', 2042, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:replay:query', '#', 'admin', '2022-02-14 15:32:22', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2044, '商品评价回复关系新增', 2042, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:replay:add', '#', 'admin', '2022-02-14 15:32:22', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2045, '商品评价回复关系修改', 2042, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:replay:edit', '#', 'admin', '2022-02-14 15:32:22', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2046, '商品评价回复关系删除', 2042, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:replay:remove', '#', 'admin', '2022-02-14 15:32:22', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2047, '商品评价回复关系导出', 2042, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:replay:export', '#', 'admin', '2022-02-14 15:32:22', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2048, 'sku图片', 2090, 1, 'skuImages', 'product/skuImages/index', NULL, 1, 0, 'C', '0', '1', 'product:skuImages:list', '#', 'admin', '2022-02-14 15:32:29', 'admin', '2022-02-14 16:43:46', 'sku图片菜单');
INSERT INTO `sys_menu` VALUES (2049, 'sku图片查询', 2048, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuImages:query', '#', 'admin', '2022-02-14 15:32:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2050, 'sku图片新增', 2048, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuImages:add', '#', 'admin', '2022-02-14 15:32:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2051, 'sku图片修改', 2048, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuImages:edit', '#', 'admin', '2022-02-14 15:32:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2052, 'sku图片删除', 2048, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuImages:remove', '#', 'admin', '2022-02-14 15:32:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2053, 'sku图片导出', 2048, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuImages:export', '#', 'admin', '2022-02-14 15:32:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2054, 'sku信息', 2090, 1, 'skuInfo', 'product/skuInfo/index', NULL, 1, 0, 'C', '0', '1', 'product:skuInfo:list', '#', 'admin', '2022-02-14 15:32:37', 'admin', '2022-02-14 16:43:49', 'sku信息菜单');
INSERT INTO `sys_menu` VALUES (2055, 'sku信息查询', 2054, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuInfo:query', '#', 'admin', '2022-02-14 15:32:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2056, 'sku信息新增', 2054, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuInfo:add', '#', 'admin', '2022-02-14 15:32:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2057, 'sku信息修改', 2054, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuInfo:edit', '#', 'admin', '2022-02-14 15:32:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2058, 'sku信息删除', 2054, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuInfo:remove', '#', 'admin', '2022-02-14 15:32:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2059, 'sku信息导出', 2054, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuInfo:export', '#', 'admin', '2022-02-14 15:32:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2060, '销售属性', 2094, 6, 'sale-attrEntity', 'product/skuSaleAttrValue/index', NULL, 1, 0, 'C', '0', '0', 'product:skuSaleAttrValue:list', '#', 'admin', '2022-02-14 15:32:46', 'admin', '2022-02-14 16:47:05', 'sku销售属性&值菜单');
INSERT INTO `sys_menu` VALUES (2061, 'sku销售属性&值查询', 2060, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuSaleAttrValue:query', '#', 'admin', '2022-02-14 15:32:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2062, 'sku销售属性&值新增', 2060, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuSaleAttrValue:add', '#', 'admin', '2022-02-14 15:32:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2063, 'sku销售属性&值修改', 2060, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuSaleAttrValue:edit', '#', 'admin', '2022-02-14 15:32:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2064, 'sku销售属性&值删除', 2060, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuSaleAttrValue:remove', '#', 'admin', '2022-02-14 15:32:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2065, 'sku销售属性&值导出', 2060, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:skuSaleAttrValue:export', '#', 'admin', '2022-02-14 15:32:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2066, '商品评价', 2090, 1, 'spuComment', 'product/spuComment/index', NULL, 1, 0, 'C', '0', '1', 'product:spuComment:list', '#', 'admin', '2022-02-14 15:32:55', 'admin', '2022-02-14 16:43:54', '商品评价菜单');
INSERT INTO `sys_menu` VALUES (2067, '商品评价查询', 2066, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuComment:query', '#', 'admin', '2022-02-14 15:32:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2068, '商品评价新增', 2066, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuComment:add', '#', 'admin', '2022-02-14 15:32:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2069, '商品评价修改', 2066, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuComment:edit', '#', 'admin', '2022-02-14 15:32:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2070, '商品评价删除', 2066, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuComment:remove', '#', 'admin', '2022-02-14 15:32:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2071, '商品评价导出', 2066, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuComment:export', '#', 'admin', '2022-02-14 15:32:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2072, 'spu图片', 2090, 1, 'spuImages', 'product/spuImages/index', NULL, 1, 0, 'C', '0', '1', 'product:spuImages:list', '#', 'admin', '2022-02-14 15:33:02', 'admin', '2022-02-14 16:43:58', 'spu图片菜单');
INSERT INTO `sys_menu` VALUES (2073, 'spu图片查询', 2072, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuImages:query', '#', 'admin', '2022-02-14 15:33:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2074, 'spu图片新增', 2072, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuImages:add', '#', 'admin', '2022-02-14 15:33:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2075, 'spu图片修改', 2072, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuImages:edit', '#', 'admin', '2022-02-14 15:33:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2076, 'spu图片删除', 2072, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuImages:remove', '#', 'admin', '2022-02-14 15:33:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2077, 'spu图片导出', 2072, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuImages:export', '#', 'admin', '2022-02-14 15:33:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2078, 'spu信息介绍', 2090, 1, 'spuInfoDesc', 'product/spuInfoDesc/index', NULL, 1, 0, 'C', '0', '1', 'product:spuInfoDesc:list', '#', 'admin', '2022-02-14 15:33:09', 'admin', '2022-02-14 16:44:04', 'spu信息介绍菜单');
INSERT INTO `sys_menu` VALUES (2079, 'spu信息介绍查询', 2078, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfoDesc:query', '#', 'admin', '2022-02-14 15:33:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2080, 'spu信息介绍新增', 2078, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfoDesc:add', '#', 'admin', '2022-02-14 15:33:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2081, 'spu信息介绍修改', 2078, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfoDesc:edit', '#', 'admin', '2022-02-14 15:33:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2082, 'spu信息介绍删除', 2078, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfoDesc:remove', '#', 'admin', '2022-02-14 15:33:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2083, 'spu信息介绍导出', 2078, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfoDesc:export', '#', 'admin', '2022-02-14 15:33:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2084, 'spu管理', 2331, 1, 'spuInfo', 'product/spuInfo/index', NULL, 1, 0, 'C', '0', '0', 'product:spuInfo:list', '#', 'admin', '2022-02-14 15:33:17', 'admin', '2022-02-15 09:19:47', 'spu信息菜单');
INSERT INTO `sys_menu` VALUES (2085, 'spu信息查询', 2084, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfo:query', '#', 'admin', '2022-02-14 15:33:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2086, 'spu信息新增', 2084, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfo:add', '#', 'admin', '2022-02-14 15:33:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2087, 'spu信息修改', 2084, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfo:edit', '#', 'admin', '2022-02-14 15:33:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2088, 'spu信息删除', 2084, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfo:remove', '#', 'admin', '2022-02-14 15:33:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2089, 'spu信息导出', 2084, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'product:spuInfo:export', '#', 'admin', '2022-02-14 15:33:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2090, '商品系统', 0, 1, 'product', NULL, NULL, 1, 0, 'M', '0', '0', NULL, '06product', 'admin', '2022-02-14 16:24:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2091, '优惠营销', 0, 2, 'coupon', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'coupon', 'admin', '2022-02-14 16:25:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2092, '库存系统', 0, 3, 'ware', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'ware', 'admin', '2022-02-14 16:27:00', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2093, '订单系统', 0, 4, 'order', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'order01', 'admin', '2022-02-14 16:28:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2094, '平台属性', 2090, 3, 'platform-attrEntity', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'date', 'admin', '2022-02-14 16:46:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2097, '内容管理', 0, 6, 'content', NULL, NULL, 1, 0, 'M', '0', '0', '', 'excel', 'admin', '2022-02-14 16:51:31', 'admin', '2022-02-15 09:12:33', '');
INSERT INTO `sys_menu` VALUES (2098, '发放记录', 2091, 2, 'couponHistory', 'coupon/couponHistory/index', NULL, 1, 0, 'C', '0', '0', 'coupon:couponHistory:list', '#', 'admin', '2022-02-14 17:16:21', 'admin', '2022-02-15 08:57:41', '优惠券领取历史记录菜单');
INSERT INTO `sys_menu` VALUES (2099, '优惠券领取历史记录查询', 2098, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponHistory:query', '#', 'admin', '2022-02-14 17:16:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2100, '优惠券领取历史记录新增', 2098, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponHistory:add', '#', 'admin', '2022-02-14 17:16:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2101, '优惠券领取历史记录修改', 2098, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponHistory:edit', '#', 'admin', '2022-02-14 17:16:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2102, '优惠券领取历史记录删除', 2098, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponHistory:remove', '#', 'admin', '2022-02-14 17:16:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2103, '优惠券领取历史记录导出', 2098, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponHistory:export', '#', 'admin', '2022-02-14 17:16:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2104, '优惠券管理', 2091, 1, 'coupon', 'coupon/coupon/index', NULL, 1, 0, 'C', '0', '0', 'coupon:coupon:list', '#', 'admin', '2022-02-14 17:16:29', 'admin', '2022-02-15 08:56:47', '优惠券信息菜单');
INSERT INTO `sys_menu` VALUES (2105, '优惠券信息查询', 2104, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:coupon:query', '#', 'admin', '2022-02-14 17:16:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2106, '优惠券信息新增', 2104, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:coupon:add', '#', 'admin', '2022-02-14 17:16:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2107, '优惠券信息修改', 2104, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:coupon:edit', '#', 'admin', '2022-02-14 17:16:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2108, '优惠券信息删除', 2104, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:coupon:remove', '#', 'admin', '2022-02-14 17:16:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2109, '优惠券信息导出', 2104, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:coupon:export', '#', 'admin', '2022-02-14 17:16:29', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2110, '优惠券分类关联', 2091, 1, 'couponSpuCategoryRelation', 'coupon/couponSpuCategoryRelation/index', NULL, 1, 0, 'C', '0', '1', 'coupon:couponSpuCategoryRelation:list', '#', 'admin', '2022-02-14 17:16:45', 'admin', '2022-02-15 09:00:58', '优惠券分类关联菜单');
INSERT INTO `sys_menu` VALUES (2111, '优惠券分类关联查询', 2110, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuCategoryRelation:query', '#', 'admin', '2022-02-14 17:16:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2112, '优惠券分类关联新增', 2110, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuCategoryRelation:add', '#', 'admin', '2022-02-14 17:16:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2113, '优惠券分类关联修改', 2110, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuCategoryRelation:edit', '#', 'admin', '2022-02-14 17:16:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2114, '优惠券分类关联删除', 2110, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuCategoryRelation:remove', '#', 'admin', '2022-02-14 17:16:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2115, '优惠券分类关联导出', 2110, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuCategoryRelation:export', '#', 'admin', '2022-02-14 17:16:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2116, '优惠券与产品关联', 2091, 1, 'couponSpuRelation', 'coupon/couponSpuRelation/index', NULL, 1, 0, 'C', '0', '1', 'coupon:couponSpuRelation:list', '#', 'admin', '2022-02-14 17:16:54', 'admin', '2022-02-15 09:01:03', '优惠券与产品关联菜单');
INSERT INTO `sys_menu` VALUES (2117, '优惠券与产品关联查询', 2116, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuRelation:query', '#', 'admin', '2022-02-14 17:16:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2118, '优惠券与产品关联新增', 2116, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuRelation:add', '#', 'admin', '2022-02-14 17:16:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2119, '优惠券与产品关联修改', 2116, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuRelation:edit', '#', 'admin', '2022-02-14 17:16:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2120, '优惠券与产品关联删除', 2116, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuRelation:remove', '#', 'admin', '2022-02-14 17:16:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2121, '优惠券与产品关联导出', 2116, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:couponSpuRelation:export', '#', 'admin', '2022-02-14 17:16:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2122, '首页轮播广告', 2091, 1, 'homeAdv', 'coupon/homeAdv/index', NULL, 1, 0, 'C', '0', '1', 'coupon:homeAdv:list', '#', 'admin', '2022-02-14 17:17:02', 'admin', '2022-02-15 09:01:07', '首页轮播广告菜单');
INSERT INTO `sys_menu` VALUES (2123, '首页轮播广告查询', 2122, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeAdv:query', '#', 'admin', '2022-02-14 17:17:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2124, '首页轮播广告新增', 2122, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeAdv:add', '#', 'admin', '2022-02-14 17:17:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2125, '首页轮播广告修改', 2122, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeAdv:edit', '#', 'admin', '2022-02-14 17:17:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2126, '首页轮播广告删除', 2122, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeAdv:remove', '#', 'admin', '2022-02-14 17:17:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2127, '首页轮播广告导出', 2122, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeAdv:export', '#', 'admin', '2022-02-14 17:17:02', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2128, '专题活动', 2091, 3, 'homeSubject', 'coupon/homeSubject/index', NULL, 1, 0, 'C', '0', '0', 'coupon:homeSubject:list', '#', 'admin', '2022-02-14 17:17:10', 'admin', '2022-02-15 09:00:42', '首页专题菜单');
INSERT INTO `sys_menu` VALUES (2129, '首页专题查询', 2128, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubject:query', '#', 'admin', '2022-02-14 17:17:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2130, '首页专题新增', 2128, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubject:add', '#', 'admin', '2022-02-14 17:17:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2131, '首页专题修改', 2128, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubject:edit', '#', 'admin', '2022-02-14 17:17:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2132, '首页专题删除', 2128, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubject:remove', '#', 'admin', '2022-02-14 17:17:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2133, '首页专题导出', 2128, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubject:export', '#', 'admin', '2022-02-14 17:17:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2134, '专题商品', 2091, 1, 'homeSubjectSpu', 'coupon/homeSubjectSpu/index', NULL, 1, 0, 'C', '0', '1', 'coupon:homeSubjectSpu:list', '#', 'admin', '2022-02-14 17:17:18', 'admin', '2022-02-15 09:01:13', '专题商品菜单');
INSERT INTO `sys_menu` VALUES (2135, '专题商品查询', 2134, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubjectSpu:query', '#', 'admin', '2022-02-14 17:17:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2136, '专题商品新增', 2134, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubjectSpu:add', '#', 'admin', '2022-02-14 17:17:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2137, '专题商品修改', 2134, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubjectSpu:edit', '#', 'admin', '2022-02-14 17:17:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2138, '专题商品删除', 2134, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubjectSpu:remove', '#', 'admin', '2022-02-14 17:17:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2139, '专题商品导出', 2134, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:homeSubjectSpu:export', '#', 'admin', '2022-02-14 17:17:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2140, '会员价格', 2091, 7, 'memberPrice', 'coupon/memberPrice/index', NULL, 1, 0, 'C', '0', '0', 'coupon:memberPrice:list', '#', 'admin', '2022-02-14 17:17:26', 'admin', '2022-02-15 09:16:57', '商品会员价格菜单');
INSERT INTO `sys_menu` VALUES (2141, '商品会员价格查询', 2140, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:memberPrice:query', '#', 'admin', '2022-02-14 17:17:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2142, '商品会员价格新增', 2140, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:memberPrice:add', '#', 'admin', '2022-02-14 17:17:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2143, '商品会员价格修改', 2140, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:memberPrice:edit', '#', 'admin', '2022-02-14 17:17:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2144, '商品会员价格删除', 2140, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:memberPrice:remove', '#', 'admin', '2022-02-14 17:17:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2145, '商品会员价格导出', 2140, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:memberPrice:export', '#', 'admin', '2022-02-14 17:17:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2146, '秒杀活动', 2091, 4, 'seckillPromotion', 'coupon/seckillPromotion/index', NULL, 1, 0, 'C', '0', '0', 'coupon:seckillPromotion:list', '#', 'admin', '2022-02-14 17:17:34', 'admin', '2022-02-15 08:58:02', '秒杀活动菜单');
INSERT INTO `sys_menu` VALUES (2147, '秒杀活动查询', 2146, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillPromotion:query', '#', 'admin', '2022-02-14 17:17:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2148, '秒杀活动新增', 2146, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillPromotion:add', '#', 'admin', '2022-02-14 17:17:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2149, '秒杀活动修改', 2146, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillPromotion:edit', '#', 'admin', '2022-02-14 17:17:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2150, '秒杀活动删除', 2146, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillPromotion:remove', '#', 'admin', '2022-02-14 17:17:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2151, '秒杀活动导出', 2146, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillPromotion:export', '#', 'admin', '2022-02-14 17:17:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2152, '每日秒杀', 2091, 8, 'seckillSession', 'coupon/seckillSession/index', NULL, 1, 0, 'C', '0', '0', 'coupon:seckillSession:list', '#', 'admin', '2022-02-14 17:17:41', 'admin', '2022-02-15 09:17:25', '秒杀活动场次菜单');
INSERT INTO `sys_menu` VALUES (2153, '秒杀活动场次查询', 2152, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSession:query', '#', 'admin', '2022-02-14 17:17:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2154, '秒杀活动场次新增', 2152, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSession:add', '#', 'admin', '2022-02-14 17:17:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2155, '秒杀活动场次修改', 2152, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSession:edit', '#', 'admin', '2022-02-14 17:17:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2156, '秒杀活动场次删除', 2152, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSession:remove', '#', 'admin', '2022-02-14 17:17:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2157, '秒杀活动场次导出', 2152, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSession:export', '#', 'admin', '2022-02-14 17:17:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2158, '秒杀商品通知订阅', 2091, 1, 'seckillSkuNotice', 'coupon/seckillSkuNotice/index', NULL, 1, 0, 'C', '0', '1', 'coupon:seckillSkuNotice:list', '#', 'admin', '2022-02-14 17:17:49', 'admin', '2022-02-15 09:01:27', '秒杀商品通知订阅菜单');
INSERT INTO `sys_menu` VALUES (2159, '秒杀商品通知订阅查询', 2158, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuNotice:query', '#', 'admin', '2022-02-14 17:17:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2160, '秒杀商品通知订阅新增', 2158, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuNotice:add', '#', 'admin', '2022-02-14 17:17:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2161, '秒杀商品通知订阅修改', 2158, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuNotice:edit', '#', 'admin', '2022-02-14 17:17:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2162, '秒杀商品通知订阅删除', 2158, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuNotice:remove', '#', 'admin', '2022-02-14 17:17:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2163, '秒杀商品通知订阅导出', 2158, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuNotice:export', '#', 'admin', '2022-02-14 17:17:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2164, '秒杀活动商品关联', 2091, 1, 'seckillSkuRelation', 'coupon/seckillSkuRelation/index', NULL, 1, 0, 'C', '0', '1', 'coupon:seckillSkuRelation:list', '#', 'admin', '2022-02-14 17:17:57', 'admin', '2022-02-15 09:01:31', '秒杀活动商品关联菜单');
INSERT INTO `sys_menu` VALUES (2165, '秒杀活动商品关联查询', 2164, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuRelation:query', '#', 'admin', '2022-02-14 17:17:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2166, '秒杀活动商品关联新增', 2164, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuRelation:add', '#', 'admin', '2022-02-14 17:17:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2167, '秒杀活动商品关联修改', 2164, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuRelation:edit', '#', 'admin', '2022-02-14 17:17:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2168, '秒杀活动商品关联删除', 2164, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuRelation:remove', '#', 'admin', '2022-02-14 17:17:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2169, '秒杀活动商品关联导出', 2164, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:seckillSkuRelation:export', '#', 'admin', '2022-02-14 17:17:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2170, '满减折扣', 2091, 6, 'skuFullReduction', 'coupon/skuFullReduction/index', NULL, 1, 0, 'C', '0', '0', 'coupon:skuFullReduction:list', '#', 'admin', '2022-02-14 17:18:05', 'admin', '2022-02-15 09:00:09', '商品满减信息菜单');
INSERT INTO `sys_menu` VALUES (2171, '商品满减信息查询', 2170, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuFullReduction:query', '#', 'admin', '2022-02-14 17:18:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2172, '商品满减信息新增', 2170, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuFullReduction:add', '#', 'admin', '2022-02-14 17:18:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2173, '商品满减信息修改', 2170, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuFullReduction:edit', '#', 'admin', '2022-02-14 17:18:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2174, '商品满减信息删除', 2170, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuFullReduction:remove', '#', 'admin', '2022-02-14 17:18:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2175, '商品满减信息导出', 2170, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuFullReduction:export', '#', 'admin', '2022-02-14 17:18:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2176, '商品阶梯价格', 2091, 1, 'skuLadder', 'coupon/skuLadder/index', NULL, 1, 0, 'C', '0', '1', 'coupon:skuLadder:list', '#', 'admin', '2022-02-14 17:18:13', 'admin', '2022-02-15 09:01:34', '商品阶梯价格菜单');
INSERT INTO `sys_menu` VALUES (2177, '商品阶梯价格查询', 2176, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuLadder:query', '#', 'admin', '2022-02-14 17:18:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2178, '商品阶梯价格新增', 2176, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuLadder:add', '#', 'admin', '2022-02-14 17:18:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2179, '商品阶梯价格修改', 2176, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuLadder:edit', '#', 'admin', '2022-02-14 17:18:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2180, '商品阶梯价格删除', 2176, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuLadder:remove', '#', 'admin', '2022-02-14 17:18:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2181, '商品阶梯价格导出', 2176, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:skuLadder:export', '#', 'admin', '2022-02-14 17:18:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2182, '积分维护', 2091, 5, 'spuBounds', 'coupon/spuBounds/index', NULL, 1, 0, 'C', '0', '0', 'coupon:spuBounds:list', '#', 'admin', '2022-02-14 17:18:20', 'admin', '2022-02-15 08:58:39', '商品spu积分设置菜单');
INSERT INTO `sys_menu` VALUES (2183, '商品spu积分设置查询', 2182, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:spuBounds:query', '#', 'admin', '2022-02-14 17:18:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2184, '商品spu积分设置新增', 2182, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:spuBounds:add', '#', 'admin', '2022-02-14 17:18:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2185, '商品spu积分设置修改', 2182, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:spuBounds:edit', '#', 'admin', '2022-02-14 17:18:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2186, '商品spu积分设置删除', 2182, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:spuBounds:remove', '#', 'admin', '2022-02-14 17:18:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2187, '商品spu积分设置导出', 2182, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'coupon:spuBounds:export', '#', 'admin', '2022-02-14 17:18:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2188, '积分变化', 2242, 3, 'growthChangeHistory', 'member/growthChangeHistory/index', NULL, 1, 0, 'C', '0', '0', 'member:growthChangeHistory:list', '#', 'admin', '2022-02-14 17:30:08', 'admin', '2022-02-15 09:14:12', '成长值变化历史记录菜单');
INSERT INTO `sys_menu` VALUES (2189, '成长值变化历史记录查询', 2188, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:growthChangeHistory:query', '#', 'admin', '2022-02-14 17:30:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2190, '成长值变化历史记录新增', 2188, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:growthChangeHistory:add', '#', 'admin', '2022-02-14 17:30:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2191, '成长值变化历史记录修改', 2188, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:growthChangeHistory:edit', '#', 'admin', '2022-02-14 17:30:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2192, '成长值变化历史记录删除', 2188, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:growthChangeHistory:remove', '#', 'admin', '2022-02-14 17:30:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2193, '成长值变化历史记录导出', 2188, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:growthChangeHistory:export', '#', 'admin', '2022-02-14 17:30:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2194, '积分变化历史记录', 2242, 1, 'integrationChangeHistory', 'member/integrationChangeHistory/index', NULL, 1, 0, 'C', '0', '1', 'member:integrationChangeHistory:list', '#', 'admin', '2022-02-14 17:30:19', 'admin', '2022-02-15 09:15:07', '积分变化历史记录菜单');
INSERT INTO `sys_menu` VALUES (2195, '积分变化历史记录查询', 2194, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:integrationChangeHistory:query', '#', 'admin', '2022-02-14 17:30:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2196, '积分变化历史记录新增', 2194, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:integrationChangeHistory:add', '#', 'admin', '2022-02-14 17:30:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2197, '积分变化历史记录修改', 2194, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:integrationChangeHistory:edit', '#', 'admin', '2022-02-14 17:30:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2198, '积分变化历史记录删除', 2194, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:integrationChangeHistory:remove', '#', 'admin', '2022-02-14 17:30:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2199, '积分变化历史记录导出', 2194, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:integrationChangeHistory:export', '#', 'admin', '2022-02-14 17:30:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2200, '会员收藏的商品', 2242, 1, 'memberCollectSpu', 'member/memberCollectSpu/index', NULL, 1, 0, 'C', '0', '1', 'member:memberCollectSpu:list', '#', 'admin', '2022-02-14 17:30:28', 'admin', '2022-02-15 09:15:04', '会员收藏的商品菜单');
INSERT INTO `sys_menu` VALUES (2201, '会员收藏的商品查询', 2200, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSpu:query', '#', 'admin', '2022-02-14 17:30:28', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2202, '会员收藏的商品新增', 2200, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSpu:add', '#', 'admin', '2022-02-14 17:30:28', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2203, '会员收藏的商品修改', 2200, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSpu:edit', '#', 'admin', '2022-02-14 17:30:28', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2204, '会员收藏的商品删除', 2200, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSpu:remove', '#', 'admin', '2022-02-14 17:30:28', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2205, '会员收藏的商品导出', 2200, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSpu:export', '#', 'admin', '2022-02-14 17:30:28', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2206, '会员收藏的专题活动', 2242, 1, 'memberCollectSubject', 'member/memberCollectSubject/index', NULL, 1, 0, 'C', '0', '1', 'member:memberCollectSubject:list', '#', 'admin', '2022-02-14 17:30:38', 'admin', '2022-02-15 09:14:59', '会员收藏的专题活动菜单');
INSERT INTO `sys_menu` VALUES (2207, '会员收藏的专题活动查询', 2206, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSubject:query', '#', 'admin', '2022-02-14 17:30:38', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2208, '会员收藏的专题活动新增', 2206, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSubject:add', '#', 'admin', '2022-02-14 17:30:38', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2209, '会员收藏的专题活动修改', 2206, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSubject:edit', '#', 'admin', '2022-02-14 17:30:38', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2210, '会员收藏的专题活动删除', 2206, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSubject:remove', '#', 'admin', '2022-02-14 17:30:38', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2211, '会员收藏的专题活动导出', 2206, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberCollectSubject:export', '#', 'admin', '2022-02-14 17:30:38', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2212, '会员等级', 2242, 2, 'memberLevel', 'member/memberLevel/index', NULL, 1, 0, 'C', '0', '0', 'member:memberLevel:list', '#', 'admin', '2022-02-14 17:30:45', 'admin', '2022-02-15 09:13:32', '会员等级菜单');
INSERT INTO `sys_menu` VALUES (2213, '会员等级查询', 2212, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLevel:query', '#', 'admin', '2022-02-14 17:30:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2214, '会员等级新增', 2212, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLevel:add', '#', 'admin', '2022-02-14 17:30:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2215, '会员等级修改', 2212, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLevel:edit', '#', 'admin', '2022-02-14 17:30:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2216, '会员等级删除', 2212, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLevel:remove', '#', 'admin', '2022-02-14 17:30:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2217, '会员等级导出', 2212, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLevel:export', '#', 'admin', '2022-02-14 17:30:45', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2218, '会员登录记录', 2242, 1, 'memberLoginLog', 'member/memberLoginLog/index', NULL, 1, 0, 'C', '0', '1', 'member:memberLoginLog:list', '#', 'admin', '2022-02-14 17:30:55', 'admin', '2022-02-15 09:14:48', '会员登录记录菜单');
INSERT INTO `sys_menu` VALUES (2219, '会员登录记录查询', 2218, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLoginLog:query', '#', 'admin', '2022-02-14 17:30:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2220, '会员登录记录新增', 2218, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLoginLog:add', '#', 'admin', '2022-02-14 17:30:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2221, '会员登录记录修改', 2218, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLoginLog:edit', '#', 'admin', '2022-02-14 17:30:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2222, '会员登录记录删除', 2218, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLoginLog:remove', '#', 'admin', '2022-02-14 17:30:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2223, '会员登录记录导出', 2218, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberLoginLog:export', '#', 'admin', '2022-02-14 17:30:55', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2224, '会员列表', 2242, 1, 'member', 'member/member/index', NULL, 1, 0, 'C', '0', '0', 'member:member:list', '#', 'admin', '2022-02-14 17:31:04', 'admin', '2022-02-15 09:13:20', '会员菜单');
INSERT INTO `sys_menu` VALUES (2225, '会员查询', 2224, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:member:query', '#', 'admin', '2022-02-14 17:31:04', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2226, '会员新增', 2224, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:member:add', '#', 'admin', '2022-02-14 17:31:04', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2227, '会员修改', 2224, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:member:edit', '#', 'admin', '2022-02-14 17:31:04', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2228, '会员删除', 2224, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:member:remove', '#', 'admin', '2022-02-14 17:31:04', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2229, '会员导出', 2224, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:member:export', '#', 'admin', '2022-02-14 17:31:04', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2230, '会员收货地址', 2242, 1, 'memberReceiveAddress', 'member/memberReceiveAddress/index', NULL, 1, 0, 'C', '0', '1', 'member:memberReceiveAddress:list', '#', 'admin', '2022-02-14 17:31:11', 'admin', '2022-02-15 09:14:41', '会员收货地址菜单');
INSERT INTO `sys_menu` VALUES (2231, '会员收货地址查询', 2230, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberReceiveAddress:query', '#', 'admin', '2022-02-14 17:31:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2232, '会员收货地址新增', 2230, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberReceiveAddress:add', '#', 'admin', '2022-02-14 17:31:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2233, '会员收货地址修改', 2230, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberReceiveAddress:edit', '#', 'admin', '2022-02-14 17:31:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2234, '会员收货地址删除', 2230, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberReceiveAddress:remove', '#', 'admin', '2022-02-14 17:31:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2235, '会员收货地址导出', 2230, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberReceiveAddress:export', '#', 'admin', '2022-02-14 17:31:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2236, '统计信息', 2242, 4, 'memberStatisticsInfo', 'member/memberStatisticsInfo/index', NULL, 1, 0, 'C', '0', '0', 'member:memberStatisticsInfo:list', '#', 'admin', '2022-02-14 17:31:21', 'admin', '2022-02-15 09:14:31', '会员统计信息菜单');
INSERT INTO `sys_menu` VALUES (2237, '会员统计信息查询', 2236, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberStatisticsInfo:query', '#', 'admin', '2022-02-14 17:31:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2238, '会员统计信息新增', 2236, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberStatisticsInfo:add', '#', 'admin', '2022-02-14 17:31:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2239, '会员统计信息修改', 2236, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberStatisticsInfo:edit', '#', 'admin', '2022-02-14 17:31:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2240, '会员统计信息删除', 2236, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberStatisticsInfo:remove', '#', 'admin', '2022-02-14 17:31:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2241, '会员统计信息导出', 2236, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'member:memberStatisticsInfo:export', '#', 'admin', '2022-02-14 17:31:21', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2242, '用户系统', 0, 5, 'member', NULL, NULL, 1, 0, 'M', '0', '0', '', 'user', 'admin', '2022-02-14 18:10:14', 'admin', '2022-02-15 09:12:39', '');
INSERT INTO `sys_menu` VALUES (2243, '采购信息详情', 2330, 1, 'purchaseDetail', 'ware/purchaseDetail/index', NULL, 1, 0, 'C', '0', '0', 'ware:purchaseDetail:list', '#', 'admin', '2022-02-15 08:41:32', 'admin', '2022-02-15 09:07:54', '采购信息详情菜单');
INSERT INTO `sys_menu` VALUES (2244, '采购信息详情查询', 2243, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchaseDetail:query', '#', 'admin', '2022-02-15 08:41:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2245, '采购信息详情新增', 2243, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchaseDetail:add', '#', 'admin', '2022-02-15 08:41:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2246, '采购信息详情修改', 2243, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchaseDetail:edit', '#', 'admin', '2022-02-15 08:41:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2247, '采购信息详情删除', 2243, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchaseDetail:remove', '#', 'admin', '2022-02-15 08:41:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2248, '采购信息详情导出', 2243, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchaseDetail:export', '#', 'admin', '2022-02-15 08:41:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2249, '采购单', 2330, 1, 'purchase', 'ware/purchase/index', NULL, 1, 0, 'C', '0', '0', 'ware:purchase:list', '#', 'admin', '2022-02-15 08:41:41', 'admin', '2022-02-15 09:07:19', '采购信息菜单');
INSERT INTO `sys_menu` VALUES (2250, '采购信息查询', 2249, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchase:query', '#', 'admin', '2022-02-15 08:41:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2251, '采购信息新增', 2249, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchase:add', '#', 'admin', '2022-02-15 08:41:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2252, '采购信息修改', 2249, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchase:edit', '#', 'admin', '2022-02-15 08:41:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2253, '采购信息删除', 2249, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchase:remove', '#', 'admin', '2022-02-15 08:41:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2254, '采购信息导出', 2249, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:purchase:export', '#', 'admin', '2022-02-15 08:41:41', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2255, '仓库维护', 2092, 1, 'wareInfo', 'ware/wareInfo/index', NULL, 1, 0, 'C', '0', '0', 'ware:wareInfo:list', '#', 'admin', '2022-02-15 08:41:50', 'admin', '2022-02-15 09:03:12', '仓库信息菜单');
INSERT INTO `sys_menu` VALUES (2256, '仓库信息查询', 2255, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareInfo:query', '#', 'admin', '2022-02-15 08:41:50', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2257, '仓库信息新增', 2255, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareInfo:add', '#', 'admin', '2022-02-15 08:41:50', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2258, '仓库信息修改', 2255, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareInfo:edit', '#', 'admin', '2022-02-15 08:41:50', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2259, '仓库信息删除', 2255, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareInfo:remove', '#', 'admin', '2022-02-15 08:41:50', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2260, '仓库信息导出', 2255, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareInfo:export', '#', 'admin', '2022-02-15 08:41:50', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2261, '库存工作单详情', 2092, 1, 'wareOrderTaskDetail', 'ware/wareOrderTaskDetail/index', NULL, 1, 0, 'C', '0', '1', 'ware:wareOrderTaskDetail:list', '#', 'admin', '2022-02-15 08:41:57', 'admin', '2022-02-15 09:03:35', '库存工作单详情菜单');
INSERT INTO `sys_menu` VALUES (2262, '库存工作单详情查询', 2261, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTaskDetail:query', '#', 'admin', '2022-02-15 08:41:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2263, '库存工作单详情新增', 2261, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTaskDetail:add', '#', 'admin', '2022-02-15 08:41:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2264, '库存工作单详情修改', 2261, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTaskDetail:edit', '#', 'admin', '2022-02-15 08:41:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2265, '库存工作单详情删除', 2261, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTaskDetail:remove', '#', 'admin', '2022-02-15 08:41:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2266, '库存工作单详情导出', 2261, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTaskDetail:export', '#', 'admin', '2022-02-15 08:41:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2267, '库存工作单', 2092, 2, 'wareOrderTask', 'ware/wareOrderTask/index', NULL, 1, 0, 'C', '0', '0', 'ware:wareOrderTask:list', '#', 'admin', '2022-02-15 08:42:10', 'admin', '2022-02-15 09:03:27', '库存工作单菜单');
INSERT INTO `sys_menu` VALUES (2268, '库存工作单查询', 2267, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTask:query', '#', 'admin', '2022-02-15 08:42:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2269, '库存工作单新增', 2267, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTask:add', '#', 'admin', '2022-02-15 08:42:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2270, '库存工作单修改', 2267, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTask:edit', '#', 'admin', '2022-02-15 08:42:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2271, '库存工作单删除', 2267, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTask:remove', '#', 'admin', '2022-02-15 08:42:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2272, '库存工作单导出', 2267, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareOrderTask:export', '#', 'admin', '2022-02-15 08:42:10', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2273, '商品库存', 2092, 3, 'wareSku', 'ware/wareSku/index', NULL, 1, 0, 'C', '0', '0', 'ware:wareSku:list', '#', 'admin', '2022-02-15 08:42:19', 'admin', '2022-02-15 09:03:48', '商品库存菜单');
INSERT INTO `sys_menu` VALUES (2274, '商品库存查询', 2273, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareSku:query', '#', 'admin', '2022-02-15 08:42:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2275, '商品库存新增', 2273, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareSku:add', '#', 'admin', '2022-02-15 08:42:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2276, '商品库存修改', 2273, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareSku:edit', '#', 'admin', '2022-02-15 08:42:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2277, '商品库存删除', 2273, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareSku:remove', '#', 'admin', '2022-02-15 08:42:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2278, '商品库存导出', 2273, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'ware:wareSku:export', '#', 'admin', '2022-02-15 08:42:19', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2279, '支付流水查询', 2093, 4, 'orderItem', 'order/orderItem/index', NULL, 1, 0, 'C', '0', '0', 'order:orderItem:list', '#', 'admin', '2022-02-15 08:50:11', 'admin', '2022-02-15 09:11:53', '订单项信息菜单');
INSERT INTO `sys_menu` VALUES (2280, '订单项信息查询', 2279, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderItem:query', '#', 'admin', '2022-02-15 08:50:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2281, '订单项信息新增', 2279, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderItem:add', '#', 'admin', '2022-02-15 08:50:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2282, '订单项信息修改', 2279, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderItem:edit', '#', 'admin', '2022-02-15 08:50:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2283, '订单项信息删除', 2279, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderItem:remove', '#', 'admin', '2022-02-15 08:50:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2284, '订单项信息导出', 2279, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderItem:export', '#', 'admin', '2022-02-15 08:50:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2285, '订单查询', 2093, 1, 'order', 'order/order/index', NULL, 1, 0, 'C', '0', '0', 'order:order:list', '#', 'admin', '2022-02-15 08:50:36', 'admin', '2022-02-15 09:09:08', '订单菜单');
INSERT INTO `sys_menu` VALUES (2286, '订单查询', 2285, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:order:query', '#', 'admin', '2022-02-15 08:50:36', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2287, '订单新增', 2285, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:order:add', '#', 'admin', '2022-02-15 08:50:36', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2288, '订单修改', 2285, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:order:edit', '#', 'admin', '2022-02-15 08:50:36', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2289, '订单删除', 2285, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:order:remove', '#', 'admin', '2022-02-15 08:50:36', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2290, '订单导出', 2285, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:order:export', '#', 'admin', '2022-02-15 08:50:36', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2291, '订单操作历史记录', 2093, 1, 'orderOperateHistory', 'order/orderOperateHistory/index', NULL, 1, 0, 'C', '0', '1', 'order:orderOperateHistory:list', '#', 'admin', '2022-02-15 08:50:47', 'admin', '2022-02-15 09:12:04', '订单操作历史记录菜单');
INSERT INTO `sys_menu` VALUES (2292, '订单操作历史记录查询', 2291, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderOperateHistory:query', '#', 'admin', '2022-02-15 08:50:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2293, '订单操作历史记录新增', 2291, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderOperateHistory:add', '#', 'admin', '2022-02-15 08:50:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2294, '订单操作历史记录修改', 2291, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderOperateHistory:edit', '#', 'admin', '2022-02-15 08:50:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2295, '订单操作历史记录删除', 2291, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderOperateHistory:remove', '#', 'admin', '2022-02-15 08:50:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2296, '订单操作历史记录导出', 2291, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderOperateHistory:export', '#', 'admin', '2022-02-15 08:50:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2297, '退货单处理', 2093, 2, 'orderReturnApply', 'order/orderReturnApply/index', NULL, 1, 0, 'C', '0', '0', 'order:orderReturnApply:list', '#', 'admin', '2022-02-15 08:50:56', 'admin', '2022-02-15 09:09:49', '订单退货申请菜单');
INSERT INTO `sys_menu` VALUES (2298, '订单退货申请查询', 2297, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnApply:query', '#', 'admin', '2022-02-15 08:50:56', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2299, '订单退货申请新增', 2297, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnApply:add', '#', 'admin', '2022-02-15 08:50:56', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2300, '订单退货申请修改', 2297, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnApply:edit', '#', 'admin', '2022-02-15 08:50:56', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2301, '订单退货申请删除', 2297, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnApply:remove', '#', 'admin', '2022-02-15 08:50:56', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2302, '订单退货申请导出', 2297, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnApply:export', '#', 'admin', '2022-02-15 08:50:56', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2303, '退货原因', 2093, 1, 'orderReturnReason', 'order/orderReturnReason/index', NULL, 1, 0, 'C', '0', '1', 'order:orderReturnReason:list', '#', 'admin', '2022-02-15 08:51:05', 'admin', '2022-02-15 09:12:07', '退货原因菜单');
INSERT INTO `sys_menu` VALUES (2304, '退货原因查询', 2303, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnReason:query', '#', 'admin', '2022-02-15 08:51:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2305, '退货原因新增', 2303, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnReason:add', '#', 'admin', '2022-02-15 08:51:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2306, '退货原因修改', 2303, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnReason:edit', '#', 'admin', '2022-02-15 08:51:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2307, '退货原因删除', 2303, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnReason:remove', '#', 'admin', '2022-02-15 08:51:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2308, '退货原因导出', 2303, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderReturnReason:export', '#', 'admin', '2022-02-15 08:51:05', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2309, '等级规则', 2093, 3, 'orderSetting', 'order/orderSetting/index', NULL, 1, 0, 'C', '0', '0', 'order:orderSetting:list', '#', 'admin', '2022-02-15 08:51:13', 'admin', '2022-02-15 09:10:26', '订单配置信息菜单');
INSERT INTO `sys_menu` VALUES (2310, '订单配置信息查询', 2309, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderSetting:query', '#', 'admin', '2022-02-15 08:51:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2311, '订单配置信息新增', 2309, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderSetting:add', '#', 'admin', '2022-02-15 08:51:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2312, '订单配置信息修改', 2309, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderSetting:edit', '#', 'admin', '2022-02-15 08:51:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2313, '订单配置信息删除', 2309, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderSetting:remove', '#', 'admin', '2022-02-15 08:51:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2314, '订单配置信息导出', 2309, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:orderSetting:export', '#', 'admin', '2022-02-15 08:51:13', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2315, '支付信息', 2093, 1, 'paymentInfo', 'order/paymentInfo/index', NULL, 1, 0, 'C', '0', '0', 'order:paymentInfo:list', '#', 'admin', '2022-02-15 08:51:20', '', NULL, '支付信息菜单');
INSERT INTO `sys_menu` VALUES (2316, '支付信息查询', 2315, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:paymentInfo:query', '#', 'admin', '2022-02-15 08:51:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2317, '支付信息新增', 2315, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:paymentInfo:add', '#', 'admin', '2022-02-15 08:51:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2318, '支付信息修改', 2315, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:paymentInfo:edit', '#', 'admin', '2022-02-15 08:51:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2319, '支付信息删除', 2315, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:paymentInfo:remove', '#', 'admin', '2022-02-15 08:51:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2320, '支付信息导出', 2315, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:paymentInfo:export', '#', 'admin', '2022-02-15 08:51:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2321, '退款流水查询', 2093, 5, 'refundInfo', 'order/refundInfo/index', NULL, 1, 0, 'C', '0', '0', 'order:refundInfo:list', '#', 'admin', '2022-02-15 08:51:26', 'admin', '2022-02-15 09:11:37', '退款信息菜单');
INSERT INTO `sys_menu` VALUES (2322, '退款信息查询', 2321, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:refundInfo:query', '#', 'admin', '2022-02-15 08:51:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2323, '退款信息新增', 2321, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:refundInfo:add', '#', 'admin', '2022-02-15 08:51:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2324, '退款信息修改', 2321, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:refundInfo:edit', '#', 'admin', '2022-02-15 08:51:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2325, '退款信息删除', 2321, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:refundInfo:remove', '#', 'admin', '2022-02-15 08:51:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2326, '退款信息导出', 2321, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'order:refundInfo:export', '#', 'admin', '2022-02-15 08:51:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2327, '首页推荐', 2097, 1, 'index', NULL, NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-02-15 08:54:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2328, '分类热门', 2097, 2, 'category', NULL, NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-02-15 08:54:35', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2329, '评论管理', 2097, 3, 'comments', NULL, NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-02-15 08:55:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2330, '采购单维护', 2092, 4, 'purchase-manage', NULL, NULL, 1, 0, 'M', '0', '0', NULL, '#', 'admin', '2022-02-15 09:07:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2331, '商品维护', 2090, 7, 'spu-manage', NULL, NULL, 1, 0, 'M', '0', '0', NULL, '#', 'admin', '2022-02-15 09:19:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2332, '发布商品', 2331, 2, 'todo1', NULL, NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-02-15 09:21:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2333, '商品管理', 2331, 3, 'todo2', NULL, NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-02-15 09:21:34', '', NULL, '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2022-02-08 09:21:46', '', NULL, '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2022-02-08 09:21:46', '', NULL, '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (1, '操作日志', 9, 'com.gulimall.system.controller.SysOperlogController.clean()', 'DELETE', 1, 'admin', NULL, '/operlog/clean', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-15 09:35:43');
INSERT INTO `sys_oper_log` VALUES (2, '登录日志', 3, 'com.gulimall.system.controller.SysLogininforController.clean()', 'DELETE', 1, 'admin', NULL, '/logininfor/clean', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-15 09:35:46');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2022-02-08 09:21:46', '', NULL, '');
INSERT INTO `sys_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2022-02-08 09:21:46', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-02-08 09:21:46', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-02-08 09:21:46', 'admin', '2022-02-09 09:36:36', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);
INSERT INTO `sys_role_dept` VALUES (2, 105);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '管理员', '00', 'admin@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-02-08 09:21:46', 'admin', '2022-02-08 09:21:46', '', '2022-02-09 09:39:49', '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '测试', '00', 'test@qq.com', '15666666666', '0', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-02-08 09:21:46', 'admin', '2022-02-08 09:21:46', 'admin', '2022-02-09 09:38:08', '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 2);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;

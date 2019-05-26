--- 新增表

-- ----------------------------
-- 系统资源表
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource_info`;
CREATE TABLE `sys_resource_info` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
    `sys_resource_uid` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '唯一键，关联键',
    `sys_resource_name` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '资源节点名字',
    `sys_resource_level` INT(4) DEFAULT NULL COMMENT '资源级别',
    `sys_resource_path` VARCHAR(128)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '资源操作url',
    `sys_parent_uid` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '父节点uid',
    `create_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建时间',
	  `create_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建用户',
    `update_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新时间',
    `update_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新用户uid',
    `is_delete` tinyint(2) DEFAULT 0 COMMENT '删除状态,0-正常；1-删除',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `sys_resource_uid` (`sys_resource_uid`) USING BTREE
)  ENGINE=INNODB;

-- ----------------------------
-- 系统角色表
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
    `sys_role_uid` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '唯一键，关联键',
    `sys_role_name` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '角色名字',
    `sys_role_desc` VARCHAR(128)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '角色描述',
    `create_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建时间',
    `create_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建用户',
    `update_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新时间',
    `update_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新用户uid',
    `is_delete` TINYINT(2) DEFAULT 0 COMMENT '删除状态,0-正常;1-删除',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `sys_role_uid` (`sys_role_uid`) USING BTREE
)  ENGINE=INNODB;

-- ----------------------------
-- 系统角色资源表
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
    `sys_role_uid` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '用户表uid',
    `sys_resource_uid` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '资源表uid',
    `create_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建时间',
    `create_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建用户',
    `update_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新时间',
    `update_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新用户uid',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `fk_role_resource1` (`sys_role_uid`) USING BTREE,
    INDEX `fk_role_resource2` (`sys_resource_uid`) USING BTREE,
    CONSTRAINT `fk_role_resource1` FOREIGN KEY (`sys_role_uid`)
        REFERENCES `sys_role_info` (`sys_role_uid`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_role_resource2` FOREIGN KEY (`sys_resource_uid`)
        REFERENCES `sys_resource_info` (`sys_resource_uid`)
        ON DELETE RESTRICT ON UPDATE RESTRICT
)  ENGINE=INNODB;

-- ----------------------------
-- 系统用户表
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `sys_user_uid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '唯一键，关联键',
  `sys_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `sys_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `sys_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `sys_birth` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出生年月',
  `sys_sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `sys_cert_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件类型',
  `sys_cert_val` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证件信息',
  `sys_user_prov` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Area的uid',
  `sys_prov_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省名称(冗余)',
  `sys_user_city` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市',
  `sys_city_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市名称(冗余)',
  `sys_user_img` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像地址前缀，图片加1.jpg,2.jpg',
  `sys_img_count` int(11) DEFAULT NULL COMMENT '头像张数',
  `create_time` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `create_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建用户',
  `update_time` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `update_emp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新用户uid',
  `is_delete` tinyint(2) DEFAULT 0 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_user_uid`(`sys_user_uid`) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- 系统用户角色表
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
    `sys_user_uid` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '用户表uid',
    `sys_role_uid` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '角色表uid',
    `create_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建时间',
    `create_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '创建用户',
    `update_time` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新时间',
    `update_emp` VARCHAR(40)CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI DEFAULT NULL COMMENT '更新用户uid',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `fk_user_role_uid1` (`sys_role_uid`) USING BTREE,
    INDEX `fk_user_role_uid2` (`sys_user_uid`) USING BTREE,
    CONSTRAINT `fk_user_role_uid1` FOREIGN KEY (`sys_role_uid`)
        REFERENCES `sys_role_info` (`sys_role_uid`)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_user_role_uid2` FOREIGN KEY (`sys_user_uid`)
        REFERENCES `sys_user_info` (`sys_user_uid`)
        ON DELETE RESTRICT ON UPDATE RESTRICT
)  ENGINE=INNODB;
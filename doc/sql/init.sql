CREATE DATABASE /*!32312 IF NOT EXISTS*/`wuniu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wuniu`;

CREATE TABLE `file_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `biz_code` varchar(8) DEFAULT NULL COMMENT '业务方编码',
  `url_hash` int(11) DEFAULT NULL COMMENT '文件路径的hash值',
  `fastdfs_group` varchar(16) DEFAULT NULL COMMENT 'fastdfs的组名',
  `fastdfs_name` varchar(32) DEFAULT NULL COMMENT 'fastdfs的文件名',
  `type` varchar(8) DEFAULT NULL COMMENT '文件类型，后缀名',
  `size` int(11) DEFAULT NULL COMMENT '文件大小kb',
  `scale_strategy` varchar(12) DEFAULT NULL COMMENT '缩放策略',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_url_hash` (`url_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件信息表';
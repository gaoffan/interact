CREATE TABLE `group`  (
       `id` int NOT NULL,
       `name` varchar(255) NOT NULL COMMENT '组名',
       `logo` varchar(255) NULL COMMENT '组logo url',
       `desc` varchar(255) NULL COMMENT '组描述',
       PRIMARY KEY (`id`)
)COMMENT = '组别表';
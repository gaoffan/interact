CREATE TABLE `issue_reply`  (
       `id` int NOT NULL AUTO_INCREMENT,
       `user_id` int NULL,
       `issue_id` int NULL,
       `content` text NULL COMMENT '内容',
       `created_at` timestamp(0) NULL COMMENT '创建时间',
       `updated_at` timestamp(0) NULL COMMENT '更新时间',
       PRIMARY KEY (`id`)
) COMMENT = '问答回复';
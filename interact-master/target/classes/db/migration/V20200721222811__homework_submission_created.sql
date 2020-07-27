CREATE TABLE `homework_submission`  (
       `id` int NOT NULL,
       `homework_id` int NOT NULL,
       `user_id` int NOT NULL,
       `content` mediumblob NULL COMMENT '内容（文件/代码）',
       `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '评价',
       `is_show` int NULL DEFAULT NULL COMMENT '是否作为优秀作业展示',
       `created_at` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
       `update_at` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
       PRIMARY KEY (`id`) USING BTREE,
       UNIQUE INDEX `uni`(`homework_id`, `user_id`) USING BTREE COMMENT '注意：一个人只能提交一次作业，第二次提交作为第一次的更新'

                                    )        COMMENT = '作业提交表';
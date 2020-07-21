CREATE TABLE `user`  (
       `id` int NOT NULL,
       `name` varchar(255) NULL COMMENT '真实姓名',
       `nick` varchar(255) NULL COMMENT '昵称',
       `student_id` varchar(255) NULL COMMENT '学号',
       `phone_number` varchar(255) NULL,
       `email` varchar(255) NOT NULL,
       `qq` varchar(255) NULL,
       `password` varchar(255) NOT NULL,
       `avatar` text NULL COMMENT '头像 base64',
       `role` int NOT NULL COMMENT '身份 （1root，2讲师，3助教，4部员）',
       `group_id` int NULL COMMENT '所属组',
       `created_at` timestamp(0) NOT NULL COMMENT '创建时间 注册时间',
       `updated_at` timestamp(0) NOT NULL COMMENT '更新时间 改密时间',
       PRIMARY KEY (`id`)
)COMMENT =  '用户表';
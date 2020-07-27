CREATE TABLE `lesson_signup`  (
       `id` int NOT NULL,
       `lesson_id` int NOT NULL,
       `user_id` int NOT NULL,
       `created_at` timestamp(0) NOT NULL COMMENT '签到时间',
       PRIMARY KEY (`id`)
)COMMENT = '课程签到表';
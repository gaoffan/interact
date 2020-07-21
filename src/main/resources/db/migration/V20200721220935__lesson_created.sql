CREATE TABLE `lesson`  (
       `id` int NOT NULL,
       `name` varchar(255) NOT NULL COMMENT '课程名称',
       `group_id` int NOT NULL COMMENT '组别id',
       `desc` varchar(255) NULL COMMENT '课程简介',
       `time` timestamp(0) NULL COMMENT '授课时间',
       `location` varchar(255) NULL COMMENT '课程地点',
       `type` int NULL COMMENT '类型 1为线下课 2为线上直播课',
       `live_url` varchar(255) NULL COMMENT '直播地址',
       `created_at` timestamp(0) NOT NULL COMMENT '创建时间',
       `updated_at` timestamp(0) NOT NULL COMMENT '更新时间',
       PRIMARY KEY (`id`)
) COMMENT = '课程表';
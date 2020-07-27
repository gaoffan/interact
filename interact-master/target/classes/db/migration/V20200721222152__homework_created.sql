CREATE TABLE `homework`  (
   `id` int NOT NULL,
   `lesson_id` int NULL,
   `group_id` int NULL COMMENT '组id',
   `owner` int NOT NULL COMMENT '发布人',
   `name` varchar(255) NOT NULL COMMENT '作业名称',
   `desc` varchar(255) NULL COMMENT '描述',
   `submit_type` int NOT NULL COMMENT '类型（1为文本/2为zip文件）',
   `time` timestamp(0) NOT NULL COMMENT '作业发布时间',
   `deadline` timestamp(0) NOT NULL COMMENT '截止时间',
   `created_at` timestamp(0) NOT NULL COMMENT '创建时间',
   `updated_at` timestamp(0) NOT NULL COMMENT '更新时间',
       PRIMARY KEY (`id`)
)COMMENT = '作业表';
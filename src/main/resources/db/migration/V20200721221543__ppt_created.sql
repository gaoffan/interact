CREATE TABLE `ppt`  (
       `id` int NOT NULL,
       `lesson_id` int NOT NULL,
       `content` mediumblob NULL COMMENT 'ppt内容 二进制',
       `file_name` text CHARACTER SET utf8mb4 NULL COMMENT '文件名称',
       `created_at` timestamp(0) NOT NULL,
       `updated_at` timestamp(0) NOT NULL,
       PRIMARY KEY (`id`)
)COMMENT = '课程ppt';

CREATE TABLE `ppt`  (
       `id` int NOT NULL,
       `lesson_id` int NOT NULL,
       `content` mediumblob NULL COMMENT 'ppt内容 二进制',
       `created_at` timestamp(0) NOT NULL,
       `updated_at` timestamp(0) NOT NULL,
       PRIMARY KEY (`id`)
)COMMENT = '课程ppt';
CREATE TABLE `interact`.`task`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `group_id` int(0) NOT NULL COMMENT '小组id',
  `content` text CHARACTER SET utf8mb4 NULL COMMENT '任务内容',
  `homework_id` int(0) NULL DEFAULT NULL COMMENT '绑定作业id，没有为null',
  `created_at` timestamp(0) NOT NULL COMMENT '创建时间',
  `updated_at` timestamp(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4;
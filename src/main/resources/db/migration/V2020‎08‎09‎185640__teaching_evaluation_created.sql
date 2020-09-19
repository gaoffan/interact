
DROP TABLE IF EXISTS `teaching_evaluation`;
CREATE TABLE `teaching_evaluation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) DEFAULT NULL COMMENT '课程id',
  `remark` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '评价内容',
  `created_at` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updated_at` timestamp(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '课程评价表';

SET FOREIGN_KEY_CHECKS = 1;

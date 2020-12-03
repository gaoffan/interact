
DROP TABLE IF EXISTS `anonymous`;
CREATE TABLE `anonymous`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `lesson_id` int(11) NOT NULL COMMENT '课程id',
  `created_at` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '匿名评价表';

SET FOREIGN_KEY_CHECKS = 1;

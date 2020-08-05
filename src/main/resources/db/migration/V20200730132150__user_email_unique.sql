ALTER TABLE `user`
    ADD UNIQUE INDEX `email_uni`(`email`) USING BTREE;
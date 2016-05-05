CREATE TABLE `mppproject`.`messageboard` (
  `id` INT NOT NULL,
  `type` VARCHAR(100) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) NULL,
  `studentid` INT NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `mppproject`.`messageboard` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;
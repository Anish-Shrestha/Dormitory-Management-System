CREATE TABLE `mppproject`.`usercredential` (
  `userid` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL);
  
  ALTER TABLE `mppproject`.`usercredential` 
ADD COLUMN `isAdmin` INT NOT NULL AFTER `password`;

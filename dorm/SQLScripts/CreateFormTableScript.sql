
use mppproject;

CREATE TABLE `mppproject`.`report` (
  `formId` INT NOT NULL,
  `studentId` INT NOT NULL,
  `roomNo` INT NOT NULL,
  `buildingNo` INT NOT NULL,
  `filledDate` datetime NOT NULL,
  `formType` VARCHAR(100) NOT NULL,
  `items` VARCHAR(500) NULL,
  PRIMARY KEY (`formId`));

ALTER TABLE `mppproject`.`report` 
CHANGE COLUMN `formId` `formId` INT(11) NOT NULL AUTO_INCREMENT ;
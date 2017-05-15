SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `socialnetwork` ;
CREATE SCHEMA IF NOT EXISTS `socialnetwork` DEFAULT CHARACTER SET utf8 ;
USE `socialnetwork` ;

-- -----------------------------------------------------
-- Table `socialnetwork`.`control`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `socialnetwork`.`control` ;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`control` (
  `idcontrol` INT NOT NULL AUTO_INCREMENT ,
  `type` VARCHAR(45) NULL ,
  PRIMARY KEY (`idcontrol`) )
ENGINE = InnoDB;

LOCK TABLES `control` WRITE;
/*!40000 ALTER TABLE `control` DISABLE KEYS */;
INSERT INTO `control` VALUES (1,'admin'),(2,'Арендодатель'),(3,'Арендатор');
/*!40000 ALTER TABLE `control` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `socialnetwork`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `socialnetwork`.`user` ;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT ,
  `nikname` VARCHAR(45) NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  `email` TEXT NULL DEFAULT NULL ,
  `surname` VARCHAR(45) NULL DEFAULT NULL ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `city` VARCHAR(45) NULL DEFAULT NULL ,
  `mobile` INT NULL DEFAULT NULL ,
  `idcontrol` INT(11) NOT NULL ,
  PRIMARY KEY (`iduser`) ,
  INDEX `fk_user_accessscontrol1` (`idcontrol` ASC) ,
  UNIQUE INDEX `nikname_UNIQUE` (`nikname` ASC) ,
  CONSTRAINT `fk_user_accessscontrol1`
    FOREIGN KEY (`idcontrol` )
    REFERENCES `socialnetwork`.`control` (`idcontrol` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `socialnetwork`.`apartment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `socialnetwork`.`apartment` ;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`apartment` (
  `idapartment` INT(11) NOT NULL AUTO_INCREMENT ,
  `document` TEXT NULL DEFAULT NULL ,
  `price` INT(11) NULL DEFAULT NULL ,
  `status` VARCHAR(45) NULL ,
  `rating` INT(11) NULL ,
  `description` TEXT NULL ,
  `iduser` INT(11) NOT NULL ,
  PRIMARY KEY (`idapartment`) ,
  INDEX `fk_apartment_user1` (`iduser` ASC) ,
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC) ,
  CONSTRAINT `fk_apartment_user1`
    FOREIGN KEY (`iduser` )
    REFERENCES `socialnetwork`.`user` (`iduser` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `socialnetwork`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `socialnetwork`.`comment` ;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`comment` (
  `idComments` INT(11) NOT NULL AUTO_INCREMENT ,
  `comment` TEXT NULL DEFAULT NULL ,
  `idcommentator` INT(11) NOT NULL ,
  `iduser` INT(11) NOT NULL ,
  PRIMARY KEY (`idComments`) ,
  INDEX `fk_comment_user1` (`iduser` ASC) ,
  INDEX `fk_comment_user2` (`idcommentator` ASC) ,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`iduser` )
    REFERENCES `socialnetwork`.`user` (`iduser` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_user2`
    FOREIGN KEY (`idcommentator` )
    REFERENCES `socialnetwork`.`user` (`iduser` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `socialnetwork`.`image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `socialnetwork`.`image` ;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`image` (
  `idimage` INT(11) NOT NULL AUTO_INCREMENT ,
  `image` TEXT NULL DEFAULT NULL ,
  `description` TEXT NULL DEFAULT NULL ,
  `idapartment` INT(11) NOT NULL ,
  PRIMARY KEY (`idimage`) ,
  INDEX `fk_imageapartments_apartment1` (`idapartment` ASC) ,
  CONSTRAINT `fk_imageapartments_apartment1`
    FOREIGN KEY (`idapartment` )
    REFERENCES `socialnetwork`.`apartment` (`idapartment` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `socialnetwork`.`likehouse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `socialnetwork`.`likehouse` ;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`likehouse` (
  `idlikehouse` INT NOT NULL AUTO_INCREMENT ,
  `idlandlord` INT(11) NOT NULL ,
  `idlessee` INT(11) NOT NULL ,
  `response` INT NULL ,
  PRIMARY KEY (`idlikehouse`) ,
  INDEX `fk_likehouse_user1` (`idlandlord` ASC) ,
  INDEX `fk_likehouse_user2` (`idlessee` ASC) ,
  CONSTRAINT `fk_likehouse_user1`
    FOREIGN KEY (`idlandlord` )
    REFERENCES `socialnetwork`.`user` (`iduser` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_likehouse_user2`
    FOREIGN KEY (`idlessee` )
    REFERENCES `socialnetwork`.`user` (`iduser` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `socialnetwork`.`story`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `socialnetwork`.`story` ;

CREATE  TABLE IF NOT EXISTS `socialnetwork`.`story` (
  `idstory` INT(11) NOT NULL AUTO_INCREMENT ,
  `idapartment` INT(11) NOT NULL ,
  `iduser` INT(11) NOT NULL ,
  PRIMARY KEY (`idstory`) ,
  INDEX `fk_storyApartment_apartment1` (`idapartment` ASC) ,
  INDEX `fk_storyApartment_user1` (`iduser` ASC) ,
  CONSTRAINT `fk_storyApartment_apartment1`
    FOREIGN KEY (`idapartment` )
    REFERENCES `socialnetwork`.`apartment` (`idapartment` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_storyApartment_user1`
    FOREIGN KEY (`iduser` )
    REFERENCES `socialnetwork`.`user` (`iduser` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

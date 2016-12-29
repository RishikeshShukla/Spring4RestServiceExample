-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema spring_rest_app
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema spring_rest_app
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spring_rest_app` DEFAULT CHARACTER SET utf8 ;
USE `spring_rest_app` ;

-- -----------------------------------------------------
-- Table `spring_rest_app`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring_rest_app`.`department` (
  `id` BIGINT(10) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring_rest_app`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring_rest_app`.`employee` (
  `id` BIGINT(10) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `age` INT NULL,
  `salary` DECIMAL NULL,
  `department_id` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC),
  INDEX `fk_employee_department_idx` (`department_id` ASC),
  CONSTRAINT `fk_employee_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `spring_rest_app`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring_rest_app`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring_rest_app`.`address` (
  `id` BIGINT(10) NOT NULL,
  `country_name` VARCHAR(45) NOT NULL,
  `city_name` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `pincode` VARCHAR(45) NOT NULL,
  `address_type` VARCHAR(45) NOT NULL,
  `employee_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_address_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `spring_rest_app`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

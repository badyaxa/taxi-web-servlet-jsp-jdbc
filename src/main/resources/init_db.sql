CREATE DATABASE  IF NOT EXISTS `taxi_service_db`;
USE `taxi_service_db`;

DROP TABLE IF EXISTS `manufacturers`;
CREATE TABLE `manufacturers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `country` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

INSERT INTO `manufacturers` (`id`, `name`, `country`) VALUES
(1,'Acura','Japan'),
(2,'Alfa Romeo','Italy'),
(3,'Audi','Germany'),
(4,'BMW','Germany'),
(5,'Ferrari','Italy'),
(6,'SEAT','Spain'),
(7,'Renault','France'),
(8,'Peugeot','France'),
(9,'Fiat','Italy'),
(10,'Honda','Japan'),
(11,'Lexus','Japan');

DELETE FROM `manufacturers` WHERE (`id` = '12');
DELETE FROM `manufacturers` WHERE (`id` = '13');
DELETE FROM `manufacturers` WHERE (`id` = '14');
DELETE FROM `manufacturers` WHERE (`id` = '15');
ALTER TABLE `manufacturers` AUTO_INCREMENT = 12;

SELECT * FROM taxi_service_db.manufacturers;

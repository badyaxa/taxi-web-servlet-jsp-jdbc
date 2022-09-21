CREATE SCHEMA IF NOT EXISTS `taxi_service` DEFAULT CHARACTER SET utf8;
USE `taxi_service`;

CREATE TABLE `manufacturers` (
                                        `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(225) NOT NULL,
                                        `country` VARCHAR(225) NOT NULL,
                                        `is_deleted` TINYINT NOT NULL DEFAULT 0,
                                        PRIMARY KEY (`id`));

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

SELECT * FROM taxi_service_db.manufacturers;

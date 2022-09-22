CREATE SCHEMA IF NOT EXISTS `taxi` DEFAULT CHARACTER SET utf8;
USE `taxi`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drivers
-- ----------------------------
DROP TABLE IF EXISTS `drivers`;
CREATE TABLE `drivers`  (
                            `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `license_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `is_deleted` bit(1) NOT NULL DEFAULT b'0',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `drivers` (`id`, `name`, `license_number`) VALUES
                                                           (1,'Ihor','123456789'),
                                                           (2,'Oleg','852741963');
-- ----------------------------
-- Table structure for manufacturers
-- ----------------------------
DROP TABLE IF EXISTS `manufacturers`;
CREATE TABLE `manufacturers`  (
                                  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                                  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
INSERT INTO `cars` (`manufacturer_id`, `model`) VALUES
                                                    ('3', 'A3'),
                                                    ('3', 'Q7'),
                                                    ('4', 'X5'),
                                                    ('4', 'X3');

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
-- ----------------------------
-- Table structure for cars
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars`  (
                         `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                         `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `manufacturer_id` bigint(0) UNSIGNED NOT NULL,
                         `is_deleted` bit(1) NOT NULL DEFAULT b'0',
                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `FK_manufacturer_id`(`manufacturer_id`) USING BTREE,
                         CONSTRAINT `FK_manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `taxi`.`cars` (`manufacturer_id`, `model`) VALUES
                                                           ('3', 'A3'),
                                                           ('3', 'Q7'),
                                                           ('4', 'X5'),
                                                           ('4', 'X3');
-- ----------------------------
-- Table structure for cars_drivers
-- ----------------------------
DROP TABLE IF EXISTS `cars_drivers`;
CREATE TABLE `cars_drivers`  (
                                 `car_id` bigint(0) UNSIGNED NOT NULL,
                                 `driver_id` bigint(0) UNSIGNED NOT NULL,
                                 PRIMARY KEY (`car_id`, `driver_id`) USING BTREE,
                                 INDEX `driver_id`(`driver_id`) USING BTREE,
                                 INDEX `car_id`(`car_id`) USING BTREE,
                                 CONSTRAINT `car_id` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                 CONSTRAINT `driver_id` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `taxi`.`cars_drivers` (`car_id`, `driver_id`) VALUES
                                                              (2, 1),
                                                              (3, 2),
                                                              (1, 3);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `login` varchar(255) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`login`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
INSERT INTO `users` (`login`, `password`) VALUES
                                                    ('login', 'password'),
                                                    ('bob', 'bobbobbob'),
                                                    ('bohdan', '12345678');
SET FOREIGN_KEY_CHECKS = 1;


-- ALTER TABLE `manufacturers` AUTO_INCREMENT = 1;
-- SELECT * FROM taxi.manufacturers;
-- SELECT * FROM taxi.cars;
-- SELECT * FROM taxi.drivers;
-- SELECT * FROM taxi.cars_drivers;
-- SELECT * FROM taxi.users;

-- TRUNCATE `taxi`.`cars_drivers`;
-- TRUNCATE `taxi`.`drivers`;
-- TRUNCATE `taxi`.`cars`;
-- TRUNCATE `taxi`.`manufacturers`;

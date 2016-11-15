-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.31-ndb-7.4.12-cluster-gpl - MySQL Cluster Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5130
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных people
DROP DATABASE IF EXISTS `people`;
CREATE DATABASE IF NOT EXISTS `people` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `people`;

-- Дамп структуры для таблица people.accounts
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE IF NOT EXISTS `accounts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(16) NOT NULL DEFAULT '0',
  `person_id` bigint(20) NOT NULL DEFAULT '0',
  UNIQUE KEY `id` (`id`),
  KEY `FK_accounts_person` (`person_id`),
  CONSTRAINT `FK_accounts_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='accounts';

-- Дамп данных таблицы people.accounts: ~2 rows (приблизительно)
DELETE FROM `accounts`;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` (`id`, `account`, `person_id`) VALUES
	(1111111111111111, '1111111111111111', 15),
	(1234567891234567, '1234567891234567', 1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;

-- Дамп структуры для таблица people.adress
DROP TABLE IF EXISTS `adress`;
CREATE TABLE IF NOT EXISTS `adress` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы people.adress: ~15 rows (приблизительно)
DELETE FROM `adress`;
/*!40000 ALTER TABLE `adress` DISABLE KEYS */;
INSERT INTO `adress` (`id`, `adress`) VALUES
	(1, 'Dnipro'),
	(2, 'Адрес2'),
	(3, 'Адрес3'),
	(4, 'Адрес4'),
	(5, 'Адрес5'),
	(6, 'Нормальный адресАдрес'),
	(7, '33333333'),
	(8, 'Адрес'),
	(9, 'Адрес888888'),
	(10, 'Адрес8888889'),
	(11, 'Адрес999999'),
	(12, 'Адрес55'),
	(13, 'ww'),
	(14, 'Адрес11'),
	(15, 'Адрес');
/*!40000 ALTER TABLE `adress` ENABLE KEYS */;

-- Дамп структуры для таблица people.person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `adress_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы people.person: ~17 rows (приблизительно)
DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `first_name`, `last_name`, `adress_id`) VALUES
	(1, 'Ivan', 'Ivanov', 1),
	(2, 'Ivan1', 'Ivanov1', 1),
	(3, 'Имя', 'Фамилия', 1),
	(4, 'Имя2', 'Фамилия2', 1),
	(5, 'Имя3', 'Фамилия3', 1),
	(6, 'Имя4', 'Фамилия4', 1),
	(7, 'Имя5', 'Фамилия5', 1),
	(8, 'нормальное имя', 'нормальная Фамилия', 6),
	(9, '111111111', '22222222222', 7),
	(10, 'Имя', 'Фамилия', 8),
	(11, 'Имя8888888', 'Фамилия8888888', 9),
	(12, 'Имя88888889', 'Фамилия88888889', 10),
	(13, 'Имя9999999', '999Фамилия', 11),
	(14, 'Имя55', 'Фамилия55', 12),
	(15, 'ww', 'ww', 13),
	(16, 'Имя1111', 'Фамилия11', 14),
	(17, 'Сидор', 'Сидоров', 15);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Дамп структуры для таблица people.transactions
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE IF NOT EXISTS `transactions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payer_account` varchar(16) NOT NULL DEFAULT '0',
  `receiver_account` varchar(16) NOT NULL DEFAULT '0',
  `sum_of_money` double NOT NULL DEFAULT '0',
  `date_of_transaction` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `type_of_transaction` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK_transactions_transaction_types` (`type_of_transaction`),
  CONSTRAINT `FK_transactions_transaction_types` FOREIGN KEY (`type_of_transaction`) REFERENCES `transaction_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='transactions';

-- Дамп данных таблицы people.transactions: ~2 rows (приблизительно)
DELETE FROM `transactions`;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` (`id`, `payer_account`, `receiver_account`, `sum_of_money`, `date_of_transaction`, `type_of_transaction`) VALUES
	(1, '1234567891234567', '1111111111111111', 10, '2016-11-14 21:26:01', 1),
	(2, '1111111111111111', '1234567891234567', 50, '2016-11-14 21:27:01', 1);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;

-- Дамп структуры для таблица people.transaction_types
DROP TABLE IF EXISTS `transaction_types`;
CREATE TABLE IF NOT EXISTS `transaction_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_of_transaction` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы people.transaction_types: ~1 rows (приблизительно)
DELETE FROM `transaction_types`;
/*!40000 ALTER TABLE `transaction_types` DISABLE KEYS */;
INSERT INTO `transaction_types` (`id`, `name_of_transaction`) VALUES
	(1, 'Перевод с карты на карту');
/*!40000 ALTER TABLE `transaction_types` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

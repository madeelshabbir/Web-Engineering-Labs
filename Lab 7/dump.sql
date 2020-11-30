/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.19 : Database - lab7
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lab7` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `lab7`;

/*Table structure for table `cred` */

DROP TABLE IF EXISTS `cred`;

CREATE TABLE `cred` (
  `FName` varchar(20) NOT NULL,
  `LName` varchar(20) NOT NULL,
  `Email` varchar(320) NOT NULL,
  `Password` varchar(128) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `DOB` date NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `cred` */

insert  into `cred`(`FName`,`LName`,`Email`,`Password`,`Gender`,`DOB`) values 
('Adeel','Shabbir','adeelspro@gmail.com','New','Male','1998-07-12'),
('Sir','Abid','bcsf17a521@pucit.edu.pk','sir','Male','1999-10-02'),
('Muhammad','Naveed','bcsf17a534@pucit.edu.pk','new','Male','1998-02-28'),
('Hamza','Yousaf','bcsf17a553@pucit.edu.pk','rand','Male','1997-10-11'),
('Adeel','Shabbir','bcsf17a556@gmail.com','G@mer190','Male','1998-07-12'),
('Adeel','M','bcsf17a556@pucit.edu.pk','Test','Male','1998-07-12'),
('Muhammad','Adeel','madeelshabbirs@gmail.com','game','Male','1998-07-12'),
('Muhammad','Hamza','mhamzapro@gmail.com','temp','Male','2001-07-22');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

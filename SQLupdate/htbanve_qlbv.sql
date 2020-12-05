-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: htbanve
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `qlbv`
--

DROP TABLE IF EXISTS `qlbv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlbv` (
  `QLBVtencx` varchar(45) NOT NULL,
  `QLBVbsx` varchar(45) NOT NULL,
  `QLBVgiokh` varchar(45) NOT NULL,
  `QLBVngaykh` varchar(45) NOT NULL,
  `QLBVgiave` varchar(45) NOT NULL,
  `QLBVloaixe` varchar(45) NOT NULL,
  `QLBVtenkh` varchar(45) NOT NULL,
  `QLBVsdtkh` varchar(45) NOT NULL,
  `QLBVtennv` varchar(45) NOT NULL,
  `QLBVsdtnv` varchar(45) NOT NULL,
  `QLBVghe` varchar(45) NOT NULL,
  PRIMARY KEY (`QLBVtencx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlbv`
--

LOCK TABLES `qlbv` WRITE;
/*!40000 ALTER TABLE `qlbv` DISABLE KEYS */;
INSERT INTO `qlbv` VALUES ('asd','sadasd','sad','sad','dsa','sad','duyen','0812881212','duyen','0812881212',''),('DL->NA','dfasf546','14:00','20/11/2020','200000','Vip','Tan thanh','0336051115','Tan thanh','0336051115',''),('HN->SG','H5N1','20:30','2020-11-30','200000','Thuong','Lam','32456789','Lam','32456789','8'),('tahnh lam','sadasd','15:00','2020-11-30','200000','vip','Quang Tung','1234567890','Quang Tung','1234567890',''),('Tung and Duyen','sadasd','15:00','2020-11-30','200000','vip','Hang','082345654','Hang','082345654','A03');
/*!40000 ALTER TABLE `qlbv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-05 16:36:47

-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: htbanve
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
-- Table structure for table `qlcx`
--

DROP TABLE IF EXISTS `qlcx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlcx` (
  `idQLCX` int NOT NULL,
  `QLCXtencx` varchar(45) NOT NULL,
  `QLCXbsx` varchar(45) NOT NULL,
  `QLCXgiokh` varchar(45) NOT NULL,
  `QLCXngaykh` varchar(45) NOT NULL,
  `QLCXgiave` varchar(45) NOT NULL,
  `QLCXtennv` varchar(45) NOT NULL,
  `QLCXsdtnv` varchar(45) NOT NULL,
  `QLCXloaixe` varchar(45) NOT NULL,
  `QLCXghe` varchar(45) NOT NULL,
  PRIMARY KEY (`idQLCX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlcx`
--

LOCK TABLES `qlcx` WRITE;
/*!40000 ALTER TABLE `qlcx` DISABLE KEYS */;
INSERT INTO `qlcx` VALUES (1,'asd','sadasd','sad','sad','dsa','das','asd','sad','9'),(2,'tahnh lam','sadasd','15:00','2020-12-05','200000','tung','065468431','vip','7'),(3,'tahnh lam','sadasd','15:00','2020-11-30','200000','tung','065468431','vip','7'),(4,'tahnh lam','sadasd','15:00','2020-12-18','200000','tung','065468431','vip','7');
/*!40000 ALTER TABLE `qlcx` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-07 13:47:23
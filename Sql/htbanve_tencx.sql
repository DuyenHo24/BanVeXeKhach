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
-- Table structure for table `tencx`
--

DROP TABLE IF EXISTS `tencx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tencx` (
  `idtencx` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NameCX` varchar(45) NOT NULL,
  PRIMARY KEY (`idtencx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tencx`
--

LOCK TABLES `tencx` WRITE;
/*!40000 ALTER TABLE `tencx` DISABLE KEYS */;
INSERT INTO `tencx` VALUES ('1a47dade-02fc-4790-bcdd-7c342d8f0b9f','HN->Sapa'),('2787726c-3fc7-4522-a3ce-65f16cee15be',''),('73ec3d49-fa8f-4a89-b473-d0b9290881d3','HN->TPHCM'),('77a7402d-e980-4af4-aa6d-f0160fb8d2a5','Sg->VT'),('886aa20d-ef9d-4b02-af0f-2f4f6504af2e','VT->SG'),('8cfe9ca5-0016-45ad-850e-eb43220d1475','SG->HN'),('9d933553-75c9-44cf-8b83-ac52ef4d9d17','HN->LC'),('d4cb08c4-fdd6-4f5e-a7d7-f19a3a8d793f',''),('e01f11f2-7b71-47a5-a5c0-851ce3329ade','');
/*!40000 ALTER TABLE `tencx` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-29  2:28:58

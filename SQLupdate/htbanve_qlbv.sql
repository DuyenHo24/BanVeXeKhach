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
-- Table structure for table `qlbv`
--

DROP TABLE IF EXISTS `qlbv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qlbv` (
  `QLBVid` varchar(45) NOT NULL,
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
  PRIMARY KEY (`QLBVid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qlbv`
--

LOCK TABLES `qlbv` WRITE;
/*!40000 ALTER TABLE `qlbv` DISABLE KEYS */;
INSERT INTO `qlbv` VALUES ('235e1465-fcc7-45a8-aad2-ed51cf960e7c','HN->SG','sadasd','15:00','2020-12-10','200000','vip','Thinh','0945889652','tung','065468431',''),('2a8cc918-a572-438c-99d1-a5ef9e8d391f','tahnh lam','sadasd','15:00','2020-12-05','200000','vip','Hang','08464123','tung','065468431','A03'),('3f314147-907f-48c3-8b72-5ea27826c9b0','HN->SG','Lam165456','15:00','2020-12-09','200000','vip','Thinh','0945889652','tung','065468431',''),('55591c2b-45aa-40ec-af22-5a5e2042128a','HN->SG','sadasd','15:00','2020-12-10','200000','vip','Thinh','0945889652','tung','065468431','A01'),('7a26232e-4301-4dfd-9924-195a88d13294','HN->SG','Lam165456','15:00','2020-12-09','200000','vip','Thinh','0945889652','tung','065468431',''),('9a4626dd-cf5e-43a9-bed7-e0b0de7fcace','HN->SG','Lam165456','15:00','2020-12-09','200000','vip','Nghia','0945889652','tung','065468431',''),('c4e84760-ec1f-4a51-88c7-cc22aaa63d99','HN->SG','Lam165456','15:00','2020-12-09','200000','vip','Thien','0945889652','tung','065468431',''),('dd1e6ca1-f9e8-4cb5-ad07-acf3a6027e08','HN->SG','Lam165456','15:00','2020-12-09','200000','vip','Thinh','0945889652','tung','065468431','');
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

-- Dump completed on 2020-12-09 23:29:00

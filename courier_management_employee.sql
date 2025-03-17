-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: courier_management
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EmployeeID` int NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `ContactNumber` varchar(20) DEFAULT NULL,
  `Role` varchar(50) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (100,'Revathi R','revathi.r@email.com','9101010101','IT Support',35000.00),(101,'Arun B','arun156@email.com','9876543210','Admin',90000.00),(102,'Raj Velan K','raj@email.com','9868454898','Courier Manager',70000.00),(103,'Karthika S','karthika.s@email.com','9787654787','Delivery Executive',45000.00),(104,'Divya Shree H','divya.shree@email.com','9767266767','Customer Support',35000.00),(105,'Sundar C','sundar.c@email.com','9656565656','Warehouse Staff',35000.00),(106,'Thilak S','thilak@email.com','9545454545','Dispatcher',30000.00),(107,'Meena T','meena@email.com','9434343434','Billing Officer',40000.00),(108,'John Mathew R','john.r@email.com','6323232323','Fleet Manager',70000.00),(109,'Anitha P','anitha.p@email.com','9212121212','Tracking Specialist',48000.00),(111,'Manoj K','manoj.k@email.com','6323455411','Delivery Executive',45000.00),(112,'Johnsen R','deepa.r@email.com','9824132148','Courier Manager',70000.00),(113,'Suresh B','suresh.b@email.com','9725636523','Warehouse Staff',35000.00),(114,'Latha K','neha.k@email.com','9662657526','Billing Officer',40000.00),(115,'Rajesh P','rajesh.p@email.com','9598564545','Customer Support',35000.00),(116,'Naveen T','naveen.t@email.com','9447952656','Delivery Executive',45000.00),(117,'Shruti L','shruti.l@email.com','6331545153','Admin',90000.00),(118,'Gokul V','gokul.v@email.com','9298754545','Fleet Manager',70000.00),(119,'Monika S','monika.s@email.com','9136456485','Dispatcher',30000.00),(120,'Harish K','harish.k@email.com','9006484541','IT Support',35000.00),(121,'Vidhya B','vidhya.b@email.com','9898767654','Warehouse Staff',35000.00),(122,'Santosh R','santosh.r@email.com','9765432109','Customer Support',35000.00),(123,'Vikash K','vikash.k@email.com','9654321098','Tracking Specialist',48000.00),(124,'Kamal P','komal.p@email.com','9543210987','Delivery Executive',45000.00),(125,'Ramesh V','ramesh.v@email.com','9432109876','Billing Officer',40000.00);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-17 21:22:36

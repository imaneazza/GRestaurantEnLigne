CREATE DATABASE  IF NOT EXISTS `restaurantapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `restaurantapp`;
-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: restaurantapp
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `imageSource` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Légumes',''),(2,'Fruit',''),(3,'Viande',''),(4,'Assaisonnements',''),(5,'Huiles',''),(6,'Boissons','');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(10) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `loyal` tinyint(1) DEFAULT NULL,
  `compteId` int(11) NOT NULL,
  PRIMARY KEY (`code`),
  KEY `fk_client_role_idx` (`compteId`),
  CONSTRAINT `fk_client_compte` FOREIGN KEY (`compteId`) REFERENCES `compte` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `mode` int(11) DEFAULT NULL,
  `clientId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_commande_client_idx` (`clientId`),
  CONSTRAINT `fk_commande_client` FOREIGN KEY (`clientId`) REFERENCES `client` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commandeId` int(11) DEFAULT NULL,
  `lineId` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_1_idx` (`commandeId`),
  KEY `fk_comment_2_idx` (`lineId`),
  CONSTRAINT `fk_comment_2` FOREIGN KEY (`lineId`) REFERENCES `line` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_commande` FOREIGN KEY (`commandeId`) REFERENCES `commande` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compte`
--

DROP TABLE IF EXISTS `compte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lName` varchar(40) NOT NULL,
  `fName` varchar(40) NOT NULL,
  `login` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_idx` (`roleId`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compte`
--

LOCK TABLES `compte` WRITE;
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` VALUES (5,'koraichi','mossaab','mk','mkpass',4,NULL),(6,'AZZA','imane','ia','iapass',3,NULL),(7,'bouaziz','fatima ezzahr','fz','fzpass',2,NULL),(8,'el idrissi','ayoub','ae','aepass',1,NULL),(10,'knito2','teeeeeeeeeest','logo2','passo',1,NULL),(11,'testfinal','testfinal','testfinal','testfinal',1,NULL),(12,'testfinal','testfinal','testfinal','testfinal',1,NULL),(13,'testfinal','toto','testfinal','testfinal',1,NULL);
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail`
--

DROP TABLE IF EXISTS `detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail` (
  `idForm` int(11) NOT NULL,
  `idingredient` int(11) NOT NULL,
  `obligatory` tinyint(1) NOT NULL,
  `qteMin` decimal(10,0) DEFAULT '0',
  `qteMax` decimal(10,0) DEFAULT '0',
  KEY `fk_detail_ingrediant_idx` (`idingredient`),
  KEY `fk_detail_form` (`idForm`),
  CONSTRAINT `fk_detail_form` FOREIGN KEY (`idForm`) REFERENCES `form` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_detail_ingrediant` FOREIGN KEY (`idingredient`) REFERENCES `ingredient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail`
--

LOCK TABLES `detail` WRITE;
/*!40000 ALTER TABLE `detail` DISABLE KEYS */;
INSERT INTO `detail` VALUES (1,11,1,500,100000),(1,25,0,50,150),(2,11,1,250,100000),(2,25,0,50,150),(1,22,0,250,1000),(2,22,0,250,1000);
/*!40000 ALTER TABLE `detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `offerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_form_offer_idx` (`offerId`),
  CONSTRAINT `fk_form_offer` FOREIGN KEY (`offerId`) REFERENCES `offer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES (1,'poulet grand',1),(2,'poulet moyen',1),(3,'poulet petit',1),(4,'harira marocain',3);
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `uniteMesure` varchar(10) NOT NULL,
  `qte` decimal(10,0) NOT NULL,
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ingredient_1_idx` (`categoryId`),
  CONSTRAINT `fk_ingredient_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Fenouil','g',1000,1),(2,'Tomate','g',1500,1),(3,'Pomme de tere','g',10000,1),(4,'chou-fleur','g',1000,1),(5,'Grenade','g',2000,2),(6,'Abrecot','g',3000,2),(7,'Pêche','g',2500,2),(8,'Agneau','g',10000,3),(9,'Bœuf','g',10000,3),(10,'Lapins','g',5000,3),(11,'Poulet','g',15000,3),(12,'Sel de cuisine','mg',10000,4),(13,'Agar-agar','mg',0,4),(14,'Poivre noir','mg',1000,4),(15,'Poivre rose','mg',1000,4),(16,'Ketchup','mg',10000,4),(17,'Moutarde','mg',10000,4),(18,'Harissa','mg',1000,4),(19,'Sucre','mg',20000,4),(20,'Huile olive','ml',10000,5),(21,'Huile soja','ml',5000,5),(22,'Eaux minérales','ml',100000,6),(23,'Jus d\'orange','ml',5000,6),(24,'Jus d\'avocat','ml',5000,6),(25,'Thé','ml',10000,6);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line`
--

DROP TABLE IF EXISTS `line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qte` int(11) DEFAULT NULL,
  `formId` int(11) DEFAULT NULL,
  `commandeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_line_form_idx` (`formId`),
  KEY `fk_line_commande_idx` (`commandeId`),
  CONSTRAINT `fk_line_commande` FOREIGN KEY (`commandeId`) REFERENCES `commande` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_line_form` FOREIGN KEY (`formId`) REFERENCES `form` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `line`
--

LOCK TABLES `line` WRITE;
/*!40000 ALTER TABLE `line` DISABLE KEYS */;
/*!40000 ALTER TABLE `line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `imageSource` varchar(40) NOT NULL,
  `state` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (1,'Tajine','',0),(2,'Salade','',0),(3,'Soupe','',0),(4,'','',0);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personalisation`
--

DROP TABLE IF EXISTS `personalisation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personalisation` (
  `lineId` int(11) NOT NULL,
  `ingredientId` int(11) NOT NULL,
  `qte` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ingredientId`,`lineId`),
  KEY `fk_personalisation_line_idx` (`lineId`),
  CONSTRAINT `fk_personalisation_ingredient` FOREIGN KEY (`ingredientId`) REFERENCES `ingredient` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personalisation_line` FOREIGN KEY (`lineId`) REFERENCES `line` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personalisation`
--

LOCK TABLES `personalisation` WRITE;
/*!40000 ALTER TABLE `personalisation` DISABLE KEYS */;
/*!40000 ALTER TABLE `personalisation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `price` decimal(10,0) NOT NULL,
  `ingredientId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_price_ingrediant_idx` (`ingredientId`),
  CONSTRAINT `fk_price_ingrediant` FOREIGN KEY (`ingredientId`) REFERENCES `ingredient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,'2018-01-04 01:28:52',10,1),(2,'2018-01-04 01:28:52',10,2),(3,'2018-01-04 01:28:52',10,3),(4,'2018-01-04 01:28:52',11,4),(5,'2018-01-04 01:28:52',5,5),(6,'2018-01-04 01:28:52',4,6),(7,'2018-01-04 01:28:52',1,7),(8,'2018-01-04 01:28:52',4,8),(9,'2018-01-04 01:28:52',6,9),(10,'2018-01-04 01:28:52',5,10),(11,'2018-01-04 01:28:52',2,11),(12,'2018-01-04 01:28:52',3,12),(13,'2018-01-04 01:28:52',4,14),(14,'2018-01-04 01:28:52',6,13),(15,'2018-01-04 01:28:52',2,15),(16,'2018-01-04 01:28:52',4,16),(17,'2018-01-04 01:28:52',5,17),(18,'2018-01-04 01:28:52',9,18),(19,'2018-01-04 01:28:52',1,19),(20,'2018-01-04 01:28:52',3,20),(21,'2018-01-04 01:28:52',5,21),(22,'2018-01-04 01:28:52',0,22),(23,'2018-01-04 01:28:52',0,25),(24,'2018-01-04 01:28:52',0,23),(25,'2018-01-04 01:28:52',0,24),(26,'2018-01-04 01:28:52',0,25),(27,'2017-12-05 01:28:52',11,1),(28,'2017-12-05 01:28:52',11,2),(29,'2017-12-05 01:28:52',11,3),(30,'2017-12-05 01:28:52',12,4),(31,'2017-12-05 01:28:52',6,5),(32,'2017-12-05 01:28:52',5,6),(33,'2017-12-05 01:28:52',2,7),(34,'2017-12-05 01:28:52',5,8),(35,'2017-12-05 01:28:52',7,9),(36,'2017-12-05 01:28:52',6,10),(37,'2017-12-05 01:28:52',3,11),(38,'2017-12-05 01:28:52',4,12),(39,'2017-12-05 01:28:52',5,14),(40,'2017-12-05 01:28:52',7,13),(41,'2017-12-05 01:28:52',3,15),(42,'2017-12-05 01:28:52',5,16),(43,'2017-12-05 01:28:52',6,17),(44,'2017-12-05 01:28:52',10,18),(45,'2017-12-05 01:28:52',2,19),(46,'2017-12-05 01:28:52',4,20),(47,'2017-12-05 01:28:52',6,21),(48,'2017-12-05 01:28:52',1,22),(49,'2017-12-05 01:28:52',1,25),(50,'2017-12-05 01:28:52',1,23),(51,'2017-12-05 01:28:52',1,24),(52,'2017-12-05 01:28:52',1,25);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'web master'),(2,'chef cuisine'),(3,'chef stock'),(4,'client');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'restaurantapp'
--

--
-- Dumping routines for database 'restaurantapp'
--
/*!50003 DROP FUNCTION IF EXISTS `sp_isAvailable` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `sp_isAvailable`(offerId int) RETURNS tinyint(1)
BEGIN
RETURN NOT EXISTS(
    SELECT *
    FROM ingredient as i
	inner join (
		SELECT d.idingredient as id,max(d.qteMax) as qteMax
		FROM offer as o inner join form as f on o.id=f.offerId
		inner join detail as d on f.id=d.idform
		group by d.idingredient
        ) as d on d.id=i.id and d.qteMax>i.qte
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-05 11:03:58

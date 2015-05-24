CREATE DATABASE  IF NOT EXISTS `tim7` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tim7`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: tim7
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `izvjestaji`
--

DROP TABLE IF EXISTS `izvjestaji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `izvjestaji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `broj_pausalaca` int(11) DEFAULT NULL,
  `potrosnja_pausalaca_voda` double DEFAULT NULL,
  `potrosnja_pausalaca_kanalizacija` double DEFAULT NULL,
  `broj_ostalih` int(11) DEFAULT NULL,
  `potrosnja_ostalih_voda` double DEFAULT NULL,
  `potrosnja_ostalih_kanalizacija` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `izvjestaji`
--

LOCK TABLES `izvjestaji` WRITE;
/*!40000 ALTER TABLE `izvjestaji` DISABLE KEYS */;
/*!40000 ALTER TABLE `izvjestaji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `jmbg` varchar(45) NOT NULL,
  `broj_licne` varchar(45) NOT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `datum_zaposljenja` date DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `broj_licne_UNIQUE` (`broj_licne`),
  UNIQUE KEY `jmbg_UNIQUE` (`jmbg`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'admin','admin','012345678912','123456789','admin','admin','admin','2000-01-01',1,'admin','admin'),(10,'Kenan','Mahmutovic','1512997172641','123ADS123','Adresa 3','062/333-333 ','kenan@etf.unsa.ba','2015-05-12',0,'kmahmutovic1','3fccae6f25d14414'),(11,'Azra','Mahmutovic','0611992177631','OIL123456','Adresa 2','062/222-222 ','azra@gmail.com','2015-05-12',1,'amahmutovic1','3fc7210ddbe0020c');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocitanja`
--

DROP TABLE IF EXISTS `ocitanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocitanja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `potrosnja` double NOT NULL,
  `godina` int(11) NOT NULL,
  `id_potrosaca` int(11) NOT NULL,
  `mjesec` int(11) NOT NULL,
  `access` tinyint(1) NOT NULL,
  `sifra_vodomjera` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_potrosaca_idx` (`id_potrosaca`),
  CONSTRAINT `id_potrosaca` FOREIGN KEY (`id_potrosaca`) REFERENCES `potrosac` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocitanja`
--

LOCK TABLES `ocitanja` WRITE;
/*!40000 ALTER TABLE `ocitanja` DISABLE KEYS */;
INSERT INTO `ocitanja` VALUES (2,0,2010,6,10,1,1),(3,20,2010,6,11,1,1),(4,30,2010,6,12,1,1),(5,0,2010,7,10,1,2),(6,10,2010,7,11,1,2),(7,30,2010,7,12,1,2);
/*!40000 ALTER TABLE `ocitanja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametri`
--

DROP TABLE IF EXISTS `parametri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cijena_vode_po_kubiku` double NOT NULL,
  `cijena_kanalizacije_po_kubiku` double NOT NULL,
  `pvn_za_koristenje_voda` double NOT NULL,
  `pvn_za_zastitu_voda` double NOT NULL,
  `fiksni_voda_za_pausalce` double NOT NULL,
  `fiksni_kanalizacija_za_pausalce` double NOT NULL,
  `fiksna_cijena` double NOT NULL,
  `stopa_pdv` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametri`
--

LOCK TABLES `parametri` WRITE;
/*!40000 ALTER TABLE `parametri` DISABLE KEYS */;
INSERT INTO `parametri` VALUES (1,0.5,0.5,0.01,0.004,5,5,2,17);
/*!40000 ALTER TABLE `parametri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `potrosac`
--

DROP TABLE IF EXISTS `potrosac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `potrosac` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `jmbg` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  `broj_clanova` varchar(45) DEFAULT NULL,
  `kategorija` varchar(45) NOT NULL,
  `sifra_vodomjera` int(11) DEFAULT NULL,
  `usluga` tinyint(1) DEFAULT NULL,
  `aktivnost` tinyint(1) DEFAULT NULL,
  `hidden` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `jmbg_UNIQUE` (`jmbg`),
  UNIQUE KEY `vodomjer_id_UNIQUE` (`sifra_vodomjera`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `potrosac`
--

LOCK TABLES `potrosac` WRITE;
/*!40000 ALTER TABLE `potrosac` DISABLE KEYS */;
INSERT INTO `potrosac` VALUES (6,'Armin','Klačar','2309992170008','Adresa 1','062/111-111 ','1','Sa vodomjerom',1,1,1,0),(7,'Azra','Mahmutovic','0611992177631','Adresa 2','062/222-222 ','1','Sa vodomjerom',2,0,1,0),(8,'Kenan','Mahmutovic','1512997172641','Adresa 3','062/333-333 ','1','Pausalac',NULL,0,1,0);
/*!40000 ALTER TABLE `potrosac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `racuni`
--

DROP TABLE IF EXISTS `racuni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `racuni` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_ocitanja` int(11) DEFAULT NULL,
  `id_potrosaca` int(11) DEFAULT NULL,
  `datum_uplate` date DEFAULT NULL,
  `datum_kreacije` date DEFAULT NULL,
  `fiskna_cijena_za_koristenje_usluga` double DEFAULT NULL,
  `potrosnja_za_koristenje_voda` double DEFAULT NULL,
  `potrosnja_za_koristenje_kanalizacije` double DEFAULT NULL,
  `cijena_voda` double DEFAULT NULL,
  `cijena_kanalizacije` double DEFAULT NULL,
  `ukupna_cijena` double DEFAULT NULL,
  `cijena_voda_sa_pdv` double DEFAULT NULL,
  `cijena_kanalizacije_sa_pdv` double DEFAULT NULL,
  `ukupna_cijena_sa_pdv` double DEFAULT NULL,
  `pvn_za_koristenje_voda` double DEFAULT NULL,
  `pvn_za_zastitu_voda` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_ocitanja_idx` (`id_ocitanja`),
  KEY `id_potrosaca_idx` (`id_potrosaca`),
  CONSTRAINT `id_ocitanjaA` FOREIGN KEY (`id_ocitanja`) REFERENCES `ocitanja` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_potrosacaA` FOREIGN KEY (`id_potrosaca`) REFERENCES `potrosac` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racuni`
--

LOCK TABLES `racuni` WRITE;
/*!40000 ALTER TABLE `racuni` DISABLE KEYS */;
/*!40000 ALTER TABLE `racuni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tim7'
--

--
-- Dumping routines for database 'tim7'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-24 19:11:57

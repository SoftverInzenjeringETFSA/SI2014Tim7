-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2015 at 09:19 PM
-- Server version: 5.1.73-community
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tim7`
--

-- --------------------------------------------------------

--
-- Table structure for table `izvjestaji`
--

CREATE TABLE IF NOT EXISTS `izvjestaji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `broj_pausalaca` int(11) DEFAULT NULL,
  `potrosnja_pausalaca_voda` double DEFAULT NULL,
  `potrosnja_pausalaca_kanalizacija` double DEFAULT NULL,
  `broj_ostalih` int(11) DEFAULT NULL,
  `potrosnja_ostalih_voda` double DEFAULT NULL,
  `potrosnja_ostalih_kanalizacija` double DEFAULT NULL,
  `datumod` date DEFAULT NULL,
  `datumdo` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `izvjestaji`
--

INSERT INTO `izvjestaji` (`id`, `broj_pausalaca`, `potrosnja_pausalaca_voda`, `potrosnja_pausalaca_kanalizacija`, `broj_ostalih`, `potrosnja_ostalih_voda`, `potrosnja_ostalih_kanalizacija`, `datumod`, `datumdo`) VALUES
(1, 1, 20, 0, 2, 0, 0, '2015-01-04', '2017-06-04'),
(3, 1, 20, 0, 3, 0, 0, '2015-01-04', '2017-06-04'),
(4, 1, 20, 0, 0, 0, 0, '2015-01-04', '2017-06-04'),
(5, 1, 20, 0, 0, 0, 0, '2015-01-04', '2017-06-04'),
(6, 1, 20, 0, 0, 0, 0, '2015-01-04', '2017-06-04'),
(7, 1, 20, 0, 0, 0, 0, '2015-01-04', '2017-06-04'),
(8, 2, 60, 45, 3, 46, 25, '2014-01-01', '2014-05-31'),
(9, 1, 20, 0, 0, 0, 0, '2015-01-04', '2017-06-04'),
(10, 2, 80, 60, 1, 8, 8, '2015-01-04', '2017-06-04');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=52 ;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `ime`, `prezime`, `jmbg`, `broj_licne`, `adresa`, `telefon`, `mail`, `datum_zaposljenja`, `admin`, `username`, `password`) VALUES
(1, 'admin', 'admin', '012345678912', '123456789', 'admin', '065/555-555', 'admin', '2000-01-01', 1, 'admin', 'admin'),
(10, 'Kenan', 'Mahmutovic', '1512997172641', '123ADS123', 'Adresa 3', '034/445-454', 'kenan@etf.unsa.ba', '2015-05-12', 0, 'kmahmutovic1', '3fccae6f25d14414'),
(11, 'Azra', 'Mahmutovic', '0611992177631', 'OIL123456', 'Adresa 2', '033/123-433', 'azra@gmail.com', '2015-05-12', 1, 'amahmutovic1', '3fc7210ddbe0020c');

-- --------------------------------------------------------

--
-- Table structure for table `ocitanja`
--

CREATE TABLE IF NOT EXISTS `ocitanja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `potrosnja` double NOT NULL,
  `godina` int(11) NOT NULL,
  `id_potrosaca` int(11) NOT NULL,
  `mjesec` int(11) NOT NULL,
  `access` tinyint(1) NOT NULL,
  `sifra_vodomjera` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_potrosaca_idx` (`id_potrosaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=70 ;

--
-- Dumping data for table `ocitanja`
--

INSERT INTO `ocitanja` (`id`, `potrosnja`, `godina`, `id_potrosaca`, `mjesec`, `access`, `sifra_vodomjera`) VALUES
(5, 0, 2010, 7, 5, 1, 2),
(6, 10, 2010, 7, 11, 1, 2),
(7, 30, 2010, 7, 12, 1, 2),
(8, 0, 2015, 8, 1, 0, NULL),
(9, 0, 2015, 8, 2, 0, NULL),
(10, 0, 2015, 8, 3, 0, NULL),
(11, 0, 2015, 8, 4, 0, NULL),
(12, 0, 2015, 8, 5, 0, NULL),
(13, 0, 2015, 8, 6, 1, NULL),
(25, 10, 2014, 6, 1, 0, 1),
(26, 17, 2014, 6, 2, 0, 1),
(27, 22, 2014, 6, 3, 0, 1),
(28, 30, 2014, 6, 4, 0, 1),
(29, 36, 2014, 6, 5, 1, 1),
(30, 42, 2014, 6, 6, 1, 1),
(31, 46, 2014, 6, 7, 1, 1),
(32, 50, 2014, 6, 8, 1, 1),
(33, 55, 2014, 6, 9, 1, 1),
(34, 60, 2014, 6, 10, 1, 1),
(35, 65, 2014, 6, 11, 1, 1),
(36, 65, 2014, 6, 12, 1, 1),
(37, 2, 2014, 7, 1, 0, 2),
(38, 7, 2014, 7, 2, 0, 2),
(39, 16, 2014, 7, 3, 0, 2),
(40, 25, 2014, 7, 4, 0, 2),
(41, 28, 2014, 7, 5, 1, 2),
(42, 33, 2014, 7, 6, 1, 2),
(43, 6, 2014, 10, 1, 0, 3),
(44, 9, 2014, 10, 2, 0, 3),
(45, 15, 2014, 10, 3, 1, 3),
(46, 15, 2014, 11, 1, 0, 4),
(47, 20, 2014, 11, 2, 1, 4),
(48, 0, 2014, 8, 1, 0, NULL),
(49, 0, 2014, 12, 1, 0, NULL),
(50, 0, 2014, 8, 2, 0, NULL),
(51, 0, 2014, 12, 2, 0, NULL),
(52, 0, 2014, 8, 3, 0, NULL),
(53, 0, 2014, 12, 3, 0, NULL),
(54, 0, 2014, 8, 4, 0, NULL),
(55, 0, 2014, 12, 4, 0, NULL),
(56, 0, 2014, 8, 5, 1, NULL),
(57, 0, 2014, 12, 5, 1, NULL),
(58, 12, 2015, 11, 1, 0, 4),
(59, 22, 2015, 11, 2, 0, 4),
(60, 27, 2015, 11, 3, 0, 4),
(61, 30, 2015, 11, 4, 1, 4),
(62, 0, 2015, 12, 1, 0, NULL),
(63, 0, 2015, 12, 2, 0, NULL),
(64, 0, 2015, 12, 3, 0, NULL),
(65, 0, 2015, 12, 4, 0, NULL),
(66, 0, 2015, 12, 5, 0, NULL),
(67, 0, 2015, 12, 6, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `parametri`
--

CREATE TABLE IF NOT EXISTS `parametri` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `parametri`
--

INSERT INTO `parametri` (`id`, `cijena_vode_po_kubiku`, `cijena_kanalizacije_po_kubiku`, `pvn_za_koristenje_voda`, `pvn_za_zastitu_voda`, `fiksni_voda_za_pausalce`, `fiksni_kanalizacija_za_pausalce`, `fiksna_cijena`, `stopa_pdv`) VALUES
(1, 0.5, 0.5, 0.01, 0.04, 5, 5, 10, 17);

-- --------------------------------------------------------

--
-- Table structure for table `potrosac`
--

CREATE TABLE IF NOT EXISTS `potrosac` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `potrosac`
--

INSERT INTO `potrosac` (`id`, `ime`, `prezime`, `jmbg`, `adresa`, `telefon`, `broj_clanova`, `kategorija`, `sifra_vodomjera`, `usluga`, `aktivnost`, `hidden`) VALUES
(6, 'Armin', 'Klacar', '2309992170008', 'Adresa 1', '062/111-111', '1', 'Sa vodomjerom', 1, 1, 1, 0),
(7, 'Azra', 'Mahmutovic', '0611992177631', 'Adresa 2', '062/222-222', '1', 'Sa vodomjerom', 2, 0, 1, 0),
(8, 'Kenan', 'Mahmutovic', '1512997172641', 'Adresa 3', '062/333-333', '1', 'Pausalac', NULL, 0, 1, 0),
(10, 'Emina', 'Muharemovic', '2709992176217', 'Adresa 4', '061/111-222', '4', 'Sa vodomjerom', 3, 1, 1, 0),
(11, 'Zana', 'Tatar', '3004992784527', 'Zmaja od Bosne 5', '033/123-456', '1', 'Sa vodomjerom', 4, 1, 1, 0),
(12, 'Luka', 'Palavra', '0101006500006', 'Ferhadija', '066/999-999', '3', 'Pausalac', NULL, 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `racuni`
--

CREATE TABLE IF NOT EXISTS `racuni` (
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
  KEY `id_potrosaca_idx` (`id_potrosaca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `racuni`
--

INSERT INTO `racuni` (`id`, `id_ocitanja`, `id_potrosaca`, `datum_uplate`, `datum_kreacije`, `fiskna_cijena_za_koristenje_usluga`, `potrosnja_za_koristenje_voda`, `potrosnja_za_koristenje_kanalizacije`, `cijena_voda`, `cijena_kanalizacije`, `ukupna_cijena`, `cijena_voda_sa_pdv`, `cijena_kanalizacije_sa_pdv`, `ukupna_cijena_sa_pdv`, `pvn_za_koristenje_voda`, `pvn_za_zastitu_voda`) VALUES
(1, 9, 8, '2015-02-11', '2015-01-01', 2, 5, 0, 2.57, 0, 4.57, 3.01, 0, 3.35, 0.01, 0.004),
(2, 10, 8, '2015-03-18', '2015-02-01', 2, 5, 0, 2.57, 0, 4.57, 3.01, 0, 3.35, 0.01, 0.004),
(3, 11, 8, '2015-04-14', '2015-03-01', 2, 5, 0, 2.57, 0, 4.57, 3.01, 0, 3.35, 0.01, 0.004),
(4, 12, 8, '2015-05-12', '2015-04-01', 2, 5, 0, 2.57, 0, 4.57, 3.01, 0, 3.35, 0.01, 0.004),
(5, 13, 8, NULL, '2015-05-01', 2, 5, 0, 2.57, 0, 4.57, 3.01, 0, 3.35, 0.01, 0.004),
(6, 26, 6, '2014-02-01', '2014-01-01', 2, 7, 7, 3.85, 3.5, 9.35, 4.5, 4.09, 10.93, 0.07, 0.28),
(7, 27, 6, '2014-03-07', '2014-02-01', 2, 5, 5, 2.75, 2.5, 7.25, 3.22, 2.92, 8.48, 0.05, 0.2),
(8, 28, 6, '2014-04-15', '2014-03-01', 2, 8, 8, 4.4, 4, 10.4, 5.15, 4.68, 12.17, 0.08, 0.32),
(9, 29, 6, '2014-05-01', '2014-04-01', 2, 6, 6, 3.3, 3, 8.3, 3.86, 3.51, 9.71, 0.06, 0.24),
(10, 38, 7, '2014-02-11', '2014-01-01', 2, 5, 0, 2.75, 0, 4.75, 3.22, 0, 5.56, 0.05, 0.2),
(11, 39, 7, '2014-04-01', '2014-02-01', 2, 9, 0, 4.95, 0, 6.95, 5.79, 0, 8.13, 0.09, 0.36),
(12, 40, 7, '2014-04-01', '2014-03-01', 2, 9, 0, 4.95, 0, 6.95, 5.79, 0, 8.13, 0.09, 0.36),
(13, 41, 7, '2014-05-13', '2014-04-01', 2, 3, 0, 1.65, 0, 3.65, 1.93, 0, 4.27, 0.03, 0.12),
(14, 44, 10, '2014-02-03', '2014-01-01', 2, 3, 3, 1.65, 1.5, 5.15, 1.93, 1.75, 6.02, 0.03, 0.12),
(15, 45, 10, '2014-03-06', '2014-02-01', 2, 6, 6, 3.3, 3, 8.3, 3.86, 3.51, 9.71, 0.06, 0.24),
(16, 47, 11, '2014-03-12', '2014-01-01', 2, 5, 5, 2.75, 2.5, 7.25, 3.22, 2.92, 8.48, 0.05, 0.2),
(17, 50, 8, '2014-02-04', '2014-01-01', 2, 5, 0, 2.75, 0, 4.75, 3.22, 0, 5.56, 0.05, 0.2),
(18, 51, 12, '2014-02-07', '2014-01-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(19, 52, 8, '2014-03-19', '2014-02-01', 2, 5, 0, 2.75, 0, 4.75, 3.22, 0, 5.56, 0.05, 0.2),
(20, 53, 12, '2014-03-11', '2014-02-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(21, 54, 8, '2014-04-22', '2014-03-01', 2, 5, 0, 2.75, 0, 4.75, 3.22, 0, 5.56, 0.05, 0.2),
(22, 55, 12, '2014-05-13', '2014-03-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(23, 56, 8, '2014-05-22', '2014-04-01', 2, 5, 0, 2.75, 0, 4.75, 3.22, 0, 5.56, 0.05, 0.2),
(24, 57, 12, '2014-05-21', '2014-04-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(25, 59, 11, NULL, '2015-01-01', 2, 10, 10, 5.5, 5, 12.5, 6.44, 5.85, 14.63, 0.1, 0.4),
(26, 60, 11, NULL, '2015-02-01', 2, 5, 5, 2.75, 2.5, 7.25, 3.22, 2.92, 8.48, 0.05, 0.2),
(27, 61, 11, NULL, '2015-03-01', 2, 3, 3, 1.65, 1.5, 5.15, 1.93, 1.75, 6.02, 0.03, 0.12),
(28, 63, 12, NULL, '2015-01-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(29, 64, 12, NULL, '2015-02-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(30, 65, 12, NULL, '2015-03-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(31, 66, 12, NULL, '2015-04-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6),
(32, 67, 12, NULL, '2015-05-01', 2, 15, 15, 8.25, 7.5, 17.75, 9.65, 8.78, 20.77, 0.15, 0.6);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ocitanja`
--
ALTER TABLE `ocitanja`
  ADD CONSTRAINT `id_potrosaca` FOREIGN KEY (`id_potrosaca`) REFERENCES `potrosac` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `racuni`
--
ALTER TABLE `racuni`
  ADD CONSTRAINT `id_ocitanjaA` FOREIGN KEY (`id_ocitanja`) REFERENCES `ocitanja` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_potrosacaA` FOREIGN KEY (`id_potrosaca`) REFERENCES `potrosac` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

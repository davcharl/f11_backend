CREATE DATABASE  IF NOT EXISTS `dc_tax_payer`;
USE `dc_tax_payer`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `taxpayer`;

CREATE TABLE `taxpayer` (
  `ppsn_id` nvarchar(11) NOT NULL AUTO_INCREMENT,
  `first_name` nvarchar(45) NOT NULL,
  `last_name` nvarchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` nvarchar(50) DEFAULT NULL,
  `xml_location` nvarchar(400) DEFAULT NULL,
  PRIMARY KEY (`ppsn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


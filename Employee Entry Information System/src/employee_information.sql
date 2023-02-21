-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for employee_information
CREATE DATABASE IF NOT EXISTS `employee_information` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `employee_information`;

-- Dumping structure for table employee_information.emergency_information
CREATE TABLE IF NOT EXISTS `emergency_information` (
  `emerg_person` varchar(50) NOT NULL,
  `emerg_address` varchar(100) DEFAULT NULL,
  `emerg_phone` bigint(20) DEFAULT NULL,
  `relationship` varchar(50) DEFAULT NULL,
  `emp_id` varchar(50) NOT NULL,
  PRIMARY KEY (`emerg_person`,`emp_id`) USING BTREE,
  KEY `FK_emergency_information_job_information` (`emp_id`),
  CONSTRAINT `FK_emergency_information_job_information` FOREIGN KEY (`emp_id`) REFERENCES `job_information` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table employee_information.emergency_information: ~18 rows (approximately)
/*!40000 ALTER TABLE `emergency_information` DISABLE KEYS */;
INSERT INTO `emergency_information` (`emerg_person`, `emerg_address`, `emerg_phone`, `relationship`, `emp_id`) VALUES
	(' Jayme, Zeus, Espeleta', '785 Abad Street Barangay Halaman Quezon City', 639125266356, 'Family', ' 2021-08153'),
	(' Jayme, Zeus, Espeleta', '785 Abad Street Barangay Halaman Quezon City', 123123123, 'Family', '123123'),
	('Ambos, Jose, Camrejeta', 'Block 4 Lot 6 Habanos Subdivision, Taguig City', 639568923155, 'Family', '2019-65650-MN-0'),
	('Bonifacio, Andres, Domingo', 'Unit 2319 Quirino Drive, Antipolo City', 639222456899, 'Family', '2018-26123-MN-2'),
	('Cruz, James, Santos', 'Blcok 9 Lot 1 Ayala Village, Rockwell, Makati City', 639123582456, 'Family', '2018-08180-MN-0'),
	('Cuevas, Jose, Herrera', 'Block 5 Lot 2 Heaven Village, Las Pinas City', 639456855147, 'Family', '2021-11111-NN-0'),
	('Diaz, Nhil Angelo, Zuniga', '789 Street Sampiga, Antipolo City', 639256455896, 'Friend', '2017-56895-MM-2'),
	('Fabian, Marites, Buno', 'Unit 42 San Jose Drive, Makati City', 639621589321, 'Family', '2020-05566-MN-0'),
	('Jayme, Zeus, Espeleta', '785 Abad Street Barangay Halaman Quezon City', 123123123, 'Family', 'ASDASD'),
	('Lazo, Szarina, Ricamara', 'Block 2 Lot 1 Camella Townhomes 1, Putatan, Muntinlupa City', 639215443342, 'Family', '2019-07170-MN-0'),
	('Ong, Marivel, Pamintuan', 'Juan Street Xavier Village, Paranaque', 639256315748, 'Family', '2019-02120-FF-19'),
	('Pacampara, Sean, Calucot', '4568 Unit Paralejo Street, Batang Village, Muntinlupa City', 639265898363, 'Family', '2019-15230-MN-0'),
	('Pineda, Charmine, Reyes', '125 Unit San Jose Street, Mandaluyong City', 639456987123, 'Family', '2020-04168-MN-0'),
	('Rances, Maria, Maniago', '235 Unit Langit Subdivision, Paranaque City', 639222666987, 'Romantic', '2015-82150-FF-3'),
	('Ras, Angelito, De Guzman', 'Unit 589, Jabilee Street, Antipolo City', 639222333444, 'Family', '2018-52236-FF-2'),
	('Raya, Nathaniel, Ejercito', 'Unit 8895 San Juan Drive, Antipolo City', 639456999222, 'Family', '2019-32325-LM-2'),
	('Santos, Sean, Abad', '895 Unit San Pedro Street, Hamsy Village, Taguig City', 639265812326, 'Family', '2015-06160-MN-2'),
	('Seculan, Zena, Manantala', 'Block 6 Lot 15 SSV Subdivision, Muntinlupa City', 639568912348, 'Family', '2015-05150-NN-5');
/*!40000 ALTER TABLE `emergency_information` ENABLE KEYS */;

-- Dumping structure for table employee_information.job_information
CREATE TABLE IF NOT EXISTS `job_information` (
  `emp_id` varchar(50) NOT NULL DEFAULT '',
  `job_title` varchar(50) DEFAULT NULL,
  `dept` varchar(50) DEFAULT NULL,
  `supervisor` varchar(100) DEFAULT NULL,
  `work_loc` varchar(100) DEFAULT NULL,
  `work_email` varchar(50) DEFAULT NULL,
  `work_phone` bigint(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `salary` float DEFAULT NULL,
  `government_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK_job_information_personal_information` (`government_ID`),
  CONSTRAINT `FK_job_information_personal_information` FOREIGN KEY (`government_ID`) REFERENCES `personal_information` (`government_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table employee_information.job_information: ~18 rows (approximately)
/*!40000 ALTER TABLE `job_information` DISABLE KEYS */;
INSERT INTO `job_information` (`emp_id`, `job_title`, `dept`, `supervisor`, `work_loc`, `work_email`, `work_phone`, `start_date`, `salary`, `government_ID`) VALUES
	(' 2021-08153', 'Staff', 'IT', 'Jayme, Jerome Cedric, Opina', 'Muntinlupa City', 'work_opina@yahoo.com', 639215469852, '2021-04-03', 20000, '003-25893-21'),
	('123123', 'asdasd', 'it', 'sadsdasd', 'asdasd', 'asdasd', 12312313, '2001-05-08', 123123, '123123123123123'),
	('2015-05150-NN-5', 'Team Leader', 'IT', 'N/A', 'Muntinlupa City', 'work_seculan@yahoo.com', 639236512428, '2015-08-23', 30000, '153-24615-14'),
	('2015-06160-MN-2', 'Supervisor', 'IT', 'N/A', 'Makati City', 'work_jsantos@yahoo.com', 639524516326, '2015-06-23', 40000, '122-15328-18'),
	('2015-82150-FF-3', 'Supervisor', 'FI', 'N/A', 'Muntinlupa City', 'work_rances@yahoo.com', 639125784659, '2015-05-13', 45000, '10-02589-15'),
	('2017-56895-MM-2', 'Supervisor', 'HR', 'N/A', 'Antipolo City', 'work_orozco@yahoo.com', 639789153246, '2017-01-15', 40000, '568-15623-17'),
	('2018-08180-MN-0', 'Junior Programmer', 'IT', 'Santos, John Lloyd, Abad', 'Makati City', 'work_bcruz@yahoo.com', 639123693582, '2018-12-05', 25000, '023-45618-20'),
	('2018-26123-MN-2', 'Data Analyst', 'IT', 'Tumpalan, Zachary, Pedron', 'Antipolo City', 'work_tumpalan@yahoo.com', 639222444888, '2018-07-26', 30000, '565-58985-12'),
	('2018-52236-FF-2', 'Staff', 'FI', 'Teleb, Angel, Romero', 'Antipolo City', 'work_ras@yahoo.com', 639265985255, '2019-10-09', 25000, '052-65312-55'),
	('2019-02120-FF-19', 'Staff', 'FI', 'Rances, Nino, Listones', 'Muntinlupa City', 'work_ong@yahoo.com', 639569812345, '2019-10-06', 20000, '456-15360-19'),
	('2019-07170-MN-0', 'Junior Programmer', 'IT', 'Santos, John Lloyd, Abad', 'Makati City', 'work_lazo@yahoo.com', 639123456987, '2019-02-05', 20000, '153-26598-19'),
	('2019-15230-MN-0', 'Staff', 'HR', 'Bunyi, Angeline, Ordanes', 'Muntinlupa City', 'work_pacampara@yahoo.com', 639123589659, '2019-03-17', 20000, '203-10023-20'),
	('2019-32325-LM-2', 'Junior Programmer', 'IT', 'Milby, Sam, Reid', 'Antipolo City', 'work_raya@yahoo.com', 639123458526, '2019-02-05', 20000, '235-56921-29'),
	('2019-65650-MN-0', 'Staff', 'HR', 'Villanueva, Clarissa, Espeleta', 'Makati City', 'work_ambos@yahoo.com', 639100265897, '2019-12-23', 20000, '789-12354-20'),
	('2020-04168-MN-0', 'Staff', 'HR', 'Orozco, Nikki, Guansing', 'Antipolo City', 'work_pineda@yahoo.com', 639126897456, '2020-12-06', 18000, '235-15268-20'),
	('2020-05566-MN-0', 'Staff', 'FI', 'Gamalog, Julius, Trozado', 'Makati City', 'work_fabian@yahoo.com', 639236526123, '2020-08-16', 25000, '265-65931-23'),
	('2021-11111-NN-0', 'Staff', 'FI', 'Rances, Nino, Listones', 'Muntinlupa City', 'work_alexis@yahoo.com', 639125489632, '2021-11-02', 18000, '489-35687-20'),
	('ASDASD', 'ASDASD', 'ASDASD', 'ASDASD', 'DASDASD', 'ASDAS', 123123, '2001-12-13', 3123120, '123123');
/*!40000 ALTER TABLE `job_information` ENABLE KEYS */;

-- Dumping structure for table employee_information.personal_information
CREATE TABLE IF NOT EXISTS `personal_information` (
  `government_ID` varchar(50) NOT NULL DEFAULT '',
  `emp_name` varchar(100) DEFAULT NULL,
  `emp_address` varchar(100) DEFAULT NULL,
  `emp_phone` bigint(20) DEFAULT NULL,
  `emp_email` varchar(100) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `marital_status` varchar(20) DEFAULT NULL,
  `spouse_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`government_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table employee_information.personal_information: ~18 rows (approximately)
/*!40000 ALTER TABLE `personal_information` DISABLE KEYS */;
INSERT INTO `personal_information` (`government_ID`, `emp_name`, `emp_address`, `emp_phone`, `emp_email`, `birthdate`, `marital_status`, `spouse_name`) VALUES
	('003-25893-21', 'Juan Pedro Santos', '785 Abad Street Barangay Halaman Quezon City', 639567823753, 'juan_santos@yahoo.com', '2000-06-13', 'Single', 'N/A'),
	('023-45618-20', 'Cruz, Bernardo, Santos', 'Block 9 Lot 1 Ayala Village, Rockwell, Makati City', 639456123789, 'bernardo_cruz@yahoo.com', '2000-03-09', 'Single', 'N/A'),
	('052-65312-55', 'Ras, Maria, Manalo', 'Unit 589, Jabilee Street, Antipolo City', 639265985152, 'maria_ras@yahoo.com', '2000-09-08', 'Single', 'N/A'),
	('10-02589-15', 'Rances, Nino, Listones', '235 Unit Langit Subdivision, Paranaque City', 639215422366, 'rances_nino@yahoo.com', '1996-08-25', 'Married', 'Rances, Maria, Maniago'),
	('122-15328-18', 'Santos, John Lloyd, Abad', '895 Unit San Pedro Street, Hamsy Village, Taguig City', 639452163826, 'santos_john@yahoo.com', '1998-10-25', 'Single', 'N/A'),
	('123123', 'DASDASDAS', 'DASDASD', 123123, 'SASDASD', '2001-05-08', 'Single', 'ASDAS'),
	('123123123123123', 'asdasdasd', 'asdasd', 1231231, 'sadasdasd', '2001-05-02', 'Single', 'asdasd'),
	('153-24615-14', 'Seculan, Tirson, Manantala', 'Block 6 Lot 15 SSV Subdivision, Muntinlupa City', 639745862193, 'seculan_tirson@yahoo.com', '1997-05-26', 'Married', 'Seculan, Martires, Servida'),
	('153-26598-19', 'Lazo, Aeron Brylle, Ricamara', 'Block 2 Lot 1 Camella Townhomes, Putatan, Muntinlupa City', 639215443342, 'aeron_lazo@yahoo.com', '2001-05-08', 'Single', 'N/A'),
	('203-10023-20', 'Pacampara, Ian, Bercasio', '4568 Unit Paralejo Street, Batang Village, Muntinlupa City', 639265168439, 'pacampara_ian@yahoo.com', '2001-12-06', 'Single', 'N/A'),
	('235-15268-20', 'Pineda, Karl, Reyes', '125 Unit San Jose Street, Mandaluyong City', 639745612359, 'karl_pineda@yahoo.com', '2001-08-19', 'Single', 'N/A'),
	('235-56921-29', 'Raya, Joshua, Constantino', 'Unit 8895 San Juan Drive, Antipolo City', 639789456258, 'raya_joshua@yahoo.com', '1999-09-25', 'Single', 'N/A'),
	('265-65931-23', 'Fabian, Camille, Baluyot', 'Unit 42 San Jose Drive, Makati City', 639365987456, 'fabian_camille@yahoo.com', '2000-03-01', 'Single', 'N/A'),
	('456-15360-19', 'Ong, Kevin Ryan, Pamintuan', 'Juan Street Xavier Village, Paranaque City', 639156892153, 'ong_kevin@yahoo.com', '2001-11-26', 'Single', 'N/A'),
	('489-35687-20', 'Cuevas, Alexis, Arciaga', 'Block 5 Lot 2 Heaven Village, Las Pinas City', 639562123823, 'cuevas_alexis@yahoo.com', '2002-05-23', 'Single', 'N/A'),
	('565-58985-12', 'Bonifacio, Glenn, Berzabio', 'Unit 2319 Quirino Drive, Antipolo City', 639125666222, 'bonifacio_glenn@yahoo.com', '1999-06-06', 'Single', 'N/A'),
	('568-15623-17', 'Orozco, Nikki, Guansing', 'Block 6 Lot 8 Santo Nino Subdivision, Antipolo City', 639258147456, 'orozco_nikki@yahoo.com', '1998-11-20', 'Single', 'N/A'),
	('789-12354-20', 'Ambos, Kenneth, Angeles', 'Block 4 Lot 6 Habanos Subdivision, Taguig City', 639565698523, 'ambos_kenneth@yahoo.com', '2001-03-25', 'Single', 'N/A');
/*!40000 ALTER TABLE `personal_information` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

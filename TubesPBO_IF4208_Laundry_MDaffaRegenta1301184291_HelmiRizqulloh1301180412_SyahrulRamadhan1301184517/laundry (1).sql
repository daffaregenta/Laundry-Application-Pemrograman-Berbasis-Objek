-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2019 at 04:43 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Id_Admin` int(10) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Position` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Id_Admin`, `Name`, `Password`, `Position`, `Username`) VALUES
(1301184463, 'Salsabilla Rinaldi', 'pekanbaru', 'Manager', 'sabila');

-- --------------------------------------------------------

--
-- Table structure for table `costumer`
--

CREATE TABLE `costumer` (
  `Name` varchar(100) NOT NULL,
  `PhoneNumber` varchar(15) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `costumer`
--

INSERT INTO `costumer` (`Name`, `PhoneNumber`, `Address`, `Username`, `Password`) VALUES
('salsa', '08132323', 'jl hehe', 'salarinaldi', 'apaya'),
('Salsabilla rinaldi', '081365437165', 'jl telkom', 'salsarinaldi', 'apayalupa'),
('aaa', 'bb', 'cc', 'ddd', 'eee'),
('aaa', 'bbb', 'cc', 'dd', 'ee'),
('Lintang', '12312', 'asda', 'lintang', 'LINTANG123');

-- --------------------------------------------------------

--
-- Table structure for table `orderan`
--

CREATE TABLE `orderan` (
  `Id_Order` int(11) NOT NULL,
  `Clothes` varchar(11) NOT NULL,
  `Shoes` varchar(11) NOT NULL,
  `Bag` varchar(11) NOT NULL,
  `BedCover` varchar(11) NOT NULL,
  `Type of Service` varchar(20) DEFAULT NULL,
  `Type of Retrieval` varchar(20) NOT NULL,
  `Entry Date` date NOT NULL,
  `Finish Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `idlaundry` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `notelp` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `jcucian` varchar(255) NOT NULL,
  `service` varchar(255) NOT NULL,
  `rett` varchar(255) NOT NULL,
  `berat` int(255) NOT NULL,
  `harga` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`idlaundry`, `nama`, `notelp`, `alamat`, `jcucian`, `service`, `rett`, `berat`, `harga`) VALUES
('LDR001', 'Lintang', '081268597024', 'Pekanbaru', 'Pakaian , Sepatu murah', '', '', 5, 30000),
('LDR002', 'Sabil', '0812', 'Pekanbaruu', 'Sepatu', '', '', 1, 10000),
('LDR003', 'yogh', '056412314156113', 'medan', 'color segitiga', '', '', 5, 50000),
('LDR004', 'TT', '012', 'asdasd', 'Pakaian', 'Express (1 day)', 'Delivery', 1, 12000),
('LDR005', 'AA', 'DD', 'ESAE', 'Sepatu', 'Express (1 day)', 'Delivery', 2, 18000),
('LDR006', 'Lintang', '0812', 'asdas', 'Pakaian', 'Express (1 day)', 'Delivery', 1, 12000),
('LDR007', 'AA', 'BB', 'BBB', 'Pakaian', 'Express (1 day)', 'Delivery', 1, 12000),
('LDR008', 'DD', 'DD', 'D', 'Pakaian', 'Express (1 day)', 'Pickup', 1, 9000),
('LDR009', 'SADSA', 'SDADS', 'SAD', 'Pakaian', 'Express (1 day)', 'Delivery', 1, 12000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Id_Admin`);

--
-- Indexes for table `orderan`
--
ALTER TABLE `orderan`
  ADD PRIMARY KEY (`Id_Order`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`idlaundry`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Id_Admin` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1301184464;

--
-- AUTO_INCREMENT for table `orderan`
--
ALTER TABLE `orderan`
  MODIFY `Id_Order` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

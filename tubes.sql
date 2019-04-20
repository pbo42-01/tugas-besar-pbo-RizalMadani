-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2019 at 12:42 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `mutasi`
--

CREATE TABLE `mutasi` (
  `IDMutasi` varchar(20) NOT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `keterangan` varchar(50) DEFAULT NULL,
  `IDPengguna` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mutasi`
--

INSERT INTO `mutasi` (`IDMutasi`, `jenis`, `tanggal`, `jumlah`, `keterangan`, `IDPengguna`) VALUES
('1', 'pemasukan', '2019-04-20', 50000, 'Sandang', 'riz'),
('2', 'pengeluaran', '2019-04-20', 50000, 'Sandang', 'riz'),
('3', 'pemasukan', '2019-04-20', 100000, 'Traveling', 'lifi'),
('4', 'pengeluaran', '2019-04-20', 600000, 'Traveling', 'lifi'),
('5', 'pengeluaran', '2019-04-20', 1000000, 'Hiburan', 'peggy'),
('6', 'pemasukan', '2019-04-20', 2000000, 'Hiburan', 'peggy');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `IDPengguna` varchar(20) NOT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `noHp` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`IDPengguna`, `pass`, `nama`, `noHp`) VALUES
('kk', '321', 'Seseorang', '081'),
('lifi', '123', 'Alifiya', '081'),
('peggy', '111', 'Peggy', '081'),
('qq', '234', 'Someone', '081'),
('riz', '000', 'Rizal', '081');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mutasi`
--
ALTER TABLE `mutasi`
  ADD PRIMARY KEY (`IDMutasi`),
  ADD KEY `FK_IDPengguna` (`IDPengguna`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`IDPengguna`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mutasi`
--
ALTER TABLE `mutasi`
  ADD CONSTRAINT `FK_IDPengguna` FOREIGN KEY (`IDPengguna`) REFERENCES `pengguna` (`IDPengguna`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

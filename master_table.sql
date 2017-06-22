-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2017 at 03:54 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `master_table`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` smallint(6) NOT NULL,
  `nama` tinytext NOT NULL,
  `merk` tinytext NOT NULL,
  `type/seri` tinytext NOT NULL,
  `satuan` varchar(15) NOT NULL,
  `masa_pakai` char(2) NOT NULL,
  `ket` tinytext NOT NULL,
  `del` tinyint(1) NOT NULL,
  `del_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mod_by` tinytext NOT NULL,
  `mod_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `even` text NOT NULL,
  `user_id` tinytext NOT NULL,
  `time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `del` tinyint(1) DEFAULT '0',
  `del_on` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `modified_by` tinytext NOT NULL,
  `modified_on` timestamp NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nota`
--

CREATE TABLE `nota` (
  `id` bigint(20) NOT NULL,
  `total_barang` tinytext NOT NULL,
  `total_harga` tinytext NOT NULL,
  `waktu_trx` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_id` tinytext NOT NULL,
  `del` tinyint(1) NOT NULL,
  `del_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mod_by` tinytext NOT NULL,
  `mod_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `id_barang` bigint(20) NOT NULL,
  `stok` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` bigint(20) NOT NULL,
  `id_nota` bigint(20) NOT NULL,
  `barang_id` smallint(6) NOT NULL,
  `qty` varchar(4) NOT NULL,
  `harga` varchar(9) NOT NULL,
  `del` tinyint(1) NOT NULL,
  `del_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mod_by` varchar(10) NOT NULL,
  `mod_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `nama` tinytext NOT NULL,
  `pass` tinytext NOT NULL,
  `email` tinytext NOT NULL,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  `del_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modified_by` tinytext NOT NULL,
  `modified_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2017 at 09:14 AM
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
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` bigint(20) NOT NULL,
  `even` text NOT NULL,
  `user_id` tinytext NOT NULL,
  `time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `del` tinyint(1) DEFAULT '0',
  `del_on` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `modified_by` tinytext NOT NULL,
  `modified_on` timestamp NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES
(1, 'insert User dengan id 1', '1234565', '2017-06-08 03:58:31', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00'),
(2, 'insert User dengan id 2', '1234565', '2017-06-08 03:59:19', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00'),
(3, 'insert User dengan id 1', '1234565', '2017-06-08 04:01:18', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00'),
(4, 'Hapus User dengan id 4', '1234565', '2017-06-08 04:27:37', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00'),
(5, 'insert User dengan id 25', '1234565', '2017-06-08 04:38:54', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(4) NOT NULL,
  `nama` tinytext NOT NULL,
  `pass` tinytext NOT NULL,
  `email` tinytext NOT NULL,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  `del_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modified_by` tinytext NOT NULL,
  `modified_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `pass`, `email`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES
(1, 'qwre', 'qwre', 'qwre', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00'),
(2, 'qwre', 'qwre', 'qwre', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00'),
(4, 'qwre', 'qwre', 'qwre', 1, '2017-06-08 04:27:37', '1234565', '2017-06-08 04:27:37'),
(25, 'qwre', 'qwre', 'qwre', 0, '0000-00-00 00:00:00', '', '0000-00-00 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

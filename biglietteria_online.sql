-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Lug 05, 2017 alle 17:58
-- Versione del server: 10.1.16-MariaDB
-- Versione PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biglietteria_online`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `biglietti`
--

CREATE TABLE `biglietti` (
  `cod_operazione` int(6) NOT NULL,
  `cod_cliente` varchar(4) NOT NULL,
  `cod_replica` varchar(4) NOT NULL,
  `data_ora` datetime NOT NULL,
  `tipo_pagamento` varchar(20) NOT NULL,
  `quantita` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `clienti`
--

CREATE TABLE `clienti` (
  `cod_cliente` varchar(4) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `telefono` varchar(14) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `clienti`
--

INSERT INTO `clienti` (`cod_cliente`, `cognome`, `nome`, `telefono`, `email`) VALUES
('0001', 'Alfieri', 'Valeria', '011/432843', 'alf@libero.it'),
('0002', 'Bellotti', 'Cinzia', '011/45984551', 'bel@tin.it'),
('0003', 'Morgeri', 'Giuseppe', '011/468421684', 'dig@email.it'),
('0004', 'Bastioni', 'Gianluca', '011/4987654', 'fai@virg.it'),
('0005', 'Francini', 'Massimiliano', '011/9876548', 'fra@lib.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `repliche`
--

CREATE TABLE `repliche` (
  `cod_replica` varchar(4) NOT NULL,
  `cod_spettacolo` varchar(4) NOT NULL,
  `data_replica` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `repliche`
--

INSERT INTO `repliche` (`cod_replica`, `cod_spettacolo`, `data_replica`) VALUES
('R001', 'S001', '2015-07-15'),
('R002', 'S001', '2015-07-16'),
('R003', 'S001', '2015-07-17'),
('R004', 'S001', '2015-07-18'),
('R005', 'S001', '2015-07-19'),
('R006', 'S002', '2015-07-20'),
('R007', 'S002', '2015-07-21'),
('R008', 'S002', '2015-07-22'),
('R009', 'S002', '2015-07-23'),
('R010', 'S002', '2015-07-24'),
('R011', 'S003', '2015-07-25'),
('R012', 'S003', '2015-07-26'),
('R013', 'S003', '2015-07-27'),
('R014', 'S003', '2015-07-28'),
('R015', 'S003', '2015-07-29'),
('R016', 'S004', '2015-07-30'),
('R017', 'S004', '2015-08-01'),
('R018', 'S004', '2015-08-02'),
('R019', 'S004', '2015-08-03'),
('R020', 'S004', '2015-08-04'),
('R021', 'S005', '2015-08-05'),
('R022', 'S005', '2015-08-06'),
('R023', 'S005', '2015-08-07'),
('R024', 'S005', '2015-08-08'),
('R025', 'S005', '2015-08-09'),
('R026', 'S006', '2015-08-10'),
('R027', 'S006', '2015-08-11'),
('R028', 'S006', '2015-08-12'),
('R029', 'S006', '2015-08-13'),
('R030', 'S006', '2015-08-14');

-- --------------------------------------------------------

--
-- Struttura della tabella `spettacoli`
--

CREATE TABLE `spettacoli` (
  `cod_spettacolo` varchar(4) NOT NULL,
  `titolo` varchar(45) NOT NULL,
  `autore` varchar(25) NOT NULL,
  `regista` varchar(25) NOT NULL,
  `prezzo` double(6,2) NOT NULL,
  `cod_teatro` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `spettacoli`
--

INSERT INTO `spettacoli` (`cod_spettacolo`, `titolo`, `autore`, `regista`, `prezzo`, `cod_teatro`) VALUES
('S001', 'Appunti per un film sulla lotta di classe', 'Ascanio Celestini', 'Ascanio Celestini', 20.00, 'T001'),
('S002', 'Il birraio di Preston', 'Andrea Camilleri', 'Giuseppe Dipasquale', 20.00, 'T001'),
('S003', 'La Traviata', 'Giuseppe Verdi', 'Laurent Pelly', 40.00, 'T002'),
('S004', 'La Bohème', 'Giacomo Puccini', 'Giuseppe Patroni Griffi', 40.00, 'T002'),
('S005', 'Poveri, ma belli', 'Gianni Togni', 'Massimo Ranieri', 25.00, 'T003'),
('S006', 'Il Sogno del piccolo imperatore', 'Gian Mesturino', 'Alberto Barbi', 25.00, 'T003');

-- --------------------------------------------------------

--
-- Struttura della tabella `teatri`
--

CREATE TABLE `teatri` (
  `cod_teatro` varchar(4) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `indirizzo` varchar(30) NOT NULL,
  `citta` varchar(25) NOT NULL,
  `provincia` varchar(2) NOT NULL,
  `telefono` varchar(14) NOT NULL,
  `posti` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `teatri`
--

INSERT INTO `teatri` (`cod_teatro`, `nome`, `indirizzo`, `citta`, `provincia`, `telefono`, `posti`) VALUES
('T001', 'Teatro Carignano', 'Piazza Carignano 6', 'Torino', 'TO', '011/3456759', 875),
('T002', 'Teatro Regio', 'Piazza Castello 2', 'Torino', 'TO', '011/9870654', 1592),
('T003', 'Teatro Alfieri', 'Piazza Solferino 4', 'Torino', 'TO', '011/6574895', 1500);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `biglietti`
--
ALTER TABLE `biglietti`
  ADD PRIMARY KEY (`cod_operazione`);

--
-- Indici per le tabelle `clienti`
--
ALTER TABLE `clienti`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indici per le tabelle `repliche`
--
ALTER TABLE `repliche`
  ADD PRIMARY KEY (`cod_replica`);

--
-- Indici per le tabelle `spettacoli`
--
ALTER TABLE `spettacoli`
  ADD PRIMARY KEY (`cod_spettacolo`);

--
-- Indici per le tabelle `teatri`
--
ALTER TABLE `teatri`
  ADD PRIMARY KEY (`cod_teatro`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `biglietti`
--
ALTER TABLE `biglietti`
  MODIFY `cod_operazione` int(6) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

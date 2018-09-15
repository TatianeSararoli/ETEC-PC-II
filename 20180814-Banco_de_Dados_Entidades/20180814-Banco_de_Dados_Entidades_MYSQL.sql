-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12-Set-2018 às 23:36
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `MATRICULA` int(11) NOT NULL,
  `NOME` varchar(200) NOT NULL,
  `ENDERECO` varchar(200) NOT NULL,
  `BAIRRO` varchar(100) NOT NULL,
  `CEP` int(100) NOT NULL,
  `NR_CURSO` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`MATRICULA`, `NOME`, `ENDERECO`, `BAIRRO`, `CEP`, `NR_CURSO`) VALUES
(1100, 'CARLOS ALVES MONTEIRO', 'AVENIDA', 'JARDIM', 99000, 110),
(1099, 'CASSIANO ABEL COUTO', 'AVENIDA', 'JARDIM', 99000, 110),
(1101, 'CARLOTA ALVES MONTEIRO', 'RUA', 'VILA', 99000, 120),
(1102, 'MARIANA GONCALVES SOUZA', 'ALAMEDA', 'PONTE', 99000, 120),
(1103, 'RITA DE CASSIA FURLAN', 'AVENIDA', 'JARDIM', 99000, 110),
(1104, 'MARCONDES FURLAN', 'RUA', 'VILA', 99000, 100),
(1105, 'ANA TORIBIO', 'ALAMEDA', 'PONTE', 99000, 100),
(1106, 'ANABELLA SILVA', 'AVENIDA', 'JARDIM', 99000, 100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `NR_CURSO` int(11) NOT NULL,
  `NOME_CURSO` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`NR_CURSO`, `NOME_CURSO`) VALUES
(100, 'SISTEMAS DE INFORMACAO'),
(110, 'CIENCIAS ECONOMICAS'),
(120, 'SANEAMENTO BASICO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `ID_DISCIPLINA` varchar(3) NOT NULL,
  `NOME_DISCIPLINA` varchar(40) NOT NULL,
  `CARGA_HORARIA` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`ID_DISCIPLINA`, `NOME_DISCIPLINA`, `CARGA_HORARIA`) VALUES
('EPB', 'ESTUDO DE PROBLEMAS BRASILEIROS', 45);

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico`
--

CREATE TABLE `historico` (
  `MATRICULA` int(11) NOT NULL,
  `ID_DISCIPLINA` varchar(3) NOT NULL,
  `ANO` int(11) NOT NULL,
  `SEMESTRE` int(11) NOT NULL,
  `NOTA` decimal(3,1) DEFAULT NULL,
  `FREQUENCIA` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `historico`
--

INSERT INTO `historico` (`MATRICULA`, `ID_DISCIPLINA`, `ANO`, `SEMESTRE`, `NOTA`, `FREQUENCIA`) VALUES
(1099, 'EPB', 2012, 1, '80.0', 45);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`MATRICULA`),
  ADD KEY `NR_CURSO` (`NR_CURSO`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`NR_CURSO`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`ID_DISCIPLINA`);

--
-- Indexes for table `historico`
--
ALTER TABLE `historico`
  ADD PRIMARY KEY (`MATRICULA`,`ID_DISCIPLINA`,`ANO`,`SEMESTRE`),
  ADD KEY `ID_DISCIPLINA` (`ID_DISCIPLINA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

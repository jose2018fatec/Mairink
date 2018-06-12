-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.21-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.4.0.5169
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para bd_projetoescola
CREATE DATABASE IF NOT EXISTS `bd_projetoescola` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `bd_projetoescola`;

-- Copiando estrutura para tabela bd_projetoescola.alugueis
CREATE TABLE IF NOT EXISTS `alugueis` (
  `codaluguel` int(11) NOT NULL AUTO_INCREMENT,
  `nomeusuario` varchar(50) COLLATE utf8_bin NOT NULL,
  `nomelivro` varchar(50) COLLATE utf8_bin NOT NULL,
  `dtdevolucao` date NOT NULL,
  PRIMARY KEY (`codaluguel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela bd_projetoescola.livros
CREATE TABLE IF NOT EXISTS `livros` (
  `codlivro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE utf8_bin NOT NULL,
  `autor` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codlivro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela bd_projetoescola.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `codusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

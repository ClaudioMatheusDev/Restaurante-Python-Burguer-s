-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15/11/2025 às 20:17
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `restaurantedb`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cardapios`
--

CREATE TABLE `cardapios` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `composicao` text NOT NULL,
  `preco` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cardapios`
--

INSERT INTO `cardapios` (`id`, `name`, `composicao`, `preco`) VALUES
(3, 'Burguer HTML', '2 hamburguer, 2 mussarela, bacon, alface, tomate', 22.90);

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `clientes`
--

INSERT INTO `clientes` (`id`, `name`, `email`, `phone`) VALUES
(1, 'Atenor', 'Atenor@gmail.com', '(18)99879089867'),
(2, 'Genostor', 'genost@gmail.com', '18996459890');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cardapios`
--
ALTER TABLE `cardapios`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cardapios`
--
ALTER TABLE `cardapios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

-- --------------------------------------------------------

--
-- Estrutura para tabela `contatos`
--

CREATE TABLE `contatos` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `subject` varchar(150) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices de tabela `contatos`
--
ALTER TABLE `contatos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabela `contatos`
--
ALTER TABLE `contatos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- Estrutura para tabela `encomendas`
--

CREATE TABLE `encomendas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `cardapio_id` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL DEFAULT 1,
  `observacoes` text DEFAULT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Pendente',
  `data_encomenda` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices de tabela `encomendas`
--
ALTER TABLE `encomendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cliente` (`cliente_id`),
  ADD KEY `fk_cardapio` (`cardapio_id`);

--
-- AUTO_INCREMENT de tabela `encomendas`
--
ALTER TABLE `encomendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas `encomendas`
--
ALTER TABLE `encomendas`
  ADD CONSTRAINT `fk_cardapio` FOREIGN KEY (`cardapio_id`) REFERENCES `cardapios` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`) ON DELETE CASCADE;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

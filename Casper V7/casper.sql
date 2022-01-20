-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 19 jan. 2022 à 07:29
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `casper`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

DROP TABLE IF EXISTS `articles`;
CREATE TABLE IF NOT EXISTS `articles` (
  `code` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `description` text NOT NULL,
  `img` text NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`code`, `stock`, `nom`, `prix`, `description`, `img`) VALUES
('fr234', 100, 'Collier mille pate', 35, 'Un beau collier esthetique', 'https://i.imgur.com/d1EufaW.jpeg,https://i.imgur.com/d1EufaW.jpeg,https://i.imgur.com/d1EufaW.jpeg'),
('fr235', 100, 'Un Collier', 75, 'Un collier pour femme', 'https://i.imgur.com/tEM7kI8.jpeg,https://i.imgur.com/tEM7kI8.jpeg,https://i.imgur.com/tEM7kI8.jpeg'),
('fr252', 100, 'Boucle d\'oreilles Clef', 640, 'Des boucle d oreil de serrurier', 'https://i.imgur.com/hFjFK1t.jpeg,https://i.imgur.com/hFjFK1t.jpeg,https://i.imgur.com/hFjFK1t.jpeg'),
('fr256', 100, 'Boucle d\'oreil', 20, 'Des boucle d\'oreilles', 'https://i.imgur.com/aNRzF2c.jpeg,https://i.imgur.com/aNRzF2c.jpeg,https://i.imgur.com/aNRzF2c.jpeg'),
('fr267', 100, 'Collier en Or', 365, 'Un collier', 'https://i.imgur.com/Ue3ixDy.jpeg,https://i.imgur.com/Ue3ixDy.jpeg,https://i.imgur.com/Ue3ixDy.jpeg'),
('fr298', 100, 'Bague', 75, 'Une belle bague en Or', 'https://i.imgur.com/B3BSoyI.jpeg,https://i.imgur.com/B3BSoyI.jpeg,https://i.imgur.com/B3BSoyI.jpeg');

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `pseudo` varchar(255) NOT NULL,
  `comment` text NOT NULL,
  `comment_set` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_set`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `comments`
--

INSERT INTO `comments` (`pseudo`, `comment`, `comment_set`) VALUES
('amine', 'sdfjsdfbsdfb', '2022-01-18 19:08:04');

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`email`, `password`) VALUES
('amine@gmail.com', '$2y$11$046a6a1db912541657a43OybFmqKV5foNg.guvFRQOjedHEfU79MO'),
('chris@gmail.com', '$2y$11$c8ce8dd5c4aaa48ad0077eyhdZICcDJQttArRwSw3pscQ3Q9tDyq6');

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--
-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 22 jan. 2022 à 12:17
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
('fr235', 100, 'Un Collier Test', 75, 'Un collier pour femme&quot;', 'https://i.imgur.com/tEM7kI8.jpeg,https://i.imgur.com/tEM7kI8.jpeg,https://i.imgur.com/tEM7kI8.jpeg'),
('fr252', 100, 'Boucle d\'oreilles', 640, 'Des boucle d oreil de serrurier&quot;', 'https://i.imgur.com/hFjFK1t.jpeg,https://i.imgur.com/hFjFK1t.jpeg,https://i.imgur.com/hFjFK1t.jpeg'),
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
('amine', 'sdfjsdfbsdfb', '2022-01-18 19:08:04'),
('test', 'sdfgthdfghj', '2022-01-19 09:36:16');

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
('admin@gmail.com', '$2y$11$80d6fe396ba3240311c51ebUryK0q2CBHhzLTq9c7HI3RZUsNnUg2'),
('amine@gmail.com', '$2y$11$046a6a1db912541657a43OybFmqKV5foNg.guvFRQOjedHEfU79MO'),
('chris@gmail.com', '$2y$11$c8ce8dd5c4aaa48ad0077eyhdZICcDJQttArRwSw3pscQ3Q9tDyq6'),
('test@gmail.com', '$2y$11$3f2a548e9dd5c1139441cevQiejPiOc399wLZWRe8jRcOjzRVLlFm'),
('ziya@dfgb', '$2y$11$812b29ce847b4e279d3bcuA4w4sf7lFbgAAGFy2QTn0zFtYJ7n1g6'),
('ziya@gnail.com', '$2y$11$9281719a942099829b1edO1hAxXdOIMLQmCwUf6xWRU1Y5JBKk3Wm');

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE IF NOT EXISTS `projet` (
  `num_projet` int(11) NOT NULL,
  `nom` varchar(250) DEFAULT NULL,
  `lien` text,
  `description` varchar(8000) DEFAULT NULL,
  PRIMARY KEY (`num_projet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`num_projet`, `nom`, `lien`, `description`) VALUES
(1, 'a', 'http://fullhdwall.com/wp-content/uploads/2016/11/Colorful-HD-Flower.jpg,http://www.gratuit-en-ligne.com/telecharger-gratuit-en-ligne/telecharger-image-wallpaper-gratuit/image-wallpaper-fleur-plante/img/images/image-wallpaper-fleur-plante-de-nenuphar.jpg,https://c.pxhere.com/photos/96/1a/cape_basket_close_blossom_bloom_pink_violet_summer_color-596012.jpg!d', '                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium itaque quod quia error porro modi, tempora tempore molestias fugit eius voluptate architecto! Vitae voluptates velit perspiciatis eveniet cumque eaque voluptatibus.\r\n                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Totam iure, unde doloribus iusto veritatis soluta delectus vero nihil saepe ea, molestiae quidem, dignissimos velit necessitatibus rem ipsa assumenda ipsam nisi.\r\n                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nostrum non, ab consequuntur sequi sapiente exercitationem nam enim quidem eligendi eum praesentium repellat nesciunt amet aut dolor labore molestias. Expedita, delectus.'),
(2, 'b', 'https://img.fotocommunity.com/la-fleur-orange-24042d86-57c4-4af7-b4ac-d968fd997f53.jpg?height=1080%27%27', '                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium itaque quod quia error porro modi, tempora tempore molestias fugit eius voluptate architecto! Vitae voluptates velit perspiciatis eveniet cumque eaque voluptatibus.\r\n                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Totam iure, unde doloribus iusto veritatis soluta delectus vero nihil saepe ea, molestiae quidem, dignissimos velit necessitatibus rem ipsa assumenda ipsam nisi.\r\n                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nostrum non, ab consequuntur sequi sapiente exercitationem nam enim quidem eligendi eum praesentium repellat nesciunt amet aut dolor labore molestias. Expedita, delectus.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  Dim 13 mars 2022 à 14:49
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `assoc`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `pseudo` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `mdp` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`pseudo`, `mdp`) VALUES
('general', 'azerty0'),
('mouni', 'azerty1');

-- --------------------------------------------------------

--
-- Structure de la table `maraudes`
--

CREATE TABLE `maraudes` (
  `num` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `date` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `lieu` text COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `maraudes`
--

INSERT INTO `maraudes` (`num`, `nom`, `description`, `date`, `lieu`) VALUES
('1', 'Maraude devant la médiathèque Ulysse', 'On se donne rdv devant la médiathèque Ulysse à Saint-Denis pour une maraude. Venez nombreux.', '21/12/2022', 'https://www.google.fr/maps/place/M%C3%A9diath%C3%A8que+Ulysse/@48.9283658,2.3661068,17z/data=!3m1!4b1!4m5!3m4!1s0x47e66ea8ddcdaacb:0x494e74bdae202a99!8m2!3d48.9283625!4d2.3682953'),
('2', 'Maraude à Aubervilliers', 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Non veniam laudantium eius inventore dolores minima eaque ab, expedita ad optio perspiciatis eos voluptate ea nesciunt modi illum enim, assumenda et?', '13/01/2022', 'https://www.google.fr/maps/place/93300+Aubervilliers/@48.9128272,2.3798061,15z/data=!3m1!4b1!4m5!3m4!1s0x47e66c3d7604e9af:0x306b113348748528!8m2!3d48.9122621!4d2.3840439');

-- --------------------------------------------------------

--
-- Structure de la table `msgs`
--

CREATE TABLE `msgs` (
  `nom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `msg` text COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `msgs`
--

INSERT INTO `msgs` (`nom`, `prenom`, `email`, `msg`) VALUES
('CISSE', 'Mounirou', 'mounirou.cisse@outlook.fr', 'je suis le roi du monde et oui mon petit');

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE `participant` (
  `num` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tel` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `participant`
--

INSERT INTO `participant` (`num`, `nom`, `prenom`, `email`, `tel`) VALUES
('1', 'CISSE', 'Mounirou', 'mounzei@outlook.fr', '0627530696'),
('1', 'Cissé', 'Mounirou', 'mounirou.cisse@outlook.fr', '0627530696');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`pseudo`);

--
-- Index pour la table `maraudes`
--
ALTER TABLE `maraudes`
  ADD PRIMARY KEY (`num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

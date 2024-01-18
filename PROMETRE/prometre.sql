-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 22 août 2023 à 14:47
-- Version du serveur : 8.0.31
-- Version de PHP : 7.4.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `prometre`
--

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

CREATE TABLE `employes` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `numero` int NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `fonction` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `projets`
--

CREATE TABLE `projets` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `id_responsable` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nomClients` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `refDossiers` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `telClients` int NOT NULL,
  `coordonneesChantier` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `store`
--

CREATE TABLE `store` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_projet` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `materiel` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `acces` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `manutention` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `deposeAncienStore` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `questionAS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `travaux`
--

CREATE TABLE `travaux` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_projet` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tables` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `projets`
--
ALTER TABLE `projets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_responsable` (`id_responsable`);

--
-- Index pour la table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`id`,`id_projet`),
  ADD KEY `id_projet` (`id_projet`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `travaux`
--
ALTER TABLE `travaux`
  ADD PRIMARY KEY (`id`,`id_projet`),
  ADD KEY `id_projet` (`id_projet`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `projets`
--
ALTER TABLE `projets`
  ADD CONSTRAINT `projets_ibfk_1` FOREIGN KEY (`id_responsable`) REFERENCES `employes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `store_ibfk_2` FOREIGN KEY (`id_projet`) REFERENCES `projets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `travaux`
--
ALTER TABLE `travaux`
  ADD CONSTRAINT `travaux_ibfk_1` FOREIGN KEY (`id_projet`) REFERENCES `projets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

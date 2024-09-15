-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le : dim. 15 sep. 2024 à 19:00
-- Version du serveur : 10.10.2-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tennis`
--

-- --------------------------------------------------------

--
-- Structure de la table `user_tennis`
--

DROP TABLE IF EXISTS `user_tennis`;
CREATE TABLE IF NOT EXISTS `user_tennis` (
                                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `email` varchar(45) NOT NULL,
    `old_password` varchar(64) NOT NULL,
    `password` varchar(64) NOT NULL,
    `username` varchar(64) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKrhv0iwfbb0f4u0sa96bix1ox0` (`email`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `user_tennis`
--

INSERT INTO `user_tennis` (`id`, `email`, `old_password`, `password`, `username`) VALUES
    (1, 'admin@yahoo.com', '', '$2a$10$iEbX/zHQSsZ4EyaJhd5d6.3oeJTk3/GxUFDJBpR8yX9Ifp0dwgERi', 'admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

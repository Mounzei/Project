<?php

$choix =$_GET['movie'];

session_start();
// var_dump($_SESSION);
/* Arguments :
        DSN (data source name - nom et emplacement de la BDD),
        nom d'utilisateur,
        mdp d'utilisateur
*/
$lien = new PDO(
     'mysql:host=home.3wa.io;port=3307;dbname=sev-03_cissemounirou_connexion',
     'cissemounirou',
     '4e3c883dOWJiMTQxMGU1ODJmNzZiNzY4NTIyZjlkfce25b97'
     );
$lien->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$lien->exec('SET NAMES UTF8');
// "Préparer" une requête
$req = $lien->prepare(
    "SELECT 
        title,
        name,
        movie,
        description,
        img,
        original_title, 
        origin_contry, 
        date
    FROM movies"
);

// Executer la requête
$req->execute();

// Maintenant que la requête a été exécutée, réceptionner le résultat
$movies = $req->fetchAll(PDO::FETCH_ASSOC);
//var_dump($movies);

include 'movie.phtml';

?>
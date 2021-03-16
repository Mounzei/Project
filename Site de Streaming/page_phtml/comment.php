<?php

session_start();
// var_dump($_SESSION);

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
        *
    FROM comment
    ORDER BY comment_set"
);

// Executer la requête
$req->execute();

// Maintenant que la requête a été exécutée, réceptionner le résultat
$comments = $req->fetchAll(PDO::FETCH_ASSOC);
// var_dump($comments);

include 'comment.phtml';

?>
<?php

$hn = 'localhost';
$un = ''; // Votre nom d'utilisateur de votre base de données
$pw = ''; // Votre mot de passe pour la base de données
$dbn = 'assoc';

// msg erreur

function mysql_fatal_error(){
    echo <<< _END
    Nous sommes désolés mais il n'est pas possible d'effectuer la tâche demandée. L'erreur rencontré est la suivante: 
    <p>Erreur fatale</p>
    Cliquez sur le bouton précédent de votre navigateur et réessayer. Si le problèmes persistent ou que vous en rencontriez de nouveux
    communiquez avec <a href="mailto:mounzei@outlook.fr">notre administrateur</a>. Merci.
    _END;
};

// creation lien avec la base de donnée

$pdo = new PDO(
    "mysql:host=$hn;port=3306;dbname=$dbn",
    "$un",
    "$pw"
);
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$pdo->exec('SET NAMES UTF8');

?>
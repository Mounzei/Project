<?php
    $lien = new PDO(
        'mysql:host=localhost;port=3306;dbname=prometre',
        'root', // identifiant 
        'mysql' // mot de passe
        );
    $lien->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $lien->exec('SET NAMES UTF8');
?>
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
if(isset($_SESSION['firstName']) AND isset($_POST['newPseudo']) AND isset($_POST['newEmail']))
{
    $req=$lien->prepare('UPDATE connecté SET Pseudo=?, email=? WHERE name=?');
	$req->execute([$_POST['newPseudo'],$_POST['newEmail'],$_SESSION['firstName']]);
	$req->closeCursor();
	echo 'Vos informations ont été changé.';
};



include 'changement2.phtml';

?>

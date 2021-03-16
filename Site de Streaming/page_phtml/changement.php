<?php

session_start();

function verifyPassword($password, $hashedPassword)
{
        return crypt($password, $hashedPassword) == $hashedPassword;
}

function hashPassword($password) // permet de crypter le mot de passe 
{
       
        $salt = '$2y$11$'.substr(bin2hex(openssl_random_pseudo_bytes(32)), 0, 22);
        

        return crypt($password, $salt); 
}

$lien = new PDO(
     'mysql:host=home.3wa.io;port=3307;dbname=sev-03_cissemounirou_connexion',
     'cissemounirou',
     '4e3c883dOWJiMTQxMGU1ODJmNzZiNzY4NTIyZjlkfce25b97'
     );
$lien->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$lien->exec('SET NAMES UTF8');
// "Préparer" une requête
if(isset($_SESSION['email']) AND isset($_POST['pass']) AND isset($_POST['NewPass']) AND isset($_POST['NewPassVerif']))
{
// $pass_hache=verifyPassword($_POST['pass']);		    
$req = $lien->prepare(
    "SELECT 
        password
    FROM connecté
    WHERE
        email = ?
    "
);

// Executer la requête
$req->execute([$_SESSION['email']]);
$mdp = $req->fetchAll(PDO::FETCH_ASSOC);
// Maintenant que la requête a été exécutée, réceptionner le résultat
foreach($mdp as $mdps){
$resultat = verifyPassword($_POST['pass'], $mdps['password']);

if($resultat === false)
{
	echo 'mauvais mot de passe';
}
elseif (empty($_POST['NewPass']))
{
	echo 'Le nouveau mot de passe n\'a pas été renseigné.';
}
elseif ($_POST['NewPass'] != $_POST['NewPassVerif'])
{
	echo 'Les mots de passe ne coresspondent pas.';
}
else
{
	$new_pass_hache=hashPassword($_POST['NewPass']);
	$req=$lien->prepare('UPDATE connecté SET password=? WHERE Pseudo=?');
	$req->execute([$new_pass_hache,$_SESSION['pseudo']]);
	$req->closeCursor();
	echo 'Le mot de passe a été changé.';
}
};
};
include 'changement.phtml';

?>
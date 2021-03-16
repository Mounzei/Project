<?php

function hashPassword($password) // permet de crypter le mot de passe 
{
       
        $salt = '$2y$11$'.substr(bin2hex(openssl_random_pseudo_bytes(32)), 0, 22);
        

        return crypt($password, $salt); 
}

// $hash = hashPassword($_POST['newMdp']);
if(isset($_POST['user_mail'])){  
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
        email
    FROM connecté"
);
// Executer la requête
$req->execute();
// Maintenant que la requête a été exécutée, réceptionner le résultat
$email = $req->fetchAll(PDO::FETCH_ASSOC);


if(!empty($_POST['user_mail']) AND !empty($_POST['newMdp']) AND !empty($_POST['verifyNewMdp'])){
    $new_pass_hache = hashPassword($_POST['newMdp']);
	$req=$lien->prepare('UPDATE connecté SET password=? WHERE email=?');
	$req->execute([$new_pass_hache,$_POST['user_mail']]);
	$req->closeCursor();
	echo 'Le mot de passe a été changé.';
    }
	
}	

include 'mdp_oublie.phtml'

?>
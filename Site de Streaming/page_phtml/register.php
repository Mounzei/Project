<?php

function hashPassword($password) // permet de crypter le mot de passe 
{
       
        $salt = '$2y$11$'.substr(bin2hex(openssl_random_pseudo_bytes(32)), 0, 22);
        

        return crypt($password, $salt); 
}

if (isset($_POST['pseudo']) && isset($_POST['name']) && isset($_POST['lastname']) && isset($_POST['email']) && isset($_POST['mdp']) && $_POST['mdp'] == $_POST['mdp1'])
{
  $hash = hashPassword($_POST['mdp']);
  
  $lien = new PDO(
      'mysql:host=home.3wa.io;port=3307;dbname=sev-03_cissemounirou_connexion',
      'cissemounirou',
      '4e3c883dOWJiMTQxMGU1ODJmNzZiNzY4NTIyZjlkfce25b97'
  );
  $lien->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  $lien->exec('SET NAMES UTF8');
  // "Préparer" une requête
  
    $req = $lien->prepare(
      'INSERT INTO
          `connecté`
          (
          `Pseudo`,
          `name`,
          `lastName`,
          `email`,
          `password`)
          VALUES 
          (
          ?,
          ?,
          ?,
          ?,
          ?
          )'
  );
  
    // Executer la requête
     $req->execute([$_POST['pseudo'] ,$_POST['name'], $_POST['lastname'], $_POST['email'], $hash]);
};
// var_dump($_POST);
// Maintenant que la requête a été exécutée, réceptionner le résultat
//$connect = $req->fetchAll(PDO::FETCH_ASSOC);
//

include 'register.phtml';




?>
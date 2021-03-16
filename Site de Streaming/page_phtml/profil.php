<?php

session_start();
// var_dump($_SESSION);

if(isset($_GET['deco'])){
    if($_GET['deco'] == true){
        session_destroy();
        header("Location: login.php");
        exit();
    }
};

if (!empty($_POST['email']) && !empty($_POST['pseudo']) && !empty($_POST['comment']))
{
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
          `comment`
          (
          `email`,
          `pseudo`,
          `comment`)
          VALUES 
          (
          ?,
          ?,
          ?
          )'
  );
  // Executer la requête
  $req->execute([$_POST['email'], $_POST['pseudo'], $_POST['comment']]);
  
};

include 'profil.phtml';

?>
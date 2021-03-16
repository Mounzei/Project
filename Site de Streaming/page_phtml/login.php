w<?php
session_start();

function verifyPassword($password, $hashedPassword)
{
        return crypt($password, $hashedPassword) == $hashedPassword;
}
if(empty($_POST) === false) {
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
        Pseudo,
        name,
        lastname,
        email,
        password
    FROM connecté
    ORDER BY name"
);

// Executer la requête
$req->execute([ $_POST['user_mail'] ]);
// Maintenant que la requête a été exécutée, réceptionner le résultat
$user = $req->fetchAll(PDO::FETCH_ASSOC);
// var_dump($user);

foreach($user as $users){
 if($users === false ){
        echo "Utilisateur inconnu";
    } else {
        if(verifyPassword($_POST['user_mdp'], $users['password']) === true ) {
        
              $_SESSION['pseudo'] = $users['Pseudo'];   
              $_SESSION['firstName'] = $users['name'];
              $_SESSION['lastName'] = $users['lastname'];
              $_SESSION['email'] = $users['email'];
              $nom = $_SESSION['pseudo'];
            
        }
    }
};

/*if(!empty($_POST['user_mail']) && !empty($_POST['user_mdp'])){
    $id = $_POST['user_mail'];
    $mdp = $_POST['user_mdp'];
    foreach($connect as $connects){
        if(in_array($id,$connects,true)===true && in_array($mdp,$connects,true)===true){
              $_SESSION['pseudo'] = $connects['Pseudo'];   
              $_SESSION['firstName'] = $connects['name'];
              $_SESSION['lastName'] = $connects['lastname'];
              $_SESSION['email'] = $connects['email'];
              
              $nom = $_SESSION['pseudo'];
                 
        }
    }
};*/

};

// var_dump($_SESSION);
include 'login.phtml';

?>
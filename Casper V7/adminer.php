<?php
session_start();
$template = 'article';
$title = "ADMIN";
require 'Functions/functions.php';
require 'Functions/bdd.php';
if (isset($_SESSION['email']) && $_SESSION['email'] === 'admin@gmail.com') {
} else {
    header("Location: accueil.php");
}

//RAMENER LES INFO D'UNE COLONNE
// $verif_projet = $pdo->prepare("SELECT * FROM projet order by num_projet DESC");
// $verif_projet->execute();

// $numero_projet = $pdo->prepare("SELECT * FROM projet WHERE num_projet=:num_projet");
// $compter = $numero_projet->rowCount();

// if (isset($_POST['num_projet'])) {
//     // si num projet n'est pas vide, fait une table array projet
//     $insert = $requete->execute(array(
//         'num_projet' => $_POST['num_projet'],
//         'nom' => $_POST['nom'],
//         'lien' => htmlspecialchars($_POST['lien']),
//         'description' => $_POST['description']

//     ));
// }

// //Pour les fonction de d'etition et d'ajout de nouveau projet
// if (isset($_POST['num_projet'])) {


//     //Update a Projet
//     $enregistrer = $pdo->prepare("UPDATE projet SET
// 		num_projet=:num_projet,
// 		nom=:nom,
// 		lien=:lien,
// 		description=:description
			
//         WHERE num_projet={$_POST['num_projet']}");
//     //Enregistrer un projet
//     $update = $enregistrer->execute(array(
//         'num_projet' => $_POST['num_projet'],
//         'nom' => $_POST['nom'],
//         'lien' => $_POST['lien'],
//         'description' => $_POST['description']


//     ));
// }

// function ajout_projet($num_projet, $nom, $lien, $description)
// {

//     $req = $pdo->prepare("INSERT INTO projet VALUES (:num_projet, :nom, :lien, :description)");
//     $req->bindValue(':num_projet', $num_projet);
//     $req->bindValue(':nom', $nom);
//     $req->bindValue(':lien', $lien);
//     $req->bindValue(':description', $description);

//     $req->execute();

//     echo "L'insertion nouvelle a était réalisé sur le projet " . $num_projet;
// }


// function supprimer_projet($num_projet)
// {

//     /* enregistrement du projet dans la table "remplace" */
//     $r = $pdo->prepare("INSERT INTO remplace SELECT * FROM projet WHERE num_projet =:num_projet ");
//     $r->bindValue(':num_projet', $num_projet);
//     $r->execute();


//     /* suppresion du projet dans la table "projet" */
//     $req = $pdo->prepare("DELETE FROM projet WHERE num_projet =:num_projet ");
//     $req->bindValue(':num_projet', $num_projet);
//     $req->execute();

//     echo "Le projet numéro " . $_POST["num_projet"] . " a étais supprimer.";
//     echo "Vous pouvez le recupérer dans la rubrique récupération, vous avez 30 Jours pour le récupérer";
// }


include 'adminer.phtml';

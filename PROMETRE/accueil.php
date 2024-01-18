<?php
session_start();
require "fonctions/co_bdd.php";
require "fonctions/fonctions.php";
$title = "Accueil";
$template = "accueil";

if(isset($_POST['idProjet'], $_SESSION['id'])){
    try {
        $req = $lien->prepare(
            'INSERT INTO
                projets
                (
                id,
                nom,
                id_responsable,
                nomclients,
                refDossiers,
                telClients,
                coordonneesChantier,
                description)
                VALUES 
                (
                ?, ?, ?, ?, ?, ?, ?, ?)'
        );
        // Executer la requête
        $req->execute([$_POST['idProjet'], $_POST['nomProjet'], $_SESSION['id'], $_POST['clientProjet'], $_POST['refDossier'], $_POST['telClient'], $_POST['adrChantier'], $_POST['description']]);
        $erreurProjet = false;
    } catch (\Throwable $th) {
        // throw $th;
        $erreurProjet = true;
    }
}

include "dexin.php";
?>
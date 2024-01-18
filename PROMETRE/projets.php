<?php
session_start();
require "fonctions/co_bdd.php";
require "fonctions/fonctions.php";
$title = "Mes projets";
$template = "projets";

try {
    $req = $lien->prepare(
        "SELECT * FROM projets where id_responsable = :id"
    );
    $req->bindValue("id", $_SESSION['id']);
    $req->execute();
    $projets = $req->fetchAll(PDO::FETCH_ASSOC);
} catch (\Throwable $th) {
    // throw $th;
    $erreurProjet = true;
}

include "dexin.php";
?>
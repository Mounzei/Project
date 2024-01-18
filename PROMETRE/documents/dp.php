<?php
session_start();
require "../fonctions/co_bdd.php";
require "../fonctions/fonctions.php";
$title = "Directive de mise en oeuvre";
$template = "dp";

$table = trouverTable($lien,$_SESSION['idP'],$_GET['numT']);
try {
    $req = $lien->prepare(
        "SELECT materiel, acces, manutention, deposeAncienStore, questionAS FROM `$table[0]` where id_projet = :idP and id = :id"
    );
    $req->bindValue("idP", $_SESSION['idP']);
    $req->bindValue("id", $_GET['numT']);
    $req->execute();
    $donnees = $req->fetch(PDO::FETCH_ASSOC);
} catch (\Throwable $th) {
    // throw $th;
}

include "../pdf.php";
?>
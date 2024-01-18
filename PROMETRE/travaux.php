<?php
session_start();
require "fonctions/co_bdd.php";
require "fonctions/fonctions.php";
$title = "Mes Travaux";
$template = "travaux";

$_SESSION['idP'] = $_GET['numP'];

try {
    $req = $lien->prepare(
        "SELECT * FROM travaux where id_projet = :id"
    );
    $req->bindValue("id", $_SESSION['idP']);
    $req->execute();
    $travaux = $req->fetchAll(PDO::FETCH_ASSOC);
} catch (\Throwable $th) {
    // throw $th;
}

include "dexin.php";
?>
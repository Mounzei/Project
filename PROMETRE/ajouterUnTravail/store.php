<?php
session_start();
$table = "store";
require "../fonctions/co_bdd.php";
require "../fonctions/fonctions.php";
$title = "Store";
$template = "store";

if(isset($_POST['id'])){
    $materiel = $_POST['materiel'];
    $acces = $_POST['acces'];
    if (!empty($_POST['autremateriel'])) {
        $materiel = $_POST['autremateriel'];
    }
    if (!empty($_POST['autreacces'])) {
        $materiel = $_POST['autreacces'];
    }
    $array = [];
    if(isset($_POST['c'])){
        array_push($array,$_POST['c']);
    }
    if(isset($_POST['emc'])){
        array_push($array,$_POST['emc']);
    }
    if(isset($_POST['e'])){
        array_push($array,$_POST['e']);
    }
    if(isset($_POST['cv'])){
        array_push($array,$_POST['cv']);
    }
    $manutention = implode(",",$array);
    majTravaux($lien,$_POST['id'],$_SESSION['idP'],$_POST['nom'],$table);
    try {
        $req = $lien->prepare(
            "INSERT INTO
                $table
                (
                id,
                id_projet,
                materiel,
                acces,
                manutention,
                deposeAncienStore,
                questionAS)
                VALUES 
                (
                ?, ?, ?, ?, ?, ?, ?)"
        );
        // Executer la requête
        if($_POST['as'] === "oui"){
            $req->execute([$_POST['id'], $_SESSION['idP'] ,$materiel, $acces, $manutention, $_POST['as'], $_POST['qas']]);
        }else{
            $req->execute([$_POST['id'], $_SESSION['idP'] ,$materiel, $acces, $manutention, $_POST['as'], null]);
        }
        $erreur = false;
    } catch (\Throwable $th) {
        // throw $th;
        $erreur = true;
    }
}

include "../dexin.php";
?>
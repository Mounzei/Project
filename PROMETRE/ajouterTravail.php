<?php
session_start();
$title = "Ajouter un travail";
$template = "ajouterTravail";

$_SESSION['idP'] = $_GET['numP'];

include "dexin.php";
?>
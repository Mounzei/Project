<?php
session_start();
require "fonction/log_sql.php";
$template = "maraude";
$title = "Nos Maraudes";

$req1 = $pdo->prepare("select * from maraudes");
$req1->execute();
$maraudes = $req1->fetchAll(PDO::FETCH_ASSOC);
$num = [];
foreach ($maraudes as $m) {
    array_push($num,$m['num']);
}

if(isset($_POST,$_POST['email'])){
    try {
        $req = $pdo->prepare("insert into participant values (:num, :nom, :prenom, :email, :tel)");
        $req->bindValue(":num",htmlspecialchars($_POST['maraude']));
        $req->bindValue(":nom",htmlspecialchars($_POST['nom']));
        $req->bindValue(":prenom",htmlspecialchars($_POST['prenom']));
        $req->bindValue(":email",htmlspecialchars($_POST['email']));
        $req->bindValue(":tel",htmlspecialchars($_POST['num']));
        $req->execute();
    } catch (\Exception $e) {
        $error = "Erreur !!!!";
    }    
}

if(isset($_GET['supprimer']) && $_SESSION['admin']){
    try {
        $req = $pdo->prepare("delete from maraudes where num = :n");
        $req->bindValue(':n',htmlspecialchars($_GET['supprimer']));
        $req->execute();
        $req1 = $pdo->prepare("delete from participant where num = :n");
        $req1->bindValue(":n",htmlspecialchars($_GET['supprimer']));
        $req1->execute();
    } catch (\Throwable $th) {
        //throw $th;
    }
    header('Location: maraude.php');
}

include "index.phtml";
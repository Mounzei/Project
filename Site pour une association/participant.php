<?php
require "fonction/log_sql.php";
$template = 'participant';
$title = "Liste des particpants pour la maraude n°".$_GET['id'];

if(isset($_GET['id'])){
    try {
        $req = $pdo->prepare("select * from participant where num = :m");
        $req->bindValue(':m',$_GET['id']);
        $req->execute();
        $participants = $req->fetchAll(PDO::FETCH_ASSOC);
    } catch (\Throwable $th) {
        //throw $th;
    }
}

include 'index.phtml';
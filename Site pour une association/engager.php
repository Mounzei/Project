<?php
session_start();
require "fonction/log_sql.php";
$template = 'engager';
$title = 'S\'engager dans l\'association';

if(isset($_POST['name'],$_POST['email'])){

}
else if(isset($_POST['pseudo'], $_POST['mdp'])){
    try {
        $req = $pdo->prepare("select * from admin where pseudo = :ps");
        $req->bindValue(':ps',$_POST['pseudo']);
        $req->execute();
        $res = $req->fetch(PDO::FETCH_ASSOC);
        $ps = $res['pseudo'];
        $mdp = $res['mdp'];
    } catch (\Throwable $th) {
        echo "Problem";
    }
}
if(htmlspecialchars($_POST['mdp']) === $mdp){
    $_SESSION['admin'] = true;
}
include 'index.phtml';
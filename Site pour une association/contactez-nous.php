<?php
require "fonction/log_sql.php";
$template = 'contactez-nous';
$title = 'Contacts';

if(isset($_POST['nom'], $_POST['email'], $_POST['msg'])){
    try {
        $req = $pdo->prepare("insert into msgs values (:n,:p,:m,:ms)");
        $req->bindValue(":n",htmlspecialchars($_POST['nom']));
        $req->bindValue(":p",htmlspecialchars($_POST['prenom']));
        $req->bindValue(":m",htmlspecialchars($_POST['email']));
        $req->bindValue(":ms",htmlspecialchars($_POST['msg']));
        $req->execute();
    } catch (\Throwable $th) {
        //throw $th;
    }    
}
include 'index.phtml';
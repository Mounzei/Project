<?php

session_start();
// var_dump($_SESSION);


if(isset($_GET['search'])){
    $search = $_GET['search'];
    $lien = new PDO(
     'mysql:host=home.3wa.io;port=3307;dbname=sev-03_cissemounirou_connexion',
     'cissemounirou',
     'Phpmyadmin01*'
     );
    $lien->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $lien->exec('SET NAMES UTF8');
    // "Préparer" une requête
    $req = $lien->prepare(
        "SELECT 
            name,
            movie,
            nam
        FROM page"
    );
    
    // Executer la requête
    $req->execute();
    
    // Maintenant que la requête a été exécutée, réceptionner le résultat
    $pages = $req->fetchAll(PDO::FETCH_ASSOC);
    foreach($pages as $page){
        if($search == $page['name'] || $search == $page['movie'] || $search == $page['nam']){
            $mov = $page['movie'];
            header("Location: movies/page_type/movie.php?movie=$mov");
               exit();
        }
    }
    
};


// var_dump($_GET['msg']);
if(isset($_GET['user']) || isset($_GET['msg'])){
    if(isset($_GET['user']) == isset($_SESSION['pseudo'])){
        $template = 'main';
        include 'index.phtml';
    }else if($_GET['user'] != $_SESSION['pseudo']){
        header("Location: erreur.html");
        exit();
    }else if($_GET['msg'] === 'Acceuil'){
        $template = 'main';
        include 'index.phtml';
    }
}else{
        header("Location: erreur.html");
        exit();
    };





?>
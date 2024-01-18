<?php
session_start();
require "fonctions/co_bdd.php";
require "fonctions/fonctions.php";

if(isset($_POST['email'],$_POST['password'],$_POST['fonction'])){
    try {
        $id = substr($_POST['nom'],0,2).substr($_POST['prenom'],0,3).substr($_POST['tel'],-2);
        $hash = hashPassword($_POST['password']);
        $req = $lien->prepare(
            'INSERT INTO
                employes
                (
                id,
                nom,
                prenom,
                email,
                numero,
                password,
                fonction)
                VALUES 
                (
                ?, ?, ?, ?, ?, ?, ?)'
        );
        // Executer la requête
        $req->execute([$id, $_POST['nom'] ,$_POST['prenom'], $_POST['email'], $_POST['tel'], $hash, strtolower($_POST['fonction'])]);
        $erreurReg = false;
    } catch (\Throwable $th) {
        // throw $th;
        $erreurReg = true;
    }
}else if(isset($_POST['emailco'],$_POST['passwordco'])){
    try {
        $req = $lien->prepare(
            "SELECT * FROM employes where email = :em"
        );
        $req->bindValue("em",$_POST['emailco']);
        $req->execute();
        $users = $req->fetchAll(PDO::FETCH_ASSOC);
        foreach($users as $user){
            if($user === false ){
                   echo "Utilisateur inconnu";
                   $erreurLog = true;
               } else {
                   if(verifyPassword($_POST['passwordco'], $user['password']) === true ) {  
                        $_SESSION['id'] = $user['id'];
                        $_SESSION['nom'] = $user['nom'];
                        $_SESSION['prenom'] = $user['prenom'];
                        $_SESSION['email'] = $user['email'];      
                        $_SESSION['numere'] = $user['numero'];
                        $_SESSION['fonction'] = $user['fonction'];    
                        header('Location: accueil.php');         
                   }else{
                    $erreurLog = true;
                   }
               }
           };
    } catch (\Throwable $th) {
        // throw $th;
        $erreurLog = true;
    }
}
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <link rel="apple-touch-icon" sizes="180x180" href="/PROMETRE/img/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/PROMETRE/img/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/PROMETRE/img/favicon-16x16.png">
    <link rel="manifest" href="/PROMETRE/img/site.webmanifest">
    <link rel="shortcut icon" href="/PROMETRE/img/favicon.ico" type="image/x-icon">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/PROMETRE/css/style.css">
    <title>Bienvenue sur PROMETRE</title>
</head>
<?php if(!isset($_SESSION['id'])){ ?>
<body>
    <img src="/PROMETRE/img/logo.png" alt="Logo de prometre">
    <div id="cover">
        <form action="index.php" method="post">
            <h3>Se connecter</h3>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail1" name="emailco" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" name="passwordco" id="exampleInputPassword1">
            </div>
            <button type="submit" class="btn btn-primary">Connexion</button>
            <?php if(isset($erreurLog) && $erreurLog){?>
                <p>Votre email ou votre mot de passe est incorrecte.</p>
            <?php } ?>
        </form>
        <form action="index.php" method="post">
            <h3>S' enregistrer</h3>
            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom" name="nom">
            </div>
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom">
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Numéro de téléphone</label>
                <input type="tel" class="form-control" id="tel" name="tel">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="mb-3">
                <label for="fonction" class="form-label">Fonction dans l'entreprise</label>
                <input type="text" class="form-control" id="fonction" name="fonction">
            </div>
            <button type="submit" class="btn btn-primary">Enregistrement</button>
            <?php if(isset($erreurReg) && $erreurReg){?>
                <p>Vous avez deja un compte avec le même email</p>
            <?php }else if(isset($erreurProjet) && !$erreurReg){ ?>
                <p>Ajout effectué avec succés</p>
            <?php } ?>
        </form>
    </div>
</body>
<?php }else{ header('Location: accueil.php'); die();} ?>
</html>
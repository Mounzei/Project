<?php 
if(isset($_SESSION['id'])){
if (isset($_GET['deco']) && $_GET['deco'] === 'true') {
    session_destroy();
    header("Location: /PROMETRE/");
    die();
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
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link rel="stylesheet" href="/PROMETRE/css/normalize.css">
    <link rel="stylesheet" href="test.scss">
    <link rel="stylesheet" href="/PROMETRE/css/style.css">
    <title><?=$title?></title>
</head>
<body>
    <header>
        <div id="phone">
            <a href="/PROMETRE/accueil.php"><img src="/PROMETRE/img/logo.png" alt="Logo PROMETRE"></a>
        </div>
        <div id="pc">
            <a href="/PROMETRE/accueil.php"><img src="/PROMETRE/img/logo.png" alt="Logo PROMETRE"></a>
        </div>
        <div class="circles">
            <div class="circle"></div>
            <div class="circle"></div>
            
            <div class="circle-multiple">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
            </div>
        </div>
        <a href="javascript:history.go(-1)">Retour</a>
        <a href="?deco=true">Deconnexion</a>
    </header>
    <main>
        <div class="droite">
            <?php if(isset($_GET['numP'])){ ?>
                <div>Projet <?=$_GET['numP']?></div>
            <?php } ?>
            <?php if(isset($_GET['numT'])){ ?>       
                <div>Travail <?=$_GET['numT']?></div>
            <?php } ?>
        </div> 
        <?php require 'views/'.$template.'.php'; ?>
    </main>
    <footer>
        <p>Site vitre représentant de maniére générale le rendu final.  Vous pouvez contacter l'administrateur du site par mail : <a style="color:red;" href="mailto:mounirou.cisse@dfb.digital">mounirou.cisse@dfb.digital</a> </p>
    </footer>
</body>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
</html>
<?php }else{header('location: /PROMETRE/'); die();}?>
<?php 
if(isset($_SESSION['id'])){ 
ob_start();
?>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8"><link rel="apple-touch-icon" sizes="180x180" href="/PROMETRE/img/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/PROMETRE/img/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/PROMETRE/img/favicon-16x16.png">
    <link rel="manifest" href="/PROMETRE/img/site.webmanifest">
    <link rel="shortcut icon" href="/PROMETRE/img/favicon.ico" type="image/x-icon">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?=$title?></title>
</head>
<?php
require 'views/'.$template.'.php';
?>
</html>
<?php
$content = ob_get_clean();
include "vendor/mikehaertl/php-shellcommand/src/Command.php";
include "vendor/mikehaertl/php-tmpfile/src/File.php";
include "vendor/mikehaertl/phpwkhtmltopdf/src/Command.php";
include "vendor/mikehaertl/phpwkhtmltopdf/src/Image.php";
include "vendor/mikehaertl/phpwkhtmltopdf/src/Pdf.php";
// use mikehaertl\wkhtmlto\Pdf;
$PDF = new mikehaertl\wkhtmlto\Pdf($content);
// $PDF->saveAs('pdf/'.$title.'.pdf');
$PDF->send(); }else{header('location: /PROMETRE/'); die();} 
?>
<?php

$hostname = '';
$username = '';
$password = '';
$databasename = '';

// creation loien base de donnée

$pdo = new PDO(
    "mysql:host=$hostname;port=3306;dbname=$databasename",
    "$username",
    "$password"
);
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$pdo->exec('SET NAMES UTF8');

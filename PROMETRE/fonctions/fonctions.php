<?php

// Pour hacher un mot de passe aléatoirement.
function hashPassword($password) // permet de crypter le mot de passe 
{
    $salt = '$2y$11$'.substr(bin2hex(openssl_random_pseudo_bytes(32)), 0, 22);
        
    return crypt($password, $salt); 
};

// Pour vérifier le mot de passe hacher.
function verifyPassword($password, $hashedPassword)
{
    return crypt($password, $hashedPassword) == $hashedPassword;
}

// maj table travaux.
function majTravaux($pdo, $id, $id_projet, $nom, $table)
{
    try {
        $req = $pdo->prepare(
            'INSERT INTO
                travaux
                (
                id,
                id_projet,
                nom,
                tables)
                VALUES 
                (
                ?, ?, ?, ?)'
        );
        // Executer la requête
        $req->execute([$id,$id_projet,$nom,$table]);
    } catch (\Throwable $th) {
        // throw $th;
    }
}

// trouver table
function trouverTable($pdo,$s,$g)
{
    try {
        $req = $pdo->prepare(
            "SELECT tables FROM travaux where id_projet = :idP and id = :id"
        );
        $req->bindValue("idP", $s);
        $req->bindValue("id", $g);
        $req->execute();
        $table = $req->fetch();
    } catch (\Throwable $th) {
        // throw $th;
    }
    return $table;
}
?>
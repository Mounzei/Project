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

function recuperationArticle($article){
    $res = [];
    $res['nomArticle'] = $article['nom'];
    $res['prixArticle'] = $article['prix'];
    $res['descriptionArticle'] = $article['description'];
    $res['stock'] = $article['stock'];
    $res['imagesArticle'] = explode(',',$article['img']);
    return $res;
}


let compte = parseInt(prompt("Si vous voulez vous enregistrer ou si vous avez un compte taper 1 sinon taper 2 "));
let bv = "Bienvenue sur le site de streaming gratuit! ";
let what = "Votre réponse est incromprise.";
let body = document.body;

//co
if(compte !== 2 && compte === 1){
    let co = parseInt(prompt("Avez vous un compte? (oui = 1 ou non = 2) "));
    let yes = "Vous allez être dirigé vers la page de connexion.";
    let no = "Vous ne pourrez pas rentrer dans le site.Vous allez être dirigé vers la page de création de compte! ";
    
    
    if(co === 1){
        alert(yes);
        location.href="page_phtml/login.php";
    }else if(co === 2){
        alert(no);
        location.href="page_phtml/register.php";
    }else{
        alert(what);
        location.href="erreur.html";
    }
}else if(compte === 2){
    alert(bv);
    location.href="streaming.php?msg=Acceuil";
}else if(compte !== 1 || compte !== 2){
    alert(what);
    location.href="erreur.html";
}






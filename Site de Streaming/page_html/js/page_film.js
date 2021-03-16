
// tous les listener d'evenement
// let section = document.getElementsByClassName('film');
// let div = document.getElementsByClassName('info');

// function toggledisplay(){
//     if(div.style.display == "content" ){
//         section.style.display = "none"
//     }
// };


$('#send').on('click', onSearchMovie);

$('#send_btn').on('click', onSearchMovie);

$(document).on('click', '#list li', onClickListItem);

// document.toggledisplay();


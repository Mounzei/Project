const url_pict = 'https://image.tmdb.org/t/p/w300_and_h450_bestv2'


// je recupère dans la fonction de callback la réponse de l'api

function searchMoviesWithKeyword(response) {
    console.log(response);
    // gestion affichage de la liste
    
    let list = $('<ul>');
    
    for(let i = 0; i < response.results.length; i++) {
        let li = $('<li data-id='+response.results[i].id+'>');
        // pour jQuery pour récupérer le data index d'un element HTML
        // let id = $('li').data('id') // recupere le data-id
        // let id = li.dataset.id // recupère le data-id
        li.append(response.results[i].title);
        list.append(li);
    }
    // $('#list').html("<h2>Résultats de votre recherches</h2>")
    $('#list').html(list);
    $('#list').removeClass('hide');
    
}

function onClickShowDetail(res) {
    console.log(res);
     $('#result').html("<h2>"+res.title+"</h2>");
     $('#result').append('<img src="'+url_pict+res.backdrop_path+'"/>');
     $('#result').append('<p>'+res.overview+'</p>');
     $('#result').removeClass('hide');
}
const API_KEY = '2ee2c5b569240ea2a2a879dd9c8a822c';

function onSearchMovie(event) {
    event.preventDefault();
    
    $elem = $("section.film");
    $elem.removeClass("film").addClass("films");
    // je récupère le mot clef
    
    let keyword = $('#search').val();
    console.log(keyword);
    
    // je fais une requete ajax pour touver tous les film en fonction d'un mot clef
    // je concatene le mot clef dans l'api
    $.getJSON('https://api.themoviedb.org/3/search/movie?api_key='+API_KEY+'&query='+keyword, searchMoviesWithKeyword)

}

function onClickListItem(event) {
    let id = $(this).data('id');
    
    console.log(id);
    $.getJSON('https://api.themoviedb.org/3/movie/'+id+'?api_key='+API_KEY, onClickShowDetail)
}

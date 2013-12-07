// Once the api loads call enable the search box.
function handleAPILoaded() {
    $('#search-button').attr('disabled', false);
}

// Search for a given string.
function search() {
    var q = $('#query').val();
    var request = gapi.client.youtube.search.list({
    q: q,
    part: 'snippet'
    });

    request.execute(function(response) {
        var str = JSON.stringify(response.result);
        $('#search-container').html('<pre>' + str + '</pre>');

        var res = $.parseJSON(str);
        console.log(res.items);

        $('#listagem-busca-youtube').html('');
        for (i in res.items){
            if(res.items[i].id.kind == 'youtube#video') {
                var template = '<li data-video-id="'+res.items[i].id.videoId+'">'
                + '<a href="#" title=""><img src="'+res.items[i].snippet.thumbnails.medium.url+'" alt="" /></a>'
                + '<h1><a href="#">'+res.items[i].snippet.title+'</a></h1>'
                + '</li>';
                $('#listagem-busca-youtube').append(template);
            }
        }
    });
}

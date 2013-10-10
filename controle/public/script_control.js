var socket = io.connect("http://10.51.101.143:3000");

function addMessage(msg, pseudo) {
    // nada
}

function sentMessage() {
    if ($('#messageInput').val() != "")
    {
        socket.emit('message', $('#messageInput').val());
        checkCommand($('#messageInput').val(), "client");
        addMessage($('#messageInput').val(), "client", new Date().toISOString(), true);
        $('#messageInput').val('');
    }
}

// function setPseudo() {
//     if ($("#pseudoInput").val() != "")
//     {
//         socket.emit('setPseudo', $("#pseudoInput").val());
//         $('#chatControls').show();
//         $('#pseudoInput').hide();
//         $('#pseudoSet').hide();
//     }
// }

function checkCommand(msg, pseudo) {
    // executa apenas no server side
    if (pseudo != 'client') {
        if (msg == 'play') {
            playVideo();
        } else if(msg == 'stop') {
            stopVideo();
        }
    }
}

function playVideo() {
    // alert('Play Video');
}

function stopVideo() {
    // alert('Stop Video');
}

function checkServerStatus(server_status){
    console.log(server_status);
}


socket.on('message', function(data) {
    checkCommand(data['message'], data['pseudo']);
    addMessage(data['message'], data['pseudo']);
});


$(function() {

    socket.emit('setPseudo', 'cli');

    // $("#pseudoSet").click(function() {setPseudo()});
    $("#submit").click(function() {sentMessage();});

    $("#bt-play").toggle(
        function() {
            $('#messageInput').val('play');
            sentMessage();
        },
        function() {
            $('#messageInput').val('stop');
            sentMessage();
        }
    );

    $("#bt-stop").click(function() {
        $('#messageInput').val('stop');
        sentMessage();
    });

});

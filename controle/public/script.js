var socket = io.connect("http://10.51.101.143:3000");

function addMessage(msg, pseudo) {
	if (pseudo != 'client') {
		$("#chatEntries").append('<div class="message"><p>Comando solicitado: ' + msg + '</p></div>');
	}
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
// 	if ($("#pseudoInput").val() != "")
// 	{
// 		socket.emit('setPseudo', $("#pseudoInput").val());
// 		$('#chatControls').show();
// 		$('#pseudoInput').hide();
// 		$('#pseudoSet').hide();
// 	}
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
	$('.play a').click();
}

function stopVideo() {
	$('.pause a').click();
}

function checkServerStatus(server_status){
	console.log(server_status);
}


socket.on('message', function(data) {
	checkCommand(data['message'], data['pseudo']);
	addMessage(data['message'], data['pseudo']);
});


$(function() {
	socket.emit('setPseudo', 'server');

	$("#submit").click(function() {sentMessage();});

	$("#bt-play").click(function() {
		$('#messageInput').val('play');
		sentMessage();
	});

	$("#bt-stop").click(function() {
		$('#messageInput').val('stop');
		sentMessage();
	});

});
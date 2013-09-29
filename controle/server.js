var express = require('express')
	, http = require('http')
	, app = express()
	, jade = require('jade');

app.set('port', process.env.PORT || 3000);

var server = http.createServer(app)
	, io = require('socket.io').listen(server);

server.listen(app.get('port'));


app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.set("view options", { layout: false });
app.configure(function() {
	app.use(express.static(__dirname + '/public'));
});
app.get('/', function(req, res){
  res.render('home.jade');
});

app.get('/control', function(req, res){
  res.render('control.jade');
});

app.get('/player', function(req, res){
  res.render('player.jade');
});


// app.listen(3000);

var server_status = false; // server não iniciado
var server_key = '123456';

io.sockets.on('connection', function (socket) {

	socket.on('setPseudo', function (data) {

		if (server_status === false) {
			socket.set('pseudo', 'server');
			server_status = true;
		} else {
			socket.set('pseudo', 'me');
		}

		// socket.set('pseudo', data);
	});

	socket.on('message', function (message) {
		socket.get('pseudo', function (error, name) {

			// se quem estiver enviando não for o server
			// envia o comando
			if (name != 'server') {
				var data = { 'message' : message, pseudo : name };
				socket.broadcast.emit('message', data);
				console.log("user " + name + " send this : " + message);
			}

		})
	});
});


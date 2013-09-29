<div id="notice">
   <h3>${notice}</h3>
</div>

<h1>Nova Playlist</h1>
<form action="adiciona" method="post" accept-charset="utf-8">    
    <fieldset>
        <legend>Adicionar Playlist</legend>
        <label for="titulo">Título:</label>
        <input id="titulo" type="text" name="playlist.titulo"/>
		
		<label for="descricao">Descrição:</label>
        <input id="descricao" type="text" name="playlist.descricao"/>
        
        <label for="tags">Tags:</label>
        <input id="tags" type="text" name="playlist.tags"/>
        
        <label for="videoInicial">Vídeo Inicial:</label>
        <input id="videoInicial" type="text" name="playlist.videoInicial"/>
		
		<button type="submit">Salvar</button>
	</fieldset>
</form>
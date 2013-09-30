<form action="altera">
    <fieldset>
        <legend>Editar Playlist</legend>
        <input type="hidden" name="playlist.id"
            value="${playlist.id }" />
        <label for="nome">Título:</label>
        <input id="nome" type="text"
            name="playlist.titulo" value="${playlist.titulo }"/>
            
        <label for="descricao">Descrição:</label>
        <input id="descricao" type="text"
            name="playlist.descricao" value="${playlist.descricao }"/>
 
        <label for="tags">Tags:</label>
        <input id="tags" type="text"
            name="playlist.tags" value="${playlist.tags }"/>
 
        <label for="videoInicial">Vídeo Inicial:</label>
        <input id="videoInicial" type="text"
            name="playlist.videoInicial" value="${playlist.videoInicial }"/>
            
        <button type="submit">Salvar</button>
    </fieldset>
</form>
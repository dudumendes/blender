<form action="altera">
    <fieldset>
        <legend>Editar Categoria</legend>
        <input type="hidden" name="categoria.id"
            value="${categoria.id }" />
        <label for="nome">Título:</label>
        <input id="nome" type="text"
            name="categoria.titulo" value="${categoria.titulo }"/>
            
        <button type="submit">Salvar</button>
    </fieldset>
</form>
<form action="altera">
    <fieldset>
        <legend>Editar Usuário</legend>
        <input type="hidden" name="usuario.id"
            value="${usuario.id }" />
        <label for="nome">Nome:</label>
        <input id="nome" type="text"
            name="usuario.nome" value="${usuario.nome }"/>
            
        <label for="email">Email:</label>
        <input id="email" type="text"
            name="usuario.email" value="${usuario.email }"/>
            
        <label for="login">Login:</label>
        <input id="login" type="text"
            name="usuario.login" value="${usuario.login }"/>
            
        <label for="senha">Senha:</label>
        <input id="senha" type="password"
            name="usuario.senha" value=""/>
            
        <button type="submit">Salvar</button>
    </fieldset>
</form>
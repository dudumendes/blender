<div id="notice">
   <h3>${notice}</h3>
</div>

<h1>Novo Usuário</h1>
<form action="adiciona" method="post" accept-charset="utf-8">    
    <fieldset>
        <legend>Adicionar Usuário</legend>
        <label for="nome">Nome:</label>
        <input id="nome" type="text" name="usuario.nome"/>
		
		<label for="email">Email:</label>
        <input id="email" type="text" name="usuario.email"/>
        
        <label for="login">Login:</label>
        <input id="login" type="text" name="usuario.login"/>
        
        <label for="senha">Senha:</label>
        <input id="senha" type="password" name="usuario.senha"/>
		
		<button type="submit">Salvar</button>
	</fieldset>
</form>
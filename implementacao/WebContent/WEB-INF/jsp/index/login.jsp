<body class="home page page-id-3232 page-template page-template-template-portfolio-php single-author sidebar-active viewing-portfolio-grid">
	<div id="box-add-video" class="one-edge-shadow usuariosForm" style="display: inline;">
		<form action="<c:url value="/usuarios/adiciona"/>" id="form-add-video" method="post" accept-charset="utf-8" enctype="multipart/form-data"> 

			<div style="float: left; width: 235px;">
				<label for="nome">Nome:</label>
	        	<input id="nome" type="text" name="usuario.nome" required="required" value="${usuario.nome }"/>
			
				<label for="email">E-mail:</label>
	        	<input id="email" type="text" name="usuario.email" required="required" value="${usuario.email }"/>

			</div>

			<div style="float: right; width: 235px; margin-left: 50px;">
				<label for="senha">Senha:</label>
	        	<input id="senha" type="password" name="usuario.senha" required="required" />
	               
	        	<label for="confirmacao">Confirmar Senha:</label>
	        	<input id="confirmacao" type="password" equalTo="#senha"/>
	        </div>
	        
	        <div style="clear: both;"></div>
	        
	        <div style="float: left; width: 235px;">
				<label for="usuario">Usuário:</label>
	        	<input id="usuario" type="text" name="usuario.usuario" required="required" value="${usuario.usuario }"/>
			
				<input type="submit" value="Salvar"/>

			</div>

		</form>
	</div>
	
	
	
<form action="<c:url value="/login_validar"/>" method="POST">
  <fieldset>
    <legend>Efetue o login</legend>
        
    <label for="usuario">Login:</label>
      <input id="usuario" type="text" name="usuario.usuario"/>

    <label for="senha">Senha:</label>
      <input id="senha" type="password" name="usuario.senha"/>

    <button type="submit">Login</button>
  </fieldset>
</form>
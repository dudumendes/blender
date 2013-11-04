<body class="login page page-id-3232 page-template page-template-template-portfolio-php single-author sidebar-active viewing-portfolio-grid">
	<div id="box-cadastro" class="one-edge-shadow tranparente95" style="display: inline;">
		<form action="<c:url value="/usuarios/adiciona"/>" id="usuariosForm" method="post" accept-charset="utf-8" enctype="multipart/form-data"> 

			<div style="float: left; width: 235px;">
				<label for="nome">Nome:</label>
	        	<input id="nome" type="text" name="usuario.nome" value="${usuario.nome }"/>
			
				<label for="email">E-mail:</label>
	        	<input id="email" type="text" name="usuario.email" value="${usuario.email }"/>

			</div>

			<div style="float: right; width: 235px; margin-left: 50px;">
				<label for="senha">Senha:</label>
	        	<input id="senha" type="password" name="usuario.senha" />
	               
	        	<label for="confirmacao">Confirmar Senha:</label>
	        	<input id="confirmacao" type="password"/>
	        </div>
	        
	        <div style="clear: both;"></div>
	        
	        <div style="float: left; width: 235px;">
				<label for="usuario">Usuário:</label>
	        	<input id="usuario" type="text" name="usuario.usuario" value="${usuario.usuario }"/>
			
				<input type="submit" value="Salvar"/>

			</div>

		</form>
	</div>
	
	
	
	
	<div id="box-login" class="one-edge-shadow tranparente95">
		<c:forEach var="error" items="${errors}">
    		<span class="error-login">${error.message}</span>
		</c:forEach>
		
		
		<form action="<c:url value="/login_validar"/>" method="post" accept-charset="utf-8"> 

			<div style="float: left; width: 235px;">
				<label for="usuario">Usuário:</label>
	        	<input id="usuario" type="text" name="usuario.usuario" value=""/>
			
				<label for="senha">Senha:</label>
	        	<input id="senha" type="text" name="usuario.senha" value=""/>

			</div>
	        
	        <div style="clear: both;"></div>
	        
	        <div style="float: right;">
				<input type="submit" value="Entrar"/>
			</div>

		</form>
	</div>
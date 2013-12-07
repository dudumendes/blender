<%@page contentType="text/html; charset=UTF-8" %>  
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="pt-br"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="pt-br"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="pt-br"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="pt-br"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable"> -->
    <meta name="author" content="Blendder" />
    <meta name="robots" content="index, follow" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <title>Blendder</title>
    <link rel="apple-touch-icon-precomposed" href="thumbnail.png" />
    <link rel="shortcut icon" href="favicon.png" />

    <link href="css/login.css" media="all" type="text/css" rel="stylesheet" />

    <style>
    #form_cadastro label.error, #form_login label.error{
    	padding: 4px;
    	font:normal 11px Arial, Helvetica, sans-serif;
    	color:#E2A6A6 !important;
    }
    #form_cadastro span.error, #form_login span.error{
    	padding: 4px;
    	font:normal 11px Arial, Helvetica, sans-serif;
    	color:#E2A6A6 !important;
    }
    #form_cadastro input.error, #form_login input.error{
    	border: 1px #E2A6A6 dashed;
    }

    </style>

</head>
<body id="login">
    
<h1 id="site-title"><img src="images/logo.png" width="81" height="77" alt="Blender 128">Blendder</h1>

<div id="login-box">
    <form action="<c:url value="/login_validar"/>" name="form_login" id="form_login" method="post" accept-charset="utf-8">
        
        <label for="login">Usuário</label><input type="text" name="usuario.usuario" value="" id="login" />
        <label for="senha">Senha</label><input type="password" name="usuario.senha" value="" id="senha" />
        
        
        <p><input type="submit" value="Entrar"></p>
    </form>
    
    <a href="#" id="bt-cadastrar" title="Cadastre-se gratuitamente">Cadastre-se gratuitamente!</a>
</div>


<div id="cadastro-box">
    <form action="<c:url value="/usuarios/adiciona"/>" id="form_cadastro" name="form_cadastro"  method="post" accept-charset="utf-8">
        
        <c:forEach var="error" items="${errors}">
            <span class="error-login">${error.message}</span>
		</c:forEach>
        
        <label for="nome">Nome</label><input type="text" class="field-login" name="usuario.nome" value="" id="nome" />
        <label for="email">E-mail</label><input type="text" name="usuario.email" value="" id="email" />
        <label for="login">Nome de Usuário</label><input type="text" name="usuario.usuario" value="" id="login" />
        <label for="senha">Senha</label><input type="password" name="usuario.senha" value="" id="senha" />
        <label for="confirmacao">Repita a Senha</label><input type="password" name="confirmacao" value="" id="confirmacao" />
        
        
        <p><input type="submit" value="Cadastrar" /></p>
    </form>
    
    <a href="#" id="bt-login" title="Já sou cadastrado!">Já sou cadastrado!</a>
    <br /><br /><br /><br /><br /><br /><br /><br />
</div>

    <script src="js/jquery/2.0.3/jquery-2.0.3.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/additional-methods.min.js" type="text/javascript" charset="utf-8"></script>
    
    

    <script type="text/javascript">
    var wf_pbb_object = [
    {bc:"rgb(255, 255, 255)"},
    {img:"images/bg-new.jpg", mm:true, ms:true, mms:1, mss:1, mmd:1, mso:"v", msd:1, im:"pattern", pr:"both", mma:"both", ofs:{x:0, y:0}, zi:1, sr:false, sb:false, isr:false, isb:false}
    ];
    </script>
    <script src="js/wf.pbb.js" type="text/javascript" charset="utf-8"></script>
    
    
    <script type="text/javascript" charset="utf-8">
        jQuery(function($){
            $('#bt-login').click(function(){
                $('#login-box').show(1, function(){
                    $('#cadastro-box').animate({ "left": "-=100%" }, "slow" );
                    $('#login-box').animate({ "left": "-=50%" }, "slow" );
                });
            });
            
            
            $('#bt-cadastrar').click(function(){
                $('#cadastro-box').show(1, function(){
                    $('#login-box').animate({ "left": "+=100%" }, "slow", function(){ $('#login-box').hide(); $('#login-box').animate({ "left": "-=50%" }, "slow"); });
                    $('#cadastro-box').animate({ "left": "+=100%" }, "slow" );
                });
            });
            
            
			$("#form_cadastro").validate({
				rules: {
					nome:{required: true},
					email:{required: true,email:true},
					login:{required: true},
					senha: {
        				required: true,
        				minlength: 3
        			},
        			confirmacao: {
        				required: true,
        				minlength: 3,
        				equalTo: "#senha"
        			},
				},

				messages: {
					nome: {required: "Precisamos saber o seu nome!"},
					email: "Seu e-mail é fundamental para utilizar nosso aplicativo!",
					login: "Informe também um nome de usuário!",
					senha: {
        				required: "É necessário que você informe uma senha!",
        				minlength: "Sua senha deve ter no mínimo 3 caracteres."
        			},
        			confirmacao: {
        				required: "É necessário que você informe uma senha!",
        				minlength: "Sua senha deve ter no mínimo 3 caracteres.",
        				equalTo: "Parece que as senhas que você informou não são iguais!"
        			},
				}

			});
			
			
			
			$("#form_login").validate({
				rules: {
					login:{required: true},
					senha: {
        				required: true
        			}
				},

				messages: {
					login: "Informe um nome de usuário!",
					senha: {
        				required: "Senha inválida!",
        			}
				}

			});
        });
    </script>
    

</body>
</html>

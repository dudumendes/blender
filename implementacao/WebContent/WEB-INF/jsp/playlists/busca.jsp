<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	


	<li><form action="buscaPlaylist">
			<input id="busca" name="nome" />
			
			<button type="buscar">Buscar</button></b></b>
		</form>
		
	<h3>
		Resultados da busca pelo nome  <b>"${nome }"</b>
	</h3>
	<%@ include file="lista.jsp"%>
</body>
</html>
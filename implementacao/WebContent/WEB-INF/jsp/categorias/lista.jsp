<select name="categoria_id" id="categorias">
	<c:forEach items="${categorias}" var="categoria">
		<option value="${categoria.id}">${categoria.titulo}</option>	
	</c:forEach>			
</select>	
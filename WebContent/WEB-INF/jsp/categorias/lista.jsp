<table>
    <thead>
        <tr>
        	<th>Título</th>
            <th>&nbsp;</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categoriaList}" var="categoria">
            <tr>
                <td>${categoria.titulo }</td>
                <td><a href="edita?id=${categoria.id }">Editar</a> | <a href="remove?id=${categoria.id }">Remover</a> </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
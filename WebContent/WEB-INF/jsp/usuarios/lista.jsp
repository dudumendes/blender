<table>
    <thead>
        <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>Login</th>
            <th>&nbsp;</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${usuarioList}" var="usuario">
            <tr>
                <td>${usuario.nome }</td>
                <td>${usuario.email }</td>
                <td>${usuario.login }</td>
                <td><a href="edita?id=${usuario.id }">Editar</a> | <a href="remove?id=${usuario.id }">Remover</a> </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
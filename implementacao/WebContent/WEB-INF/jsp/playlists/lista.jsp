<table>
    <thead>
        <tr>
        	<th>T�tulo</th>
            <th>Descri��o</th>
            <th>Tags</th>
            <th>V�deo Inicial</th>
            <th>&nbsp;</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${playlistList}" var="playlist">
            <tr>
                <td>${playlist.titulo }</td>
                <td>${playlist.descricao }</td>
                <td>${playlist.tags }</td>
                <td>${playlist.videoInicial }</td>
                <td><a href="edita?id=${playlist.id }">Editar</a> | <a href="remove?id=${playlist.id }">Remover</a> </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
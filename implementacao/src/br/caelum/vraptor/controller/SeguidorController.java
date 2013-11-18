package br.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.dao.PlaylistDao;
import br.com.caelum.vraptor.dao.SeguidorDao;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.models.Playlist;
import br.com.caelum.vraptor.models.Usuario;

public class SeguidorController {

	private final SeguidorDao dao;

	public SeguidorController(SeguidorDao dao) {
		this.dao = dao;

	}

	public List<Usuario> lista() {
		return dao.exibirUsuario();
	}

}

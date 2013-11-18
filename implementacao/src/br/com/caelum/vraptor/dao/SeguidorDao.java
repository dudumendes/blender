package br.com.caelum.vraptor.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.infra.CriadorDeSession;
import br.com.caelum.vraptor.models.Playlist;
import br.com.caelum.vraptor.models.Usuario;

public class SeguidorDao {

	private final Session session;

	public SeguidorDao() {
		this.session = CriadorDeSession.getSession();
	}

	public List<Usuario> exibirUsuario() {
		return this.session.createCriteria(Usuario.class).list();
	}

}

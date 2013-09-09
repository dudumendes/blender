package br.com.caelum.vraptor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.infra.CriadorDeSession;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.models.Playlist;

@Component
public class PlaylistDao {

	private final Session session;

	public PlaylistDao() {
		this.session = CriadorDeSession.getSession();
	}

	public void salva(Playlist playlist) {
		Transaction tx = session.beginTransaction();
		session.save(playlist);
		tx.commit();
	}

	public List<Playlist> listaTudo() {
        return this.session.createCriteria(Playlist.class).list();
	}

	public Playlist carrega(Long id) {
	     return (Playlist) this.session.load(Playlist.class, id);
	}
	
	public void atualiza(Playlist playlist) {
	     Transaction tx = session.beginTransaction();
	     this.session.update(playlist);
	     tx.commit();
	}
	
	public void remove(Playlist playlist) {
	       Transaction tx = session.beginTransaction();
	       this.session.delete(playlist);
	       tx.commit();
	}
}

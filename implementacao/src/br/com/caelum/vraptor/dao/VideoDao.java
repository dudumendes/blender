package br.com.caelum.vraptor.dao;


import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.infra.CriadorDeSession;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.models.Playlist;
import br.com.caelum.vraptor.models.Video;

@Component
public class VideoDao {

	private final Session session;

	public VideoDao() {
		this.session = CriadorDeSession.getSession();
	}

	public void salva(Video video) {
		Transaction tx = session.beginTransaction();
		session.save(video);
		tx.commit();
	}

	public List<Playlist> listaTudo() {
        return this.session.createCriteria(Video.class).list();
	}

	public Video carrega(Long id) {
	     return (Video) this.session.load(Video.class, id);
	}
	
	public void atualiza(Video video) {
	     Transaction tx = session.beginTransaction();
	     this.session.update(video);
	     tx.commit();
	}
	
	public void remove(Video video) {
	       Transaction tx = session.beginTransaction();
	       this.session.delete(video);
	       tx.commit();
	}
}

package br.com.caelum.vraptor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.infra.CriadorDeSession;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.models.Categoria;
import br.com.caelum.vraptor.models.Playlist;

@Component
public class CategoriaDao {

	private final Session session;

	public CategoriaDao() {
		this.session = CriadorDeSession.getSession();
	}

	public void salva(Categoria categoria) {
		Transaction tx = session.beginTransaction();
		session.save(categoria);
		tx.commit();
	}

	public List<Categoria> listaTudo() {
        return this.session.createCriteria(Categoria.class).list();
	}

	public Categoria carrega(Long id) {
	     return (Categoria) this.session.load(Categoria.class, id);
	}

	
	public List<Categoria> listaPorUsuario(long UsuarioId) {  
		List<Categoria> categorias = (List<Categoria>)session.createQuery( "from Categoria where usuario_id=:usuario_id" )
                .setLong( "usuario_id",UsuarioId)
                .list();
		System.out.println(categorias);
		
		return categorias; 
		
		      
	}  
	
	public void atualiza(Categoria categoria) {
	     Transaction tx = session.beginTransaction();
	     this.session.update(categoria);
	     tx.commit();
	}

	public void remove(Categoria categoria) {
	       Transaction tx = session.beginTransaction();
	       this.session.delete(categoria);
	       tx.commit();
	}
}

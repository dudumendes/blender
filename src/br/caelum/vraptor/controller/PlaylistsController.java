package br.caelum.vraptor.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.PlaylistDao;
import br.com.caelum.vraptor.infra.CriadorDeSession;
import br.com.caelum.vraptor.models.Playlist;

@Resource
public class PlaylistsController {

	private final PlaylistDao dao;
	private final Result result;

    public PlaylistsController(PlaylistDao dao, Result result) {
        this.dao = dao;
        this.result = result;
    }

    public void adiciona(Playlist playlist) {
        dao.salva(playlist);

        result.include("notice", "Playlist criada com sucesso!");
        result.redirectTo(this).lista();
    }

    public void formulario(){
    	
    }
 
    public Playlist edita(Long id){
    	return dao.carrega(id);
    }
    
    public void altera(Playlist playlist) {
        dao.atualiza(playlist);
        result.include("notice", "Playlist alterada com sucesso!");
        result.redirectTo(this).lista();
    }
    
    public void remove(Long id) {
        Playlist playlist = dao.carrega(id);
        dao.remove(playlist);
        
        result.include("notice", "Playlist removida com sucesso!");
        result.redirectTo(this).lista();
    }
 
	public List<Playlist> lista() {
		return dao.listaTudo();
	}
}

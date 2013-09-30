package br.caelum.vraptor.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.infra.CriadorDeSession;
import br.com.caelum.vraptor.models.Usuario;

@Resource
public class UsuariosController {

	private final UsuarioDao dao;
	private final Result result;
	
    public UsuariosController(UsuarioDao dao, Result result) {
        this.dao = dao;
        this.result = result;
    }

    public void adiciona(Usuario usuario) {
        dao.salva(usuario);

        result.include("notice", "Usuário criado com sucesso!");
        result.redirectTo(this).lista(); // Ou UsuariosController.class
    }
    
    public void formulario(){
    	
    }
 
    public Usuario edita(Long id){
    	return dao.carrega(id);
    }
    
    public void altera(Usuario usuario) {
        dao.atualiza(usuario);
        result.include("notice", "Usuário alterado com sucesso!");
        result.redirectTo(this).lista();
    }
    
    public void remove(Long id) {
        Usuario usuario = dao.carrega(id);
        dao.remove(usuario);
        
        result.include("notice", "Usuário removido com sucesso!");
        result.redirectTo(this).lista();
    }
 
	public List<Usuario> lista() {
		return dao.listaTudo();
	}
}

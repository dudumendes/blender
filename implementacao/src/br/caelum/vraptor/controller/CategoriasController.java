package br.caelum.vraptor.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.CategoriaDao;
import br.com.caelum.vraptor.infra.CriadorDeSession;
import br.com.caelum.vraptor.models.Categoria;

import static br.com.caelum.vraptor.view.Results.*;

@Resource
public class CategoriasController {

	private final CategoriaDao dao;
	private final Result result;

    public CategoriasController(CategoriaDao dao, Result result) {
        this.dao = dao;
        this.result = result;
    }

    public void adiciona(Categoria categoria) {
        dao.salva(categoria);
       
       // result.include("notice", "Categoria criada com sucesso!");
        
        //result.include("categorias", cd.listaTudo());
        
        
        CategoriaDao cd = new CategoriaDao();
        
        
        List<Categoria> categorias = cd.listaTudo();
        
        result.use(json()).from(categorias, "categorias").serialize();
        
        
       
        
        //result.redirectTo(this).lista();
        
        //result.include("notice", "Categoria criada com sucesso!");
        //result.include("categoria_id", categoria.getId());
    }

    public void formulario(){
    	
    }

    public Categoria edita(Long id){
    	return dao.carrega(id);
    }

    public void altera(Categoria categoria) {
        dao.atualiza(categoria);
        result.include("notice", "Categoria alterada com sucesso!");
        result.redirectTo(this).lista();
    }

    public void remove(Long id) {
        Categoria categoria = dao.carrega(id);
        dao.remove(categoria);
        
        result.include("notice", "Categoria removida com sucesso!");
        result.redirectTo(this).lista();
    }

	public List<Categoria> lista() {
		return dao.listaTudo();
	}
}
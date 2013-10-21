package br.caelum.vraptor.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.sun.jmx.snmp.Timestamp;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.blank.IndexController;
import br.com.caelum.vraptor.dao.PlaylistDao;
import br.com.caelum.vraptor.infra.Arquivo;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.models.Playlist;

@Resource
public class PlaylistsController {

	private final PlaylistDao dao;
	private final Result result;
	private final ServletContext context;
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	
	private static final String PATH_FOTO = System.getProperty("user.home") + "/img";

    public PlaylistsController(PlaylistDao dao, Result result, final ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.dao = dao;
        this.result = result;
        this.context = context;
        this.request = request;
        this.response = response;
    }

    public void adiciona(Playlist playlist, UploadedFile foto) {
    	
    	Arquivo arquivoCapa = new Arquivo(foto, "playlists");
    	arquivoCapa.salvaArquivo();
    	
    	playlist.setImagemCapa(foto.getFileName());
    	
        dao.salva(playlist);
        
        result.include("notice", "Playlist criada com sucesso!");
        //result.redirectTo(this).lista();
        result.redirectTo(IndexController.class).index();
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

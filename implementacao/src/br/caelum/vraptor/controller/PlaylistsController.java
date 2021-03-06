package br.caelum.vraptor.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.sun.jmx.snmp.Timestamp;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.blank.IndexController;
import br.com.caelum.vraptor.dao.CategoriaDao;
import br.com.caelum.vraptor.dao.PlaylistDao;
import br.com.caelum.vraptor.dao.UsuarioWeb;
import br.com.caelum.vraptor.dao.VideoDao;
import br.com.caelum.vraptor.infra.Arquivo;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.models.Categoria;
import br.com.caelum.vraptor.models.Playlist;
import br.com.caelum.vraptor.models.Usuario;
import br.com.caelum.vraptor.models.Video;
import br.com.caelum.vraptor.view.Results;
import br.com.caelum.vraptor.view.Status;

@Resource
public class PlaylistsController {

	private final PlaylistDao dao;
	private final Result result;
	private final ServletContext context;
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	
	private final UsuarioWeb usuarioWeb;
	

    public PlaylistsController(PlaylistDao dao, Result result, final ServletContext context, HttpServletRequest request, HttpServletResponse response,  UsuarioWeb usuarioWeb) {
        this.dao = dao;
        this.result = result;
        this.context = context;
        this.request = request;
        this.response = response;
        this.usuarioWeb = usuarioWeb;
    }

    public void adiciona(Playlist playlist, UploadedFile foto, long categoria_id) {
    	
    	Categoria categoria = new Categoria();
		categoria.setId(categoria_id);
		
		playlist.setCategoria(categoria);
    	
    	
		Timestamp timestampObj = new Timestamp();
		long timeStamp = timestampObj.getDateTime();
		
    	Arquivo arquivoCapa = new Arquivo(foto, "playlists", timeStamp);
    	arquivoCapa.salvaArquivo();
    	
    	playlist.setImagemCapa(timeStamp + foto.getFileName());
    	
    	Usuario usuario = new Usuario();
    	usuario.setId(this.usuarioWeb.getId());
    	
    	playlist.setUsuario(usuario);
    
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
	
	//busca
	
	public void busca(){}
	
	public List<Playlist> buscaPlaylist(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
		  //result.redirectTo(PlaylistsController.class).busca();
	}

	
	@Path("/playlists/listajson/{playlistId}")
	public void listajson(long playlistId){
		Status resultStatus = result.use(Results.status());
        resultStatus.header("Access-Control-Allow-Origin", "*");
		
		
		VideoDao vd = new VideoDao();

        List<Video> videos = vd.listaPorPlaylist(playlistId);
        
        result.use(json()).from(videos, "videos").serialize();
	}
	
}

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
import br.com.caelum.vraptor.dao.VideoDao;
import br.com.caelum.vraptor.infra.Arquivo;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.models.Playlist;
import br.com.caelum.vraptor.models.Video;

@Resource
public class VideosController {

	private final VideoDao dao;
	private final Result result;
	private final ServletContext context;
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	

    public VideosController(VideoDao dao, Result result, final ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.dao = dao;
        this.result = result;
        this.context = context;
        this.request = request;
        this.response = response;
    }

    public void adiciona(Video video, UploadedFile imagem, UploadedFile arquivo) {
		Timestamp timestampObj = new Timestamp();
		long timeStamp = timestampObj.getDateTime();
		
    	Arquivo imagemVideo = new Arquivo(imagem, "playlists", timeStamp);
    	imagemVideo.salvaArquivo();
    	
    	Arquivo arquivoVideo = new Arquivo(arquivo, "playlists", timeStamp);
    	arquivoVideo.salvaArquivo();
    	
    	video.setImagemVideo(timeStamp + imagem.getFileName());
    	video.setArquivo(timeStamp + arquivo.getFileName());
    	
        dao.salva(video);
        
        result.include("notice", "Video adicionado com sucesso!");
        //result.redirectTo(this).lista();
        result.redirectTo(IndexController.class).index();
    }

    public void remove(Long id) {
        Video video = dao.carrega(id);
        dao.remove(video);
        
        result.include("notice", "Video removido com sucesso!");
        result.redirectTo(IndexController.class).index();
    }
 
	/* public List<Playlist> lista() {*/
		/*return dao.listaTudo();*/
/*	}*/
}

package br.com.caelum.vraptor.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Video {

	
	@Id @GeneratedValue 
	private Long id;
	private String url;
	private String titulo;
	private String duracaoSec;
	private String tag;
	private String ordem;
	private Date dataAdicao;
	private String imagemVideo;
	private String totalPositivos;
	private String totalNegativos;
	
	@ManyToOne
	private Playlist playlist;
	
	
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getduracaoSec() {
		return duracaoSec;
	}
	
	public void setduracaoSec(String duracaoSec) {
		this.duracaoSec = duracaoSec;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getOrdem() {
		return ordem;
	}
	
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
	public Date getDataAdicao() {
		return dataAdicao;
	}
	
	public void setDataAdicao(Date dataAdicao) {
		this.dataAdicao = dataAdicao;
	}
	
	public String getImagemVideo() {
		return imagemVideo;
	}
	
	public void setImagemVideo(String imagemVideo) {
		this.imagemVideo = imagemVideo;
	}
	
	public String getTotalPositivos() {
		return totalPositivos;
	}
	
	public void setTotalPositivos(String totalPositivos) {
		this.totalPositivos = totalPositivos;
	}
	
	public String getTotalNegativos() {
		return totalNegativos;
	}
	
	public void setTotalNegativos(String totalNegativos) {
		this.totalNegativos = totalNegativos;
	}

	public Playlist getPlaylist() {
		return playlist;
	}
	
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
}
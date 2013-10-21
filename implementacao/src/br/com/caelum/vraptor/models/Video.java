package br.com.caelum.vraptor.models;

import java.util.Date;

import br.com.caelum.vraptor.infra.Arquivo;

public class Video {

	private String url;
	private String titulo;
	private String arquivo;
	private String tag;
	private String ordem;
	private Date dataAdicao;
	private String imagemVideo;
	private String totalPositivos;
	private String totalNegativos;
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
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
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
	
	
}

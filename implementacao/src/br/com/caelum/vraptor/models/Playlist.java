package br.com.caelum.vraptor.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Playlist {

	@Id @GeneratedValue
	private Long id;
	private String descricao;
	private String titulo;
	private String tags;
	private String imagemCapa;
	private int videoInicial;	
	
	@OneToMany(mappedBy="playlist")
    private Set<Video> videos;

	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Categoria categoria;


	
	public String getImagemCapa() {
		return imagemCapa;
	}

	public void setImagemCapa(String imagemCapa) {
		this.imagemCapa = imagemCapa;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getVideoInicial() {
		return videoInicial;
	}

	public void setVideoInicial(int videoInicial) {
		this.videoInicial = videoInicial;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/*
	 * Retorna os vídeos
	 */

}
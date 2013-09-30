package br.com.caelum.vraptor.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Playlist {

	@Id @GeneratedValue
	private Long id;
	private String descricao;
	private String titulo;
	private String tags;
	private int videoInicial;
	
	
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
	
}

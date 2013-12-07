package br.com.caelum.vraptor.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id @GeneratedValue
	private Long id;
	private String titulo;
	
	@OneToMany(mappedBy="categoria")
    private Set<Playlist> playlists;

	@ManyToOne
	private Usuario usuario;
	

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/*
	 * Retorna as Playlists
	 */


}

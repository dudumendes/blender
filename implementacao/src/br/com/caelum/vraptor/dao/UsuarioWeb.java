package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.caelum.vraptor.models.Usuario;

@Component
@SessionScoped
public class UsuarioWeb {

  private Usuario logado;

  public void login(Usuario usuario) {
    this.logado = usuario;
  }
  
  public String getNome() {
    return logado.getNome();
  }
  
  public long getId() {
	return logado.getId();
  }
  
  public boolean isLogado() {
    return logado != null;
  }
  
  public void logout() {
    this.logado = null;
  }
  
}
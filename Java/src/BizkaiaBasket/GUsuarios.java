package BizkaiaBasket;

public class GUsuarios {
	String usuario, password;
	
	public GUsuarios() {
		this.usuario = "";
		this.password = "";
	}
	
	public GUsuarios(String u, String p) {
		this.usuario = u;
		this.password = p;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

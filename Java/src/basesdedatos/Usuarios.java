package basesdedatos;

public class Usuarios implements Comparable<Usuarios> {

	// Necesidades previas
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	private Integer telefono;
	private String email;
	private String tipo;
	
	// Constructor por defecto
	public Usuarios(){
		this.username = "";
		this.password = "";
		this.nombre = "";
		this.apellidos = "";
		this.telefono = 0;
		this.email = "";
		this.tipo = "";
	}
	// Constructor personalizado
	public Usuarios(String u, String p, String n, String a, Integer t, String e, String ti) {
		this.username = u;
		this.password = p;
		this.nombre = n;
		this.apellidos = a;
		this.telefono = t;
		this.email = e;
		this.tipo = ti;
	}
	// Constructor copia
	public Usuarios(Usuarios u) {
		this.username = u.username;
		this.password = u.password;
		this.nombre = u.nombre;
		this.apellidos = u.apellidos;
		this.telefono = u.telefono;
		this.email = u.email;
		this.tipo = u.tipo;
	}
	
	// Getters and Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	// Constructor con el compareTo
	public int compareTo(Usuarios other) {
		return (this.username.compareTo(other.username));
	}
	
	// toString
	@Override
	public String toString() {
		return (this.username+" / "+this.password+" / "+this.nombre+" / "+this.apellidos+" / "+this.telefono+" / "+this.email+" / "+this.tipo);
	}
	
	
}

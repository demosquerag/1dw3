package proyect1;


public class Users {
	
	private String user;
	private String password;
	
	// Constructor por defecto publico
	public Users() {
		this.user = "";
		this.password = "";
	}
	
	// Constructor copia del pordefecto
	public Users (Users u ) {
		this.user = u.user;
		this.password = u.password;
	}

	// Getters and setters
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Hascode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Users other = (Users) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	// Constructor con el compareTo
	public int compareTo(Users other) {
		
		if (this.user.equals(other.user) && this.password.equals(other.password)) {
			return -1;
		}
		else {
			return 1;
		}
				
	}
	
	// toString
	@Override
	public String toString() {
		return ("Usuario: "+this.user+" Password: "+this.password);
	}
	
	
}

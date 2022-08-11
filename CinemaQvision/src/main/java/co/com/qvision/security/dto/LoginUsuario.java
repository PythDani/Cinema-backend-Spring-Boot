<<<<<<< HEAD
package co.com.qvision.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginUsuario {
	
	
	@Email
	private String correo;
	@NotBlank
	private String password;
	
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	


}
=======
package co.com.qvision.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginUsuario {
	
	
	@Email
	private String correo;
	@NotBlank
	private String password;
	
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	


}
>>>>>>> c279d74573521fb1c19c0445369c524062666945

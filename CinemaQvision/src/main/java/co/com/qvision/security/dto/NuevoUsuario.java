package co.com.qvision.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import co.com.qvision.security.enums.TipoDocumentoNombre;





public class NuevoUsuario {

	@NotBlank
	private String documento;
	@NotBlank
	private String nombres;
	@NotBlank
	private String apellidos;
	@Email
	private String correo;
	@NotBlank
	private String password;
	@NotBlank
	private String confirmPassword;
	
	private TipoDocumentoNombre tipoDocumentoNombre;
	private Set<String> roles = new HashSet<>();
	
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public TipoDocumentoNombre getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}
	public void setTipoDocumentoNombre(TipoDocumentoNombre tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	

}


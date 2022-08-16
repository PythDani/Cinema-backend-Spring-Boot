package co.com.qvision.security.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.com.qvision.security.enums.TipoDocumentoNombre;

public class UsuarioPrincipal implements UserDetails {
	
	private long idUsuario;
	private String documento;	
	private String nombres;	
	private String apellidos;	
	private String correo;	
	private String password;	
	private String confirmPassword;
	private TipoDocumentoNombre tipoDocumentoNombre;	
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	public UsuarioPrincipal(String documento, String nombres, String apellidos, String correo, String password,
			String confirmPassword, TipoDocumentoNombre tipoDocumentoNombre,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.tipoDocumentoNombre = tipoDocumentoNombre;
		this.authorities = authorities;
	}

	

	public static UsuarioPrincipal build(Usuario usuario){
		List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name())).collect(Collectors.toList());
        
		return new UsuarioPrincipal(usuario.getDocumento(),
									usuario.getNombres(),
									usuario.getApellidos(), usuario.getCorreo(), 
									usuario.getPassword(),
									usuario.getConfirmPassword(),
									usuario.getTipoDocumentoNombre(),
									authorities);

	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	@Override
	public String getPassword() {
		
		return password;
	}
	@Override
	public String getUsername() {
		
		return correo;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}


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


	public void setPassword(String password) {
		this.password = password;
	}


	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	


}


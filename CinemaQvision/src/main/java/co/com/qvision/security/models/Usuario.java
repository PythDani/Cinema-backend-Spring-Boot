package co.com.qvision.security.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import co.com.qvision.entity.Reserva;
import co.com.qvision.security.enums.TipoDocumentoNombre;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "DOCUMENTO", length = 45)
	private String documento;

	@Column(name = "NOMBRES", length = 100)
	private String nombres;

	@Column(name = "APELLIDOS", length = 100)
	private String apellidos;

	@Column(name = "CORREO", length = 100, nullable = false, unique = true)
	private String correo;

	@Column(name = "PASSWORD", length = 100)
	private String password;

	@Transient
	private String confirmPassword;

	@Enumerated(EnumType.STRING)
	private TipoDocumentoNombre tipoDocumentoNombre;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idDocumento")
	private TipoDocumento tipoDocumento;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	@OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Reserva> reserva;

	public Usuario() {
		super();

	}

	public Usuario(String documento, String nombres, String apellidos, String correo, String password,
			String confirmPassword, TipoDocumentoNombre tipoDocumentoNombre) {
		super();
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

}


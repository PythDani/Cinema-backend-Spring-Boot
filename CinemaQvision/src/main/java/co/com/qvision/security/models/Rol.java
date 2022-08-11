<<<<<<< HEAD
package co.com.qvision.security.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import co.com.qvision.security.enums.RolNombre;

@Entity
@Table(name = "ROLES")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;

	@Column(name = "DESCRIPCION_ROL", length = 100)
	private String descripcionRol;

	public Rol() {
		super();
	}

	public Rol(RolNombre rolNombre, String descripcionRol) {
		super();
		this.rolNombre = rolNombre;
		this.descripcionRol = descripcionRol;
	}

	public Rol(int idRol,RolNombre rolNombre, String descripcionRol) {
		super();
		this.idRol = idRol;
		this.rolNombre = rolNombre;
		this.descripcionRol = descripcionRol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public RolNombre getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	
	
	

}
=======
package co.com.qvision.security.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import co.com.qvision.security.enums.RolNombre;

@Entity
@Table(name = "ROLES")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;

	@Column(name = "DESCRIPCION_ROL", length = 100)
	private String descripcionRol;

	public Rol() {
		super();
	}

	public Rol(RolNombre rolNombre, String descripcionRol) {
		super();
		this.rolNombre = rolNombre;
		this.descripcionRol = descripcionRol;
	}

	public Rol(int idRol,RolNombre rolNombre, String descripcionRol) {
		super();
		this.idRol = idRol;
		this.rolNombre = rolNombre;
		this.descripcionRol = descripcionRol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public RolNombre getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	
	
	

}
>>>>>>> c279d74573521fb1c19c0445369c524062666945

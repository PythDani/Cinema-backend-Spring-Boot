<<<<<<< HEAD
package co.com.qvision.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISOS")
public class Permiso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPermiso;
	
	
	@Column(name = "NOMBRE_PERMISO", length = 45)
	private String nombrePermiso;
	
	
	@Column(name = "DESCRIPCION_PERMISO", length = 45)
	private String descripcionPermiso;
	
	

}
=======
package co.com.qvision.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISOS")
public class Permiso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPermiso;
	
	
	@Column(name = "NOMBRE_PERMISO", length = 45)
	private String nombrePermiso;
	
	
	@Column(name = "DESCRIPCION_PERMISO", length = 45)
	private String descripcionPermiso;
	
	

}
>>>>>>> c279d74573521fb1c19c0445369c524062666945

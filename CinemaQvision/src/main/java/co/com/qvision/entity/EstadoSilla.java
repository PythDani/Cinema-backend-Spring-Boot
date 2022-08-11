package co.com.qvision.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADOS_SILLAS")
public class EstadoSilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstadoSilla;
	
	@Column(name = "NOMBRE_ESTADO", length = 45)
	private String nombreEstadoSilla;
	
	
	@OneToMany(mappedBy="estadoSilla", 
		    	cascade = { CascadeType.PERSIST, 
					    CascadeType.MERGE,
					    CascadeType.DETACH, 
					    CascadeType.REFRESH })
	private List<Silla> silla;
	
	
	
	@OneToMany(mappedBy="estadoSilla", 
		    cascade = { CascadeType.PERSIST, 
					    CascadeType.MERGE,
					    CascadeType.DETACH, 
					    CascadeType.REFRESH })
	private List<Reserva> reserva;

}

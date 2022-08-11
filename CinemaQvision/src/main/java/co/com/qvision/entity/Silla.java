package co.com.qvision.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SILLAS")
public class Silla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSilla;
	
	@Column(name = "NOMBRE_SILLA", length = 45)
	private String nombreSilla;
	
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idEstadoSilla")
	private EstadoSilla estadoSilla;
	
	
	@OneToMany(mappedBy="silla", 
		    cascade = { CascadeType.PERSIST, 
					    CascadeType.MERGE,
					    CascadeType.DETACH, 
					    CascadeType.REFRESH })
	private List<Reserva> reserva;

}

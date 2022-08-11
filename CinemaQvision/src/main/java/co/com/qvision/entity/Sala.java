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
@Table(name = "SALAS")
public class Sala {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSala;
	
	
	@Column(name = "NOMBRE_SALA", length = 45)
	private String nombreSala;
	
	@Column(name = "DESCRIPCION_SALA", length = 45)
	private String descripcionSala;
	
	
	@Column(name = "VALOR_BOLETA")
	private int valorBoleta;
	
	@Column(name = "CANTIDAD_SILLAS")
	private int cantidadSillas;
	
	
	@OneToMany(mappedBy="sala", 
		    cascade = { CascadeType.PERSIST, 
					    CascadeType.MERGE,
					    CascadeType.DETACH, 
					    CascadeType.REFRESH })
		private List<Reserva> reserva;
	

}


package co.com.qvision.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "HORARIOS")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHorario;
	
	@Column(name = "NOMBRE_HORARIO", length = 45)
	private String nombreHorario;
	
	
	@Column(name = "HORA_INICIO")
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date horaInicio;
	
	
	@Column(name = "HORA_FIN")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date horaFin;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "PELICULAS_HORARIOS",
			joinColumns = @JoinColumn(name = "horariosIdd",referencedColumnName = "idHorario"),
			inverseJoinColumns =@JoinColumn(name = "peliculasId",referencedColumnName = "idPelicula") 
			)
	private List<Pelicula> pelicula;
	
	
	
	@OneToMany(mappedBy="horario", 
		    cascade = { CascadeType.PERSIST, 
					    CascadeType.MERGE,
					    CascadeType.DETACH, 
					    CascadeType.REFRESH })
	private List<Reserva> reserva;
	

}


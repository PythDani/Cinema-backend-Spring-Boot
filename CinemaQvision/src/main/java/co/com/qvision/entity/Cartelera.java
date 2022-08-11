package co.com.qvision.entity;

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
import javax.persistence.Table;

@Entity
@Table(name = "CARTELERAS")
public class Cartelera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCartelera;	
	
	
	@Column(name = "NOMBRE_CARTELERA", length = 45)
	private String nombreCartelera;
	
	@Column(name = "DESCRIPCION_CARTELERA", length = 100)
	private String descripcionCartelera;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "PELICULAS_CARTELERA",
			joinColumns = @JoinColumn(name = "carteleraId",referencedColumnName = "idCartelera" ),
			inverseJoinColumns = @JoinColumn(name = "peliculasId",referencedColumnName = "idPelicula")
			)
	private List<Pelicula> pelicula;
	


}      
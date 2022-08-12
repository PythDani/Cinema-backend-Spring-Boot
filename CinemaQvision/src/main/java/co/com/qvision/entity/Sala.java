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
	private int idSala;

	@Column(name = "NOMBRE_SALA", length = 45)
	private String nombre;

	@Column(name = "DESCRIPCION_SALA", length = 45)
	private String descripcionSala;

	@Column(name = "VALOR_BOLETA")
	private int valorBoleta;

	@Column(name = "CANTIDAD_SILLAS")
	private int cantidadSillas;

	@OneToMany(mappedBy = "sala", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Reserva> reserva;

	public Sala() {
		super();
	}
	
	

	public Sala(int idSala, String nombre, String descripcionSala, int valorBoleta, int cantidadSillas) {
		super();
		this.idSala = idSala;
		this.nombre = nombre;
		this.descripcionSala = descripcionSala;
		this.valorBoleta = valorBoleta;
		this.cantidadSillas = cantidadSillas;
	}



	public Sala(String nombre, String descripcionSala, int valorBoleta, int cantidadSillas) {
		super();
		this.nombre = nombre;
		this.descripcionSala = descripcionSala;
		this.valorBoleta = valorBoleta;
		this.cantidadSillas = cantidadSillas;		
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombreSala) {
		this.nombre = nombreSala;
	}

	public String getDescripcionSala() {
		return descripcionSala;
	}

	public void setDescripcionSala(String descripcionSala) {
		this.descripcionSala = descripcionSala;
	}

	public int getValorBoleta() {
		return valorBoleta;
	}

	public void setValorBoleta(int valorBoleta) {
		this.valorBoleta = valorBoleta;
	}

	public int getCantidadSillas() {
		return cantidadSillas;
	}

	public void setCantidadSillas(int cantidadSillas) {
		this.cantidadSillas = cantidadSillas;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}
	
	
	

}

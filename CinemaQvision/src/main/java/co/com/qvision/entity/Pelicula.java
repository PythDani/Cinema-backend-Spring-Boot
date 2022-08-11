package co.com.qvision.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "PELICULAS")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPelicula;

	@Column(name = "TITULO", length = 45)
	private String titulo;

	@Column(name = "GENERO", length = 45)
	private String genero;

	@Lob
	@Column(name = "IMAGEN_PROMOCIONAL")
	private byte[] imagenPromocional;

	@Column(name = "SINOPSIS", length = 500)
	private String sinopsis;

	@Column(name = "DURACION")
	private int duracion;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "FECHA_ESTRENO")
	private LocalDate fechaEstreno;

	@Column(name = "FORMATO", length = 45)
	private String formato;

	@Column(name = "ESTADO_PELICULA", length = 45)
	private String estadoPelicula;

	@OneToMany(mappedBy = "pelicula", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Reserva> reserva;

	public Pelicula() {
		super();

	}

	public Pelicula(String titulo, String genero, String sinopsis, int duracion, String formato,
			String estadoPelicula) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.formato = formato;
		this.estadoPelicula = estadoPelicula;
	}

	public Pelicula(String titulo, String genero, byte[] imagenPromocional, String sinopsis, int duracion,
			LocalDate fechaEstreno, String formato, String estadoPelicula) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.imagenPromocional = imagenPromocional;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.fechaEstreno = fechaEstreno;
		this.formato = formato;
		this.estadoPelicula = estadoPelicula;
	}

	public Pelicula(String titulo, String genero, String sinopsis, int duracion, LocalDate fechaEstreno, String formato,
			String estadoPelicula) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.fechaEstreno = fechaEstreno;
		this.formato = formato;
		this.estadoPelicula = estadoPelicula;
	}

	public long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(long idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public byte[] getImagenPromocional() {
		return imagenPromocional;
	}

	public void setImagenPromocional(byte[] imagenPromocional) {
		this.imagenPromocional = imagenPromocional;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getEstadoPelicula() {
		return estadoPelicula;
	}

	public void setEstadoPelicula(String estadoPelicula) {
		this.estadoPelicula = estadoPelicula;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", genero=" + genero
				+ ", imagenPromocional=" + Arrays.toString(imagenPromocional) + ", sinopsis=" + sinopsis + ", duracion="
				+ duracion + ", fechaEstreno=" + fechaEstreno + ", formato=" + formato + ", estadoPelicula="
				+ estadoPelicula + ", reserva=" + reserva + "]";
	}

}

package co.com.qvision.dto;

import java.time.LocalDate;

public class PeliculaDto {

	private String titulo;
	private String genero;
	private byte[] imagenPromocional;
	private String sinopsis;
	private int duracion;
	private LocalDate fechaEstreno;
	private String formato;
	private String estadoPelicula;

	public PeliculaDto() {
		super();

	}

	public PeliculaDto(String titulo, String genero, String sinopsis, int duracion, String formato,
			String estadoPelicula) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.formato = formato;
		this.estadoPelicula = estadoPelicula;
	}

	public PeliculaDto(String titulo, String genero, String sinopsis, int duracion, LocalDate fechaEstreno,
			String formato, String estadoPelicula) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.fechaEstreno = fechaEstreno;
		this.formato = formato;
		this.estadoPelicula = estadoPelicula;
	}

	public PeliculaDto(String titulo, String genero, byte[] imagenPromocional, String sinopsis, int duracion,
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

}

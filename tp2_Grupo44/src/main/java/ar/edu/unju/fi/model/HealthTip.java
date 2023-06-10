package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class HealthTip {

    // region Attributes
    @NotEmpty(message = "Debes introducir un título")
	@Size(min = 5, max = 30, message = "El título solo puede contener entre 5 y 30 caracteres")
    private String titulo;

    @NotEmpty(message = "Debes introducir contenido del artículo")
	@Size(min = 20, message = "El contenido del artículo debe tener como mínimo 20 caracteres")
    private String contenido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Ingrese la fecha de publicación")
    private LocalDate fechaPublicacion;

    @NotEmpty(message = "Ingrese la url de imagen")
    private String imagen;
    
    private short identificador;
    // endregion

    // region Constructors
    public HealthTip() {};

    public HealthTip(
            String titulo,
            String contenido,
            LocalDate fechaPublicacion,
            String imagen,
            short identificador) {

        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.imagen=imagen;
        this.identificador = identificador;

    }
    // endregion

    // region Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public short getIdentificador() {
        return identificador;
    }

    public void setIdentificador(short identificador) {
        this.identificador = identificador;
    }

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	};
    // endregion

    
}

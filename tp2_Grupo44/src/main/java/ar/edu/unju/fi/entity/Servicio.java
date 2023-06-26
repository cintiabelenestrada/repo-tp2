package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "servicios")
public class Servicio {

    //#region Attributes
    @Id
    @Column(name = "servicio_identificador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identificador;

    @Column(name = "servicio_estado", columnDefinition = "boolean default true")
    private boolean estado;

    @Column(name = "servicio_nombre")
    @NotBlank(message = "Debes ingresar un nombre")
	@Size(min = 5, max = 15, message = "El nombre del producto solo puede contener entre 5 y 15 caracteres")
    private String nombre;

    @Column(name = "servicio_tipo")
    @NotBlank(message = "Debes ingresar un tipo de servicio")
	@Size(min = 5, max = 15, message = "El nombre del servicio solo puede contener entre 5 y 15 caracteres")
    private String tipo;

    @Column(name = "servicio_dia_disponible")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debes ingresar una fecha")
	@Future(message = "Fecha incorrecta")
    private LocalDate diaDisponible;

    @Autowired
	@JoinColumn(name = "empleado_indentificador")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@NotNull(message = "Debe seleccionar un empleado")
    private Empleado empleado;
    //#endregion

    //#region Constructors
    public Servicio() {
        this.estado = true;
    }

    public Servicio(
        long identificador,
        boolean estado,
        String nombre,
        String tipo,
        LocalDate diaDisponible,
        Empleado empleado) {

        this.identificador = identificador;
        this.estado = estado;
        this.nombre = nombre;
        this.tipo = tipo;
        this.diaDisponible = diaDisponible;
        this.empleado = empleado;

    }
    //#endregion

    //#region Methods
    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDiaDisponible() {
        return diaDisponible;
    }

    public void setDiaDisponible(LocalDate diaDisponible) {
        this.diaDisponible = diaDisponible;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    //#endregion

    //#region Methods
    //#endregion
    
}

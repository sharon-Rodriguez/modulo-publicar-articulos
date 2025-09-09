/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PublicarArticulos.GestorArticulos.model;

import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Articulos")
public class Articulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticulos;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "id_Usuario", nullable = false)
    private Usuario usuarioPropietario;

    @Column(length = 100, nullable = false)
    private String nombre;

    private Boolean disponible;

    private Integer precio;

    @Column(name = "tipo_Accion", length = 20)
    private String tipoAccion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "Imagen_URL", length = 255)
    private String imagenUrl;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_de_publicacion")
    private Date fechaPublicacion;

    // =====================
    // Getters y Setters
    // =====================

    public Integer getIdArticulos() {
        return idArticulos;
    }

    public void setIdArticulos(Integer idArticulos) {
        this.idArticulos = idArticulos;
    }

    public Usuario getUsuarioPropietario() {
        return usuarioPropietario;
    }

    public void setUsuarioPropietario(Usuario usuarioPropietario) {
        this.usuarioPropietario = usuarioPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}

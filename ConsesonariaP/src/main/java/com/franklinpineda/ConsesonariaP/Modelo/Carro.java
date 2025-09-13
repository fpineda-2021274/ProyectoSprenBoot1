package com.franklinpineda.ConsesonariaP.Modelo;

import jakarta.persistence.*; // O javax.persistence si usas versión anterior
import jakarta.validation.constraints.NotBlank; // Para validaciones

@Entity
@Table(name = "carro") // Nombre de la tabla en BD
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Cambié a Integer como en tu controller

    @Column
    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;

    @Column
    @NotBlank(message = "El modelo no puede estar vacío")
    private String modelo;

    @Column // Sin tilde en el nombre del campo Java
    @NotBlank(message = "El año no puede estar vacío")
    private String año; // ¡Aquí el cambio! Usa 'anio' en lugar de 'año'

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() { // Sin tilde
        return año;
    }

    public void setAño(String año) { // Sin tilde
        this.año = año;
    }
}
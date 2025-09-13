package com.franklinpineda.ConsesonariaP.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Compatibilidad")
public class Compatibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Compatibilidad")
    private Integer idCompatibilidad;

    @Column(name = "repuesto")
    private Integer repuesto;

    @Column(name = "carro")
    private Integer carro;

    public Integer getIdCompatibilidad() {
        return idCompatibilidad;
    }

    public void setIdCompatibilidad(Integer idCompatibilidad) {
        this.idCompatibilidad = idCompatibilidad;
    }

    public Integer getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Integer repuesto) {
        this.repuesto = repuesto;
    }

    public Integer getCarro() {
        return carro;
    }

    public void setCarro(Integer carro) {
        this.carro = carro;
    }
}
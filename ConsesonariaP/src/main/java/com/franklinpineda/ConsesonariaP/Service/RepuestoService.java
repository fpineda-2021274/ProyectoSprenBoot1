package com.franklinpineda.ConsesonariaP.Service;

import com.franklinpineda.ConsesonariaP.Modelo.Repuesto;

import java.util.List;

public interface RepuestoService {
    List<Repuesto> getAllRepuesto();
    Repuesto getRepuestoById(Integer id);
    Repuesto saveRepuesto(Repuesto repuesto);
    Repuesto updateRepuesto(Integer id, Repuesto repuesto);
    void deleteRepuesto(Integer id);
}
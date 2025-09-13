package com.franklinpineda.ConsesonariaP.Service;

import com.franklinpineda.ConsesonariaP.Modelo.Compatibilidad;
import com.franklinpineda.ConsesonariaP.Repositorio.CompatibilidadRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilidadServiceImpl implements CompatibilidadService {

    private final CompatibilidadRepositorio compatibilidadRepositorio;

    public CompatibilidadServiceImpl(CompatibilidadRepositorio compatibilidadRepositorio) {
        this.compatibilidadRepositorio = compatibilidadRepositorio
        ;
    }

    @Override
    public List<Compatibilidad> getAllCompatibilidad() {
        return compatibilidadRepositorio.findAll();
    }

    @Override
    public Compatibilidad getCompatibilidadById(Integer id) {
        return compatibilidadRepositorio.findById(id).orElse(null);
    }

    @Override
    public Compatibilidad saveCompatibilidad(Compatibilidad compatibilidad) {
        return compatibilidadRepositorio.save(compatibilidad);
    }

    @Override
    public Compatibilidad updateCompatibilidad(Integer id, Compatibilidad compatibilidad) {
        Compatibilidad existingCompatibilidad = compatibilidadRepositorio.findById(id).orElse(null);
        if (existingCompatibilidad != null) {
            existingCompatibilidad.setRepuesto(compatibilidad.getRepuesto());
            existingCompatibilidad.setCarro(compatibilidad.getCarro());
            return compatibilidadRepositorio.save(existingCompatibilidad);
        }
        return null;
    }

    @Override
    public void deleteCompatibilidad(Integer id) {
        compatibilidadRepositorio.deleteById(id);
    }
}

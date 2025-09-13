package com.franklinpineda.ConsesonariaP.Service;

import com.franklinpineda.ConsesonariaP.Modelo.Repuesto;
import com.franklinpineda.ConsesonariaP.Repositorio.RepuestoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    private final RepuestoRepositorio repuestoRepository;

    public RepuestoServiceImpl(RepuestoRepositorio repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public List<Repuesto> getAllRepuesto() {
        return repuestoRepository.findAll();
    }

    @Override
    public Repuesto getRepuestoById(Integer id) {
        return repuestoRepository.findById(id).orElse(null);
    }

    @Override
    public Repuesto saveRepuesto(Repuesto repuesto) {
        return repuestoRepository.save(repuesto);
    }

    @Override
    public Repuesto updateRepuesto(Integer id, Repuesto repuesto) {
        Repuesto existingRepuesto = repuestoRepository.findById(id).orElse(null);
        if (existingRepuesto != null) {
            existingRepuesto.setNombreRepuesto(repuesto.getNombreRepuesto());
            existingRepuesto.setDescripcion(repuesto.getDescripcion());
            existingRepuesto.setCategoria(repuesto.getCategoria());
            return repuestoRepository.save(existingRepuesto);
        }
        return null;
    }

    @Override
    public void deleteRepuesto(Integer id) {
        repuestoRepository.deleteById(id);
    }
}
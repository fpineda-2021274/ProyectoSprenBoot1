package com.franklinpineda.ConsesonariaP.Controller;

import com.franklinpineda.ConsesonariaP.Modelo.Compatibilidad;
import com.franklinpineda.ConsesonariaP.Repositorio.CompatibilidadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compatibilidades")
public class CompatibilidadController {

    @Autowired
    private CompatibilidadRepositorio compatibilidadRepositorio;

    // 🔹 Listar todas las compatibilidades
    @GetMapping
    public ResponseEntity<List<Compatibilidad>> listarCompatibilidades() {
        List<Compatibilidad> compatibilidades = compatibilidadRepositorio.findAll();
        return new ResponseEntity<>(compatibilidades, HttpStatus.OK);
    }

    // 🔹 Buscar compatibilidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Compatibilidad>> obtenerCompatibilidad(@PathVariable Integer id) {
        Optional<Compatibilidad> compatibilidad = compatibilidadRepositorio.findById(id);
        if (compatibilidad.isPresent()) {
            return new ResponseEntity<>(compatibilidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 Crear nueva compatibilidad
    @PostMapping
    public ResponseEntity<Compatibilidad> crearCompatibilidad(@RequestBody Compatibilidad compatibilidad) {
        try {
            Compatibilidad nuevaCompatibilidad = compatibilidadRepositorio.save(compatibilidad);
            return new ResponseEntity<>(nuevaCompatibilidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 🔹 Actualizar compatibilidad
    @PutMapping("/{id}")
    public ResponseEntity<Compatibilidad> actualizarCompatibilidad(@PathVariable Integer id, @RequestBody Compatibilidad compatibilidadActualizada) {
        Optional<Compatibilidad> compatibilidadExistente = compatibilidadRepositorio.findById(id);
        if (compatibilidadExistente.isPresent()) {
            Compatibilidad compatibilidad = compatibilidadExistente.get();
            compatibilidad.setRepuesto(compatibilidadActualizada.getRepuesto());
            compatibilidad.setCarro(compatibilidadActualizada.getCarro());
            return new ResponseEntity<>(compatibilidadRepositorio.save(compatibilidad), HttpStatus.OK);
        } else {
            compatibilidadActualizada.setIdCompatibilidad(id);
            return new ResponseEntity<>(compatibilidadRepositorio.save(compatibilidadActualizada), HttpStatus.CREATED);
        }
    }

    // 🔹 Eliminar compatibilidad
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCompatibilidad(@PathVariable Integer id) {
        if (compatibilidadRepositorio.existsById(id)) {
            compatibilidadRepositorio.deleteById(id);
            return new ResponseEntity<>("Compatibilidad with id: " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, compatibilidad with id: " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }
}
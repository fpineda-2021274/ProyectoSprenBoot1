package com.franklinpineda.ConsesonariaP.Controller;

import com.franklinpineda.ConsesonariaP.Modelo.Repuesto;
import com.franklinpineda.ConsesonariaP.Service.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoService repuestoService;

    // 🔹 Listar todos los repuestos
    @GetMapping
    public ResponseEntity<List<Repuesto>> listarRepuestos() {
        List<Repuesto> repuestos = repuestoService.getAllRepuesto();
        return new ResponseEntity<>(repuestos, HttpStatus.OK);
    }

    // 🔹 Buscar repuesto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> obtenerRepuesto(@PathVariable Integer id) {
        Repuesto repuesto = repuestoService.getRepuestoById(id);
        if (repuesto != null) {
            return new ResponseEntity<>(repuesto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 Crear nuevo repuesto
    @PostMapping
    public ResponseEntity<Repuesto> crearRepuesto(@RequestBody Repuesto repuesto) {
        Repuesto nuevoRepuesto = repuestoService.saveRepuesto(repuesto);
        return new ResponseEntity<>(nuevoRepuesto, HttpStatus.CREATED);
    }

    // 🔹 Actualizar repuesto
    @PutMapping("/{id}")
    public ResponseEntity<Repuesto> actualizarRepuesto(@PathVariable Integer id, @RequestBody Repuesto repuesto) {
        Repuesto updatedRepuesto = repuestoService.updateRepuesto(id, repuesto);
        if (updatedRepuesto != null) {
            return new ResponseEntity<>(updatedRepuesto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 Eliminar repuesto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRepuesto(@PathVariable Integer id) {
        try {
            repuestoService.deleteRepuesto(id);
            return new ResponseEntity<>("Repuesto with id: " + id + " deleted complete", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error, repuesto with id: " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }
}
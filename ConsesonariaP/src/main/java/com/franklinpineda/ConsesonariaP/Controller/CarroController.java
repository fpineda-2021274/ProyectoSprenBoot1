package com.franklinpineda.ConsesonariaP.Controller;

import com.franklinpineda.ConsesonariaP.Modelo.Carro;
import com.franklinpineda.ConsesonariaP.Repositorio.CarroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("id/carros")
public class CarroController {

    @Autowired
    private CarroRepositorio carroRepositorio;

    // 🔹 Listar todos los carros
    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        List<Carro> carros = carroRepositorio.findAll();
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    // 🔹 Buscar carro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carro>> obtenerCarro(@PathVariable Integer id) {
        Optional<Carro> carro = carroRepositorio.findById(id);
        if (carro.isPresent()) {
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 Crear nuevo carro
    @PostMapping
    public ResponseEntity<Carro> crearCarro(@RequestBody Carro carro) {
        try {
            Carro nuevoCarro = carroRepositorio.save(carro);
            return new ResponseEntity<>(nuevoCarro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 🔹 Actualizar carro
    @PutMapping("/{id}")
    public ResponseEntity<Carro> actualizarCarro(@PathVariable Integer id, @RequestBody Carro carroActualizado) {
        Optional<Carro> carroExistente = carroRepositorio.findById(id);
        if (carroExistente.isPresent()) {
            Carro carro = carroExistente.get();
            carro.setMarca(carroActualizado.getMarca());
            carro.setModelo(carroActualizado.getModelo());
            carro.setAño(carroActualizado.getAño()); // Corregido a "Anio" sin tilde
            return new ResponseEntity<>(carroRepositorio.save(carro), HttpStatus.OK);
        } else {
            carroActualizado.setId(id);
            return new ResponseEntity<>(carroRepositorio.save(carroActualizado), HttpStatus.CREATED);
        }
    }

    // 🔹 Eliminar carro
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCarro(@PathVariable Integer id) {
        if (carroRepositorio.existsById(id)) {
            carroRepositorio.deleteById(id);
            return new ResponseEntity<>("Carro with id: " + id + " deleted complete", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, carro with id: " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }
}
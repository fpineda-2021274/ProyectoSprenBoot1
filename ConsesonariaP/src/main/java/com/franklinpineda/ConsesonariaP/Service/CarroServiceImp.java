package com.franklinpineda.ConsesonariaP.Service;

import com.franklinpineda.ConsesonariaP.Modelo.Carro;
import com.franklinpineda.ConsesonariaP.Repositorio.CarroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImp implements CarroService {

    private final CarroRepositorio carroRepositorio;

    public CarroServiceImp(CarroRepositorio carroRepositorio) {
        this.carroRepositorio = carroRepositorio;
    }

    @Override
    public List<Carro> getAllCarro() {
        return carroRepositorio.findAll();
    }

    @Override
    public Carro getCarroById(Integer id) {
        return carroRepositorio.findById(id).orElse(null);
    }

    @Override
    public Carro saveCarro(Carro carro) {
        return carroRepositorio.save(carro);
    }

    @Override
    public Carro updateCarro(Integer id, Carro carro) {
        Carro existingCarro = carroRepositorio.findById(id).orElse(null);
        if (existingCarro != null) {
            existingCarro.setMarca(carro.getMarca());
            existingCarro.setModelo(carro.getModelo());
            existingCarro.setAño(carro.getAño());
            return carroRepositorio.save(existingCarro);
        }
        return null;
    }

    @Override
    public void deleteCarro(Integer id) {
        carroRepositorio.deleteById(id);
    }
}
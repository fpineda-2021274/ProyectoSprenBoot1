package com.franklinpineda.ConsesonariaP.Service;

import com.franklinpineda.ConsesonariaP.Modelo.Carro;

import java.util.List;

public interface CarroService {
    List <Carro> getAllCarro();
    Carro getCarroById(Integer id);
    Carro saveCarro(Carro carro);
    Carro updateCarro(Integer id, Carro carro);
    void deleteCarro(Integer id);

}
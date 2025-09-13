package com.franklinpineda.ConsesonariaP.Repositorio;

import com.franklinpineda.ConsesonariaP.Modelo.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepositorio extends JpaRepository<Carro, Integer> {

}
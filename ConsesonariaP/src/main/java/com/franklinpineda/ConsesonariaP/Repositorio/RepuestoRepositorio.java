package com.franklinpineda.ConsesonariaP.Repositorio;

import com.franklinpineda.ConsesonariaP.Modelo.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepositorio extends JpaRepository<Repuesto, Integer> {
}
package com.franklinpineda.ConsesonariaP.Repositorio;

import com.franklinpineda.ConsesonariaP.Modelo.Compatibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompatibilidadRepositorio extends JpaRepository<Compatibilidad, Integer> {
}
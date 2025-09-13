package com.franklinpineda.ConsesonariaP.Repositorio;

import com.franklinpineda.ConsesonariaP.Modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
}
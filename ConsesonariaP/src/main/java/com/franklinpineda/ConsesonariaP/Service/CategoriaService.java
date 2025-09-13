package com.franklinpineda.ConsesonariaP.Service;

import com.franklinpineda.ConsesonariaP.Modelo.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getAllCategoria();
    Categoria getCategoriaById(Integer id);
    Categoria saveCategoria(Categoria categoria);
    Categoria updateCategoria(Integer id, Categoria categoria);
    void deleteCategoria(Integer id);
}
package com.franklinpineda.ConsesonariaP.Service;

import com.franklinpineda.ConsesonariaP.Modelo.Categoria;
import com.franklinpineda.ConsesonariaP.Repositorio.CategoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepositorio categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepositorio categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> getAllCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Integer id, Categoria categoria) {
        Categoria existingCategoria = categoriaRepository.findById(id).orElse(null);
        if (existingCategoria != null) {
            existingCategoria.setNombreCategoria(categoria.getNombreCategoria());
            existingCategoria.setDescripcionCategoria(categoria.getDescripcionCategoria());
            return categoriaRepository.save(existingCategoria);
        }
        return null;
    }

    @Override
    public void deleteCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
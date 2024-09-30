package com.api.api.service.impl;

import com.api.api.dto.CategoriaDto;
import com.api.api.mapper.CategoriaMapper;
import com.api.api.model.Categoria;
import com.api.api.repository.CategoriaRepository;
import com.api.api.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Integer id) {
        return getCategoria(id);
    }

    @Override
    public Categoria create(CategoriaDto dto) {
        return categoriaRepository.save(CategoriaMapper.fromDtoToEntity(dto));
    }

    @Override
    public Categoria update(Integer id, CategoriaDto dto) {
        getCategoria(id);
        dto.setId(id);
        return categoriaRepository.save(CategoriaMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Integer id) {
        getCategoria(id);
        categoriaRepository.deleteById(id);
    }

    private Categoria getCategoria(Integer id){
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.get();
    }
}

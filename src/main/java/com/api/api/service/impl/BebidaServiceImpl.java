package com.api.api.service.impl;

import com.api.api.dto.BebidaDto;
import com.api.api.mapper.BebidaMapper;
import com.api.api.model.Bebida;
import com.api.api.model.Categoria;
import com.api.api.repository.BebidaRepository;
import com.api.api.repository.CategoriaRepository;
import com.api.api.service.BebidaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaServiceImpl implements BebidaService {


    private final BebidaRepository bebidaRepository;

    private final CategoriaRepository categoriaRepository;

    public BebidaServiceImpl(BebidaRepository bebidaRepository, CategoriaRepository categoriaRepository) {
        this.bebidaRepository = bebidaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Bebida> listarTodas() {
        return bebidaRepository.findAll();
    }

    @Override
    public Bebida findById(Integer id) {
        return getBebida(id);
    }

    @Override
    public Bebida create(BebidaDto dto) {
        var categoriaOpt = categoriaRepository.findById(dto.getIdCategoria());
        Categoria categoria = categoriaOpt.get();

        return bebidaRepository.save(BebidaMapper.fromDtoToEntity(dto, categoria));
    }

    @Override
    public Bebida update(Integer id, BebidaDto dto) {
        getBebida(id);
        dto.setId(id);

        var categoriaOpt = categoriaRepository.findById(dto.getIdCategoria());
        Categoria categoria = categoriaOpt.get();

        return bebidaRepository.save(BebidaMapper.fromDtoToEntity(dto, categoria));
    }

    @Override
    public void delete(Integer id) {
        getBebida(id);
        bebidaRepository.deleteById(id);
    }

    private Bebida getBebida(Integer id) {
        Optional<Bebida> optionalBebida = bebidaRepository.findById(id);
        return optionalBebida.get();
    }
}

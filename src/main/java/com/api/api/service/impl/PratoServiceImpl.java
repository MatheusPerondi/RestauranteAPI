package com.api.api.service.impl;

import com.api.api.dto.PratoDto;
import com.api.api.mapper.PratoMapper;
import com.api.api.model.Categoria;
import com.api.api.model.Prato;
import com.api.api.repository.CategoriaRepository;
import com.api.api.repository.PratoRepository;
import com.api.api.service.PratoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PratoServiceImpl  implements PratoService {

    private final PratoRepository pratoRepository;

    private final CategoriaRepository categoriaRepository;

    public PratoServiceImpl(PratoRepository pratoRepository, CategoriaRepository categoriaRepository) {
        this.pratoRepository = pratoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Prato> listarTodas() {
        return pratoRepository.findAll();
    }

    @Override
    public Prato findById(Integer id) {
        return getPrato(id);
    }

    @Override
    public Prato create(PratoDto dto) {
        var categoriaOpt = categoriaRepository.findById(dto.getCategoriaId());
        Categoria categoria = categoriaOpt.get();

        return pratoRepository.save(PratoMapper.fromDtoToEntity(dto, categoria));
    }

    @Override
    public Prato update(Integer id, PratoDto dto) {
        getPrato(id);
        dto.setId(id);

        var categoriaOpt = categoriaRepository.findById(dto.getCategoriaId());

        Categoria categoria = categoriaOpt.get();

        return pratoRepository.save(PratoMapper.fromDtoToEntity(dto, categoria));
    }

    @Override
    public void delete(Integer id) {
        getPrato(id);
        pratoRepository.deleteById(id);
    }

    private Prato getPrato(Integer id){
        Optional<Prato> optionalPrato = pratoRepository.findById(id);
        return optionalPrato.get();
    }
}

package com.api.api.service.impl;

import com.api.api.dto.PedidoDto;
import com.api.api.mapper.PedidoMapper;
import com.api.api.model.Bebida;
import com.api.api.model.Pedido;
import com.api.api.model.Prato;
import com.api.api.repository.BebidaRepository;
import com.api.api.repository.PedidoRepository;
import com.api.api.repository.PratoRepository;
import com.api.api.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PratoRepository pratoRepository;
    private final BebidaRepository bebidaRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, PratoRepository pratoRepository, BebidaRepository bebidaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pratoRepository = pratoRepository;
        this.bebidaRepository = bebidaRepository;
    }

    @Override
    public List<Pedido> listarTodas() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Integer id) {
        return getPedido(id);
    }

    @Override
    public Pedido create(PedidoDto dto) {
        var pratoOpt = pratoRepository.findById(dto.getPratoId());
        var bebidaOpt = bebidaRepository.findById(dto.getBebidaId());

        Prato prato = pratoOpt.get();
        Bebida bebida = bebidaOpt.get();

        return pedidoRepository.save(PedidoMapper.fromDtoToEntity(dto, prato, bebida));

    }

    @Override
    public Pedido update(Integer id, PedidoDto dto) {
        getPedido(id);
        dto.setId(id);

        var pratoOpt = pratoRepository.findById(dto.getPratoId());
        var bebidaOpt = bebidaRepository.findById(dto.getBebidaId());

        Prato prato = pratoOpt.get();
        Bebida bebida = bebidaOpt.get();

        return pedidoRepository.save(PedidoMapper.fromDtoToEntity(dto, prato, bebida));
    }

    @Override
    public void delete(Integer id) {
        pedidoRepository.deleteById(id);
    }

    private Pedido getPedido(Integer id){
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        return optionalPedido.get();
    }
}

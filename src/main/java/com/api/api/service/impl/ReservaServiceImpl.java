package com.api.api.service.impl;

import com.api.api.dto.ReservaDto;
import com.api.api.mapper.ReservaMapper;
import com.api.api.model.Reserva;
import com.api.api.repository.ReservaRepository;
import com.api.api.service.ReservaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva findById(Integer id) {
        return getReserva(id);
    }

    @Override
    public Reserva create(ReservaDto dto) {
        return reservaRepository.save(ReservaMapper.fromDtoToEntity(dto));
    }

    @Override
    public Reserva update(Integer id, ReservaDto dto) {
        getReserva(id);
        dto.setId(id);
        return reservaRepository.save(ReservaMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Integer id) {
        reservaRepository.deleteById(id);
    }

    private Reserva getReserva(Integer id){
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        return optionalReserva.get();
    }
}

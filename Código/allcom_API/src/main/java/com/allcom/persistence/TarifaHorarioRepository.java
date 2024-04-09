package com.allcom.persistence;

import com.allcom.domain.HourlyRate;
import com.allcom.domain.repository.HourlyRateRepository;
import com.allcom.persistence.crud.TarifaHorarioCrudRepository;
import com.allcom.persistence.entity.TarifaHorario;
import com.allcom.persistence.mapper.HourlyRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TarifaHorarioRepository implements HourlyRateRepository {
    @Autowired
    private TarifaHorarioCrudRepository tarifaHorarioCrudRepository;

    @Autowired
    private HourlyRateMapper mapper;

    @Override
    public Optional<List<HourlyRate>> getByUser(String userNameId){
        Optional<List<TarifaHorario>> tarifasHorario = tarifaHorarioCrudRepository.findByIdUsuarioNombre(userNameId);
        return tarifasHorario.map(tarifas -> mapper.toHourliesRate(tarifas));
    }
}

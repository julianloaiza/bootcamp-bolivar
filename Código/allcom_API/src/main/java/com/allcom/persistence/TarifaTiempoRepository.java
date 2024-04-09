package com.allcom.persistence;

import com.allcom.domain.TimeRate;
import com.allcom.domain.repository.TimeRateRepository;
import com.allcom.persistence.crud.TarifaTiempoCrudRepository;
import com.allcom.persistence.entity.TarifaTiempo;
import com.allcom.persistence.mapper.TimeRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TarifaTiempoRepository implements TimeRateRepository {
    @Autowired
    private TarifaTiempoCrudRepository tarifaTiempoCrudRepository;

    @Autowired
    private TimeRateMapper mapper;

    @Override
    public Optional<List<TimeRate>> getByUser(String userNameId){
        Optional<List<TarifaTiempo>> tarifasTiempo = tarifaTiempoCrudRepository.findByIdUsuarioNombre(userNameId);
        return tarifasTiempo.map(tarifas -> mapper.toTimesRate(tarifas));
    }
}

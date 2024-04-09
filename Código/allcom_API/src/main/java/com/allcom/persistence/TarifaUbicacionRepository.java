package com.allcom.persistence;

import com.allcom.domain.LocationRate;
import com.allcom.domain.repository.LocationRateRepository;
import com.allcom.persistence.crud.TarifaUbicacionCrudRepository;
import com.allcom.persistence.entity.TarifaUbicacion;
import com.allcom.persistence.mapper.LocationRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TarifaUbicacionRepository implements LocationRateRepository {
    @Autowired
    private TarifaUbicacionCrudRepository tarifaUbicacionCrudRepository;

    @Autowired
    private LocationRateMapper mapper;

    @Override
    public Optional<List<LocationRate>> getByUser(String userNameId) {
        Optional<List<TarifaUbicacion>> tarifasUbicacion = tarifaUbicacionCrudRepository.findByIdUsuarioNombre(userNameId);
        return tarifasUbicacion.map(tarifas -> mapper.toLocationsRate(tarifas));

    }
}

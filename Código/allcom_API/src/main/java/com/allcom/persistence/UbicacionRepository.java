package com.allcom.persistence;

import com.allcom.domain.Facture;
import com.allcom.domain.Location;
import com.allcom.domain.repository.FactureRepository;
import com.allcom.domain.repository.LocationRepository;
import com.allcom.persistence.crud.UbicacionCrudRepository;
import com.allcom.persistence.entity.Factura;
import com.allcom.persistence.entity.Ubicacion;
import com.allcom.persistence.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UbicacionRepository implements LocationRepository {
    @Autowired
    private UbicacionCrudRepository ubicacionCrudRepository;
    @Autowired
    private LocationMapper mapper;

    @Override
    public List<Location> getAll() {
        List<Ubicacion> locations = (List<Ubicacion>) ubicacionCrudRepository.findAll();
        return mapper.toLocations(locations);
    }

}

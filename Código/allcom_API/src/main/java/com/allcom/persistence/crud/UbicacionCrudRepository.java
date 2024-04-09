package com.allcom.persistence.crud;

import com.allcom.persistence.entity.Ubicacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UbicacionCrudRepository extends CrudRepository<Ubicacion, Integer> {
}

package com.allcom.persistence.crud;

import com.allcom.persistence.entity.TarifaHorario;
import com.allcom.persistence.entity.TarifaTiempo;
import com.allcom.persistence.entity.TarifaUbicacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TarifaUbicacionCrudRepository extends CrudRepository<TarifaUbicacion, Integer> {
    Optional<List<TarifaUbicacion>> findByIdUsuarioNombre(String userNameId);
}

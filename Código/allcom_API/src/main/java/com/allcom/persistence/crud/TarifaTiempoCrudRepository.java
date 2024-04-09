package com.allcom.persistence.crud;

import com.allcom.persistence.entity.TarifaHorario;
import com.allcom.persistence.entity.TarifaTiempo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TarifaTiempoCrudRepository extends CrudRepository<TarifaTiempo, Integer> {
    Optional<List<TarifaTiempo>> findByIdUsuarioNombre(String userNameId);
}

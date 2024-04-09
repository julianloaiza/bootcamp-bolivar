package com.allcom.persistence.crud;

import com.allcom.persistence.entity.TarifaHorario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TarifaHorarioCrudRepository extends CrudRepository<TarifaHorario, Integer> {
    Optional<List<TarifaHorario>> findByIdUsuarioNombre(String userNameId);
}

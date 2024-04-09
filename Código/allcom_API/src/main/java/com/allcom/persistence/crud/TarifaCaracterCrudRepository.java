package com.allcom.persistence.crud;

import com.allcom.domain.CharacterRate;
import com.allcom.persistence.entity.TarifaCaracter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TarifaCaracterCrudRepository extends CrudRepository<TarifaCaracter, Integer> {
    Optional<List<TarifaCaracter>> findByIdUsuarioNombre(String userNameId);
}

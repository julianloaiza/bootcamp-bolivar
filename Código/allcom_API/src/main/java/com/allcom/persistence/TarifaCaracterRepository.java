package com.allcom.persistence;

import com.allcom.domain.CharacterRate;
import com.allcom.domain.repository.CharacterRateRepository;
import com.allcom.persistence.crud.TarifaCaracterCrudRepository;
import com.allcom.persistence.entity.TarifaCaracter;
import com.allcom.persistence.mapper.CharacterRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TarifaCaracterRepository implements CharacterRateRepository {
    @Autowired
    private TarifaCaracterCrudRepository tarifaCaracterCrudRepository;

    @Autowired
    private CharacterRateMapper mapper;

    @Override
    public Optional<List<CharacterRate>> getByUser(String userNameId){
        Optional<List<TarifaCaracter>> tarifaCaracteres = tarifaCaracterCrudRepository.findByIdUsuarioNombre(userNameId);
        return tarifaCaracteres.map(tarifas -> mapper.toCharactersRate(tarifas));
    }
}

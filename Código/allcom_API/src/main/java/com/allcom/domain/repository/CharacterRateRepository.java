package com.allcom.domain.repository;

import com.allcom.domain.CharacterRate;

import java.util.List;
import java.util.Optional;

public interface CharacterRateRepository {
    Optional<List<CharacterRate>> getByUser(String userNameId);
}

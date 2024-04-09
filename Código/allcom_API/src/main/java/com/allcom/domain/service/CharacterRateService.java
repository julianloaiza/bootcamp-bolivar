package com.allcom.domain.service;

import com.allcom.domain.CharacterRate;
import com.allcom.domain.repository.CharacterRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterRateService {
    @Autowired
    private CharacterRateRepository characterRateRepository;

    public Optional<List<CharacterRate>> getByUser(String userNameId) {
        return characterRateRepository.getByUser(userNameId);
    }
}

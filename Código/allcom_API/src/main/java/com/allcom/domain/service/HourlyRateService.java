package com.allcom.domain.service;

import com.allcom.domain.HourlyRate;
import com.allcom.domain.repository.HourlyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HourlyRateService {
    @Autowired
    private HourlyRateRepository hourlyRateRepository;

    public Optional<List<HourlyRate>> getByUser(String userNameId){
        return hourlyRateRepository.getByUser(userNameId);
    }
}

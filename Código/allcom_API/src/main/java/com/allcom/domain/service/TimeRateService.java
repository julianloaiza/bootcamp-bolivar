package com.allcom.domain.service;

import com.allcom.domain.TimeRate;
import com.allcom.domain.repository.TimeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeRateService {
    @Autowired
    private TimeRateRepository timeRateRepository;

    public Optional<List<TimeRate>> getByUser(String userNameId){
        return timeRateRepository.getByUser(userNameId);
    }
}

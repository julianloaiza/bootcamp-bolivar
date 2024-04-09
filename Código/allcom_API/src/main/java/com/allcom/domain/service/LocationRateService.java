package com.allcom.domain.service;

import com.allcom.domain.LocationRate;
import com.allcom.domain.repository.LocationRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationRateService {
    @Autowired
    private LocationRateRepository locationRateRepository;

    public Optional<List<LocationRate>> getByUser(String userNameId){
        return locationRateRepository.getByUser(userNameId);
    }
}

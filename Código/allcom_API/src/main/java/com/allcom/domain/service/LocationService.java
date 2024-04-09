package com.allcom.domain.service;

import com.allcom.domain.Facture;
import com.allcom.domain.Location;
import com.allcom.domain.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAll(){
        return locationRepository.getAll();
    }
}

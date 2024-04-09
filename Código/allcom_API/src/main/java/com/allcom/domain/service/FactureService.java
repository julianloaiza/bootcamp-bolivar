package com.allcom.domain.service;

import com.allcom.domain.Facture;
import com.allcom.domain.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    @Autowired
    private FactureRepository factureRepository;

    public List<Facture> getAll(){
        return factureRepository.getAll();
    }

    public Optional<Facture> getById(int factureId){
        return factureRepository.getById(factureId);
    }

    public List<Facture> getByUser(String userId){
        return factureRepository.getByUser(userId);
    }

    public Facture save(Facture facture){
        return factureRepository.save(facture);
    }

    public boolean delete(int factureId) {
        try {
            factureRepository.delete(factureId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}

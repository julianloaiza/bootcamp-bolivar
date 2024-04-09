package com.allcom.domain.repository;

import com.allcom.domain.Facture;
import com.allcom.persistence.entity.Factura;

import java.util.List;
import java.util.Optional;

public interface FactureRepository {
    List<Facture> getAll();
    Optional<Facture> getById(int factureId);
    List<Facture> getByUser(String userId);
    Facture save(Facture facture);
    void delete(int factureId);
}

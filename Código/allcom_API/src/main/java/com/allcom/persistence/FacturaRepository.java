package com.allcom.persistence;

import com.allcom.domain.Facture;
import com.allcom.domain.repository.FactureRepository;
import com.allcom.persistence.crud.FacturaCrudRepository;
import com.allcom.persistence.entity.Factura;
import com.allcom.persistence.mapper.FactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class FacturaRepository implements FactureRepository {
    @Autowired
    private FacturaCrudRepository facturaCrudRepository;
    @Autowired
    private FactureMapper mapper;

    @Override
    public List<Facture> getAll() {
        List<Factura> facturas = (List<Factura>) facturaCrudRepository.findAll();
        return mapper.toFactures(facturas);
    }

    @Override
    public Optional<Facture> getById(int factureId){
        return facturaCrudRepository.findById(factureId).map(factura -> mapper.toFacture(factura));
    }

    @Override
    public List<Facture> getByUser(String userId) {
        List<Factura> facturas = (List<Factura>) facturaCrudRepository.findByIdUsuarioNombre(userId);
        return mapper.toFactures(facturas);
    }

    @Override
    public Facture save(Facture facture) {
        Factura factura = mapper.toFactura(facture);
        return mapper.toFacture(facturaCrudRepository.save(factura));
    }

    @Override
    public void delete(int factureId) {
        facturaCrudRepository.deleteById(factureId);
    }
}

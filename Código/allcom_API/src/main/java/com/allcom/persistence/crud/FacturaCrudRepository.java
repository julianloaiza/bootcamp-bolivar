package com.allcom.persistence.crud;

import com.allcom.persistence.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacturaCrudRepository extends CrudRepository<Factura, Integer> {
    List<Factura> findByIdUsuarioNombre(String idUsuarioNombre);
}

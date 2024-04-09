package com.allcom.persistence.crud;

import com.allcom.persistence.entity.Factura;
import com.allcom.persistence.entity.Solicitud;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SolicitudCrudRepository extends CrudRepository<Solicitud, Integer> {
    @Query(value = "Select s from Solicitud s ORDER BY s.estado DESC")
    List<Solicitud> findAll();

    //Procedimientos llamados con jpql para traer los registros de forma ordenada.

    @Query("Select s from Solicitud s WHERE s.idUsuarioNombre = :id ORDER BY s.estado DESC")
    Optional<List<Solicitud>> findByIdUsuarioNombre(@Param(value = "id") String id);
}
package com.allcom.persistence.mapper;

import com.allcom.domain.Facture;
import com.allcom.persistence.entity.Factura;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactureMapper {
    @Mappings({
            @Mapping(source = "idFactura", target = "factureId"),
            @Mapping(source = "idUsuarioNombre", target = "userNameId"),
            @Mapping(source = "idReporteFecha", target = "dateReportId"),
            @Mapping(source = "monto", target = "amount"),
    })
    Facture toFacture(Factura factura);
    List<Facture> toFactures(List<Factura> facturas);

    @InheritInverseConfiguration
    @Mapping(target = "solicitudes", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Factura toFactura(Facture facture);
}

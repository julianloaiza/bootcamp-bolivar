package com.allcom.persistence.mapper;

import com.allcom.domain.Request;
import com.allcom.persistence.entity.Solicitud;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    @Mappings({
            @Mapping(source = "idSolicitud", target = "requestId"),
            @Mapping(source = "idUsuarioNombre", target = "userNameId"),
            @Mapping(source = "idFactura", target = "factureId"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Request toRequest(Solicitud solicitud);
    List<Request> toRequests(List<Solicitud> solicitudes);

    @InheritInverseConfiguration
    @Mapping(target = "factura", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Solicitud toSolicitud(Request request);
}

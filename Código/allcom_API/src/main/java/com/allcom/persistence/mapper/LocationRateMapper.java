package com.allcom.persistence.mapper;

import com.allcom.domain.LocationRate;
import com.allcom.persistence.entity.TarifaUbicacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationRateMapper {
    @Mappings({
            @Mapping(source = "idTarifaUbicacion", target = "locationRateId"),
            @Mapping(source = "idUsuarioNombre", target = "userNameId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precio", target = "price"),
    })
    LocationRate toLocationRate(TarifaUbicacion tarifaUbicacion);
    List<LocationRate> toLocationsRate(List<TarifaUbicacion> tarifaUbicaciones);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true)
    TarifaUbicacion toTarifaUbicacion(LocationRate locationRate);
}

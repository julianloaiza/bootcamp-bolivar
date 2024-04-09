package com.allcom.persistence.mapper;

import com.allcom.domain.Location;
import com.allcom.persistence.entity.Ubicacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    @Mappings({
            @Mapping(source = "idUbicacion", target = "locationId"),
            @Mapping(source = "idReporteFecha", target = "dateReportId"),
            @Mapping(source = "ubicacionNombre", target = "locationName"),
            @Mapping(source = "facturado", target = "amount"),
    })
    Location toLocation(Ubicacion ubicacion);
    List<Location> toLocations(List<Ubicacion> ubicaciones);

    @InheritInverseConfiguration
    Ubicacion toUbicacion(Location location);
}

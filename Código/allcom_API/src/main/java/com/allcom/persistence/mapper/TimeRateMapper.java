package com.allcom.persistence.mapper;

import com.allcom.domain.TimeRate;
import com.allcom.persistence.entity.TarifaTiempo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeRateMapper {

    @Mappings({
            @Mapping(source = "idTarifaTiempo", target = "timeRateId"),
            @Mapping(source = "idUsuarioNombre", target = "userNameId"),
            @Mapping(source = "tiempoInicio", target = "timeStart"),
            @Mapping(source = "tiempoFin", target = "timeEnd"),
            @Mapping(source = "precio", target = "price"),
    })
    TimeRate toTimeRate(TarifaTiempo tarifaTiempo);
    List<TimeRate> toTimesRate(List<TarifaTiempo> tarifaTiempos);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true)
    TarifaTiempo toTarifaTiempo(TimeRate timeRate);
}

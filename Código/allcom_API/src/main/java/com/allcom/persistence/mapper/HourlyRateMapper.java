package com.allcom.persistence.mapper;

import com.allcom.domain.HourlyRate;
import com.allcom.persistence.entity.TarifaHorario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HourlyRateMapper {
    @Mappings({
            @Mapping(source = "idTarifaHorario", target = "hourlyRateId"),
            @Mapping(source = "idUsuarioNombre", target = "userNameId"),
            @Mapping(source = "horaInicio", target = "hourlyStart"),
            @Mapping(source = "horaFin", target = "hourlyEnd"),
            @Mapping(source = "precio", target = "price"),
    })
    HourlyRate toHourlyRate(TarifaHorario tarifaHorario);
    List<HourlyRate> toHourliesRate(List<TarifaHorario> tarifaHorarios);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true)
    TarifaHorario toTarifaHorario(HourlyRate hourlyRate);
}

package com.allcom.persistence.mapper;

import com.allcom.domain.CharacterRate;
import com.allcom.persistence.entity.TarifaCaracter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterRateMapper {
    @Mappings({
            @Mapping(source = "idTarifaCaracter", target = "characterRateId"),
            @Mapping(source = "idUsuarioNombre", target = "userNameId"),
            @Mapping(source = "caracteresInicio", target = "charactersStart"),
            @Mapping(source = "caracteresFin", target = "charactersEnd"),
            @Mapping(source = "precio", target = "price"),
    })
    CharacterRate toCharacterRate(TarifaCaracter tarifaCaracter);
    List<CharacterRate> toCharactersRate(List<TarifaCaracter> tarifaCaracteres);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true)
    TarifaCaracter toTarifaCaracter(CharacterRate characterRate);
}
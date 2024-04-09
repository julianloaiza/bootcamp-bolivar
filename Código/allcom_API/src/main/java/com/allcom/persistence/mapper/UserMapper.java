package com.allcom.persistence.mapper;

import com.allcom.domain.User;
import com.allcom.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
        @Mapping(source = "idUsuarioNombre", target = "userNameId"),
        @Mapping(source = "idRolNombre", target = "rolNameId"),
        @Mapping(source = "contrasenia", target = "password")
    })
    User toUser(Usuario usuario);

    @InheritInverseConfiguration
    @Mapping(target = "solicitudes", ignore = true)
    @Mapping(target = "facturas", ignore = true)
    @Mapping(target = "tarifaHorarios", ignore = true)
    @Mapping(target = "tarifaCaracteres", ignore = true)
    @Mapping(target = "tarifaTiempos", ignore = true)
    @Mapping(target = "tarifaUbicaciones", ignore = true)
    Usuario toUsuario(User user);
}

package com.allcom.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LW_USUARIOS")
@Getter @Setter
public class Usuario {

    @Id
    @Column(name = "id_usuario_nombre")
    private String idUsuarioNombre;

    @Column(name = "id_rol_nombre")
    private String idRolNombre;

    private String contrasenia;

    @OneToMany(mappedBy = "usuario")
    private List<Solicitud> solicitudes;

    @OneToMany(mappedBy = "usuario")
    private List<Factura> facturas;

    @OneToMany(mappedBy = "usuario")
    private List<TarifaHorario> tarifaHorarios;

    @OneToMany(mappedBy = "usuario")
    private List<TarifaHorario> tarifaCaracteres;

    @OneToMany(mappedBy = "usuario")
    private List<TarifaHorario> tarifaTiempos;

    @OneToMany(mappedBy = "usuario")
    private List<TarifaHorario> tarifaUbicaciones;

}

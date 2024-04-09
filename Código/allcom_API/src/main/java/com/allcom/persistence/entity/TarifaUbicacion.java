package com.allcom.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LW_TARIFAUBICACIONES")
@Getter @Setter
public class TarifaUbicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarifaubicacion")
    private Integer idTarifaUbicacion;

    @Column(name = "id_usuario_nombre")
    private String idUsuarioNombre;

    private String nombre;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_nombre", insertable = false, updatable = false)
    private Usuario usuario;
}

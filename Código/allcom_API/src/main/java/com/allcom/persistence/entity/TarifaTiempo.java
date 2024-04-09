package com.allcom.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LW_TARIFATIEMPOS")
@Getter @Setter
public class TarifaTiempo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarifatiempo")
    private Integer idTarifaTiempo;

    @Column(name = "id_usuario_nombre")
    private String idUsuarioNombre;

    @Column(name = "tiempo_inicio")
    private Double tiempoInicio;

    @Column(name = "tiempo_fin")
    private Double tiempoFin;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_nombre", insertable = false, updatable = false)
    private Usuario usuario;
}

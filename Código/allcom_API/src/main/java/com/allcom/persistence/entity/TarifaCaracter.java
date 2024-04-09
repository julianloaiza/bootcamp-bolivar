package com.allcom.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LW_TARIFACARACTERES")
@Getter @Setter
public class TarifaCaracter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarifacaracter")
    private Integer idTarifaCaracter;

    @Column(name = "id_usuario_nombre")
    private String idUsuarioNombre;

    @Column(name = "caracteres_inicio")
    private Integer caracteresInicio;

    @Column(name = "caracteres_fin")
    private Integer caracteresFin;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_nombre", insertable = false, updatable = false)
    private Usuario usuario;
}

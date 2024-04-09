package com.allcom.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LW_TARIFAHORARIOS")
@Getter @Setter
public class TarifaHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarifahorario")
    private Integer idTarifaHorario;

    @Column(name = "id_usuario_nombre")
    private String idUsuarioNombre;

    @Column(name = "hora_inicio")
    private LocalDateTime horaInicio;

    @Column(name = "hora_fin")
    private LocalDateTime horaFin;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_nombre", insertable = false, updatable = false)
    private Usuario usuario;
}

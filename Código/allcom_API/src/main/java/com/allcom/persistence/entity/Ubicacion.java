package com.allcom.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LW_UBICACIONES")
@Getter @Setter
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer idUbicacion;

    @Column(name = "id_reporte_fecha")
    private LocalDateTime idReporteFecha;

    @Column(name = "ubicacion_nombre")
    private String ubicacionNombre;

    private Double facturado;
}

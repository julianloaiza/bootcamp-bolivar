package com.allcom.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "LW_FACTURAS")
@Getter @Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "id_usuario_nombre")
    private String idUsuarioNombre;

    @Column(name = "id_reporte_fecha")
    private LocalDateTime idReporteFecha;

    private Double monto;

    @OneToMany(mappedBy = "factura")
    private List<Solicitud> solicitudes;
    @ManyToOne
    @JoinColumn(name = "id_usuario_nombre", insertable = false, updatable = false)
    private Usuario usuario;

}

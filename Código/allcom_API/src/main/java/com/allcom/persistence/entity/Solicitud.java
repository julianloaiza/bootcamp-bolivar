package com.allcom.persistence.entity;

import com.allcom.domain.Facture;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LW_SOLICITUDES")
@Getter @Setter
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @Column(name = "id_usuario_nombre")
    private String idUsuarioNombre;

    @Column(name = "id_factura")
    private Integer idFactura;

    private char estado;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_factura", insertable = false, updatable = false)
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "id_usuario_nombre", insertable = false, updatable = false)
    private Usuario usuario;
}

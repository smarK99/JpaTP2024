package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int numero;
    @Column
    private int total;
    @Column
    private String fecha;

    @OneToMany
    @Column
    @JoinColumn(name = "fk_detallefactura")
    private ArrayList<DetalleFactura>detalleFacturas = new ArrayList<>();
}

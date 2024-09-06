package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Column
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    //Se eliminan todos los detalles a la hora de borrar una factura
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura>detallesFactura = new ArrayList<>();
}

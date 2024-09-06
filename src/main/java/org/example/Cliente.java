package org.example;

import lombok.*;
import org.hibernate.annotations.Cascade;

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
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    @Column
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany
    @Column
    @JoinColumn(name = "fk_facturas")
    private ArrayList<Factura>facturaList = new ArrayList<>();

}

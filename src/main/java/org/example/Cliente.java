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

    //En caso de querer bidireccionalidad con factura
    /*
    @OneToMany(mappedBy="cliente")//referencia al objeto dentro de factura
    private List<Factura>facturaList = new ArrayList<>();
     */
}

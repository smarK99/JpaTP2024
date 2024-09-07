package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nombreCalle;
    @Column
    int numero;

    /*Si quisieramos hacer bidireccional la relacion con cliente
    * Agregar mappedBy
    * (Esta bidireccionalidad no se va a ver reflejada en la bdd por que no hay relaciones de este tipo)
    * (para lo unico que sirve la bidireccionalidad es para el codigo java y poder acceder desde ambas clases)
    * @OneToOne(mappedBy = "domicilio")
    * private Cliente cliente;
    *
    * */


}

package org.example;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "domicilio")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombreCalle;
    int numero;
}

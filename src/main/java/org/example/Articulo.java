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
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int cantidad;
    int precio;
    String denominacion;

}

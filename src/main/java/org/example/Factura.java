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
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int numero;
    int total;
    String fecha;
}

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
@Table(name = "articulo")
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int cantidad;
    @Column
    private int precio;
    @Column
    private String denominacion;

    @ManyToMany
    @Column
    @JoinColumn(name = "fk_categorias")
    private ArrayList<Categoria>categorias = new ArrayList<>();

}

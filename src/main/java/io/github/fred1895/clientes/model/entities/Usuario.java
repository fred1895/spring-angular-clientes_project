package io.github.fred1895.clientes.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Campo login é obrigatório")
    private String username;

    @NotEmpty(message = "Campo senha é obrigatório")
    private String password;
}

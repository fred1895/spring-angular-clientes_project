package io.github.fred1895.clientes.model.services.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "O campo descrição é obrigatório")
    private String descricao;

    @NotEmpty(message = "O campo preço é obrigatório")
    private String preco;

    @NotEmpty(message = "O campo data é obrigatório")
    private String data;

    @NotNull(message = "O campo cliente é obrigatório")
    private Long idCliente;

}

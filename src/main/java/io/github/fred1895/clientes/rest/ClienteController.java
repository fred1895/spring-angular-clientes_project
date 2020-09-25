package io.github.fred1895.clientes.rest;

import io.github.fred1895.clientes.model.entities.Cliente;
import io.github.fred1895.clientes.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

}

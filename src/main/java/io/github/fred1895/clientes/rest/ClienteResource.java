package io.github.fred1895.clientes.rest;

import io.github.fred1895.clientes.model.entities.Cliente;
import io.github.fred1895.clientes.model.repositories.ClienteRepository;
import io.github.fred1895.clientes.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return service.salvar(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId (@PathVariable Long id) {
        return service.acharPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody @Valid  Cliente cliente) {
        service.atualizar(id, cliente);
    }

}

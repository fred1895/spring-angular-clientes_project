package io.github.fred1895.clientes.rest;

import io.github.fred1895.clientes.model.entities.Usuario;
import io.github.fred1895.clientes.model.services.UsuarioService;
import io.github.fred1895.clientes.rest.exceptions.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
        try {
            service.salvar(usuario);

        } catch (UsuarioCadastradoException e) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

}

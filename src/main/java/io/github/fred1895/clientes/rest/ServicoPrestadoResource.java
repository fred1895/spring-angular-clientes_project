package io.github.fred1895.clientes.rest;

import io.github.fred1895.clientes.model.entities.ServicoPrestado;
import io.github.fred1895.clientes.model.services.ServicoPrestadoService;
import io.github.fred1895.clientes.model.services.dto.ServicoPrestadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoResource {

    @Autowired
    private ServicoPrestadoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO obj) {
        return service.salvar(obj);
    }
}

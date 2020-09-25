package io.github.fred1895.clientes.model.services;

import io.github.fred1895.clientes.model.entities.Cliente;
import io.github.fred1895.clientes.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente acharPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletar(Long id) {
        repository.findById(id)
                .map( cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void atualizar(Long id, Cliente clienteAtualizado) {
        repository.findById(id)
                .map(cliente -> {
                    cliente.setCpf(clienteAtualizado.getCpf());
                    cliente.setNome(clienteAtualizado.getNome());
                    return repository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

}

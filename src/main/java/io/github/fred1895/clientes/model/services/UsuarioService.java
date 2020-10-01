package io.github.fred1895.clientes.model.services;

import io.github.fred1895.clientes.model.entities.Usuario;
import io.github.fred1895.clientes.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

     public void salvar(Usuario usuario) {
         repository.save(usuario);
     }

}

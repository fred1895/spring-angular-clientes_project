package io.github.fred1895.clientes.model.services;

import io.github.fred1895.clientes.model.entities.Usuario;
import io.github.fred1895.clientes.model.repositories.UsuarioRepository;
import io.github.fred1895.clientes.rest.exceptions.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

     public void salvar(Usuario usuario) {
         boolean exists = repository.existsByUsername(usuario.getUsername());
         if (exists) {
             throw new UsuarioCadastradoException(usuario.getUsername());
         }
         repository.save(usuario);
     }



}

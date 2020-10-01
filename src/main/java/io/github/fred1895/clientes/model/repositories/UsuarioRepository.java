package io.github.fred1895.clientes.model.repositories;

import io.github.fred1895.clientes.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

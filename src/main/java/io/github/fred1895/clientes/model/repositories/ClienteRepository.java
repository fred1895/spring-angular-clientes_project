package io.github.fred1895.clientes.model.repositories;

import io.github.fred1895.clientes.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

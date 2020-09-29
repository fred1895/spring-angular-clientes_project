package io.github.fred1895.clientes.model.services;

import io.github.fred1895.clientes.model.entities.Cliente;
import io.github.fred1895.clientes.model.entities.ServicoPrestado;
import io.github.fred1895.clientes.model.repositories.ClienteRepository;
import io.github.fred1895.clientes.model.repositories.ServicoPrestadoRepository;
import io.github.fred1895.clientes.model.services.dto.ServicoPrestadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ServicoPrestadoService {
    @Autowired
    private ServicoPrestadoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ServicoPrestado salvar(ServicoPrestadoDTO obj) {
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        LocalDate date = LocalDate.parse(obj.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        servicoPrestado.setDescricao(obj.getDescricao());
        servicoPrestado.setData(date);
        Long idCliente = obj.getIdCliente();
        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não existe."));
        servicoPrestado.setCliente(cliente);
        BigDecimal valor = converter(obj.getPreco());
        servicoPrestado.setValor(valor);

        return repository.save(servicoPrestado);
    }

    private BigDecimal converter(String preco) {
        if (preco == null) return null;

        preco = preco.replace(".", "").replace(",", ".");
        return new BigDecimal(preco);
    }
}

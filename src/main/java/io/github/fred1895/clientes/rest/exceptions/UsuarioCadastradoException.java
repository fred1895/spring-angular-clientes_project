package io.github.fred1895.clientes.rest.exceptions;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException(String login) {
        super("Usuario já cadastrado para o login " + login);
    }
}

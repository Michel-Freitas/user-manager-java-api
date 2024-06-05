package com.usermanager.api.module.user.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) { super(message); }
    public UserNotFoundException() { super("Usuário Não Encontrado."); }
}

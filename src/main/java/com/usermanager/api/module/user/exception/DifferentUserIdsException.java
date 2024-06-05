package com.usermanager.api.module.user.exception;

public class DifferentUserIdsException extends RuntimeException{
    public DifferentUserIdsException(String message) { super(message); }
    public DifferentUserIdsException() { super("Id passado na URL está diferente do Corpo da Requisição."); }
}

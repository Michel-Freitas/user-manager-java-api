package com.usermanager.api.module.user.exception;

public class CpfAlreadyUsedException extends RuntimeException{
    public CpfAlreadyUsedException(String message) { super(message); }
    public CpfAlreadyUsedException() { super("CPF já está em uso."); }
}

package br.com.joaocarlos.gestao_de_vagas.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("Usuário ja exister");
    } 
}

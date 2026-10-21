package br.com.fitlife.exception;

/**
 * Lançada quando um treino é criado ou adicionado com dados inválidos.
 */
public class TreinoInvalidoException extends RuntimeException {

    public TreinoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

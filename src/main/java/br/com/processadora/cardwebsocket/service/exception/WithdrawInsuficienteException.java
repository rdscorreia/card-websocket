/**
 * 
 */
package br.com.processadora.cardwebsocket.service.exception;

/**
 * @author ricardoc
 *
 */
public class WithdrawInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WithdrawInsuficienteException(String amount) {
		super(amount);
	}

	public WithdrawInsuficienteException(String msg, Throwable cause) {
		super(msg, cause);
	}

}

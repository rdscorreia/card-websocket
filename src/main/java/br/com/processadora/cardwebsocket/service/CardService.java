package br.com.processadora.cardwebsocket.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.processadora.cardwebsocket.domain.Card;
import br.com.processadora.cardwebsocket.domain.Transaction;
import br.com.processadora.cardwebsocket.domain.enums.TransactionEnum;
import br.com.processadora.cardwebsocket.model.request.WithdrawRequest;
import br.com.processadora.cardwebsocket.model.response.TransactionResponse;
import br.com.processadora.cardwebsocket.repositories.CardRepository;
import br.com.processadora.cardwebsocket.repositories.TransactionRepository;
import br.com.processadora.cardwebsocket.service.exception.ObjectNotFoundException;
import br.com.processadora.cardwebsocket.service.exception.WithdrawInsuficienteException;

/**
 * @author ricardoc
 *
 */
@Service
public class CardService {

	private static final int AUTH_CODE_LENGTH = 6;

	private static final String WITHDRAW = "withdraw";

	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	public Card find(String cardNumber) {
		Optional<Card> obj = cardRepository.findById(cardNumber);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + cardNumber + ", Tipo: " + Card.class.getName()));
	}

	public TransactionResponse withdraw(WithdrawRequest request) {

		try {
			Optional<Card> card = cardRepository.findById(request.getCardnumber());
			if (card.isPresent()) {
				card.get().withdraw(request.getAmount());
				
				Transaction transaction = new Transaction();
				transaction.setCard(card.get());
				transaction.setDate(LocalDateTime.now());
				transaction.setAmount(request.getAmount());
				
				transactionRepository.save(transaction);
				cardRepository.save(card.get());
				
				return new TransactionResponse(WITHDRAW, TransactionEnum.APROVADA.getCodigo(),
						RandomStringUtils.randomNumeric(AUTH_CODE_LENGTH));
			} else {
				return new TransactionResponse(WITHDRAW, TransactionEnum.CONTA_INVALIDA.getCodigo(),
						RandomStringUtils.randomNumeric(AUTH_CODE_LENGTH));
			}
		} catch (WithdrawInsuficienteException exception) {
			return new TransactionResponse(WITHDRAW, TransactionEnum.SALDO_INSUFICIENTE.getCodigo(),
					RandomStringUtils.randomNumeric(AUTH_CODE_LENGTH));
		} catch (IllegalArgumentException exception) {
			return new TransactionResponse(WITHDRAW, TransactionEnum.ERRO_PROCESSAMENTO.getCodigo(),
					RandomStringUtils.randomNumeric(AUTH_CODE_LENGTH));
		}
	}
}

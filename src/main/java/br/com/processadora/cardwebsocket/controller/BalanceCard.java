/**
 * 
 */
package br.com.processadora.cardwebsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.processadora.cardwebsocket.controller.constants.RecursoConstants;
import br.com.processadora.cardwebsocket.domain.Card;
import br.com.processadora.cardwebsocket.service.CardService;

/**
 * @author ricardoc
 *
 */
@RestController
@RequestMapping(value = RecursoConstants.URL_BALANCE_POR_CARD_NUMBER)
public class BalanceCard {

	@Autowired
	CardService cardService;

	/**
	 * 
	 * @param cardNumber
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> find(@PathVariable("card_number") String cardNumber) {
		Card obj = cardService.find(cardNumber);
		return ResponseEntity.ok().body(obj);
	}

}

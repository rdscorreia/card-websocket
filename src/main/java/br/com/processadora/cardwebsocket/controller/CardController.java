package br.com.processadora.cardwebsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
//import org.springframework.web.util.HtmlUtils;

import br.com.processadora.cardwebsocket.model.request.WithdrawRequest;
import br.com.processadora.cardwebsocket.model.response.TransactionResponse;
import br.com.processadora.cardwebsocket.service.CardService;

/**
 * 
 * @author ricardo
 *
 */
@Controller
public class CardController {
	
	@Autowired
	CardService cardService;

	@MessageMapping("/withdraw")
	@SendTo("/withdraw/response")
	public TransactionResponse withdraw(WithdrawRequest request) throws Exception {
		Thread.sleep(1000); // simulated delay
		System.out.println(request.toString());
		
		cardService.withdraw(request);
		
		
		return new TransactionResponse(request.getCardnumber(), null, null);
	}

}

package br.com.processadora.cardwebsocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import br.com.processadora.cardwebsocket.model.request.WithdrawRequest;
import br.com.processadora.cardwebsocket.model.response.TransactionResponse;

/**
 * 
 * @author ricardo
 *
 */
@Controller
public class CardController {

	@MessageMapping("/withdraw")
	@SendTo("/withdraw/response")
	public TransactionResponse withdraw(WithdrawRequest request) throws Exception {
		Thread.sleep(1000); // simulated delay
		System.out.println(request.toString());
		
		return new TransactionResponse(request.getCardnumber(), null, null);
	}

}

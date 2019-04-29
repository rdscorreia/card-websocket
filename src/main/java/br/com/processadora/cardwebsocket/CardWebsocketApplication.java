package br.com.processadora.cardwebsocket;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.processadora.cardwebsocket.domain.Card;
import br.com.processadora.cardwebsocket.repositories.CardRepository;

@SpringBootApplication
public class CardWebsocketApplication implements CommandLineRunner {

	@Autowired
	private CardRepository cardRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardWebsocketApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Card cardOne = new Card("1234567890123456", 1000);
		Card cardTwo = new Card("1234567890123457", 1000);

		cardRepository.saveAll(Arrays.asList(cardOne, cardTwo));

	}
}

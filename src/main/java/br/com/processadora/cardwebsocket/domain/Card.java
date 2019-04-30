package br.com.processadora.cardwebsocket.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import br.com.processadora.cardwebsocket.domain.enums.TransactionEnum;
import br.com.processadora.cardwebsocket.service.exception.WithdrawInsuficienteException;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({ "cardNumber", "availableAmount", "transactions" })
@Entity
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String cardNumber;
	private double availableAmount;

	@JsonManagedReference
	@OneToMany(mappedBy = "card")
	private List<Transaction> transactions = new ArrayList<>();

	/**
	 * 
	 */
	public Card() {
	}

	/**
	 * @param cardnumber
	 * @param availableAmount
	 * @param transactions
	 */
	public Card(String cardnumber, double availableAmount) {
		this.cardNumber = cardnumber;
		this.availableAmount = availableAmount;
	}

	/**
	 * @return the cardnumber
	 */
	public String getCardnumber() {
		return cardNumber;
	}

	/**
	 * @param cardnumber the cardnumber to set
	 */
	public void setCardnumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the availableAmount
	 */
	public double getAvailableAmount() {
		return availableAmount;
	}

	/**
	 * @param availableAmount the availableAmount to set
	 */
	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}

	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * 
	 * @param valor
	 * @throws WithdrawInsuficienteException
	 */
	public void withdraw(double amount) throws WithdrawInsuficienteException {
		if (amount < 0) {
			throw new IllegalArgumentException("Você tentou sacar" + amount + " um valor negativo");
		} else if (this.availableAmount < amount) {
			throw new WithdrawInsuficienteException(TransactionEnum.SALDO_INSUFICIENTE.getCodigo());
		}
		this.availableAmount -= amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [cardnumber=");
		builder.append(cardNumber);
		builder.append(", availableAmount=");
		builder.append(availableAmount);
		builder.append(", transactions=");
		builder.append(transactions);
		builder.append("]");
		return builder.toString();
	}

}

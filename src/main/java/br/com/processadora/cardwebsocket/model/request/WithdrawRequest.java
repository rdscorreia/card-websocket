package br.com.processadora.cardwebsocket.model.request;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class WithdrawRequest {

	private String action;
	private String cardnumber;
	private double amount;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("action", action).append("cardnumber", cardnumber)
				.append("amount", amount).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(amount).append(action).append(cardnumber).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof WithdrawRequest) == false) {
			return false;
		}
		WithdrawRequest rhs = ((WithdrawRequest) other);
		return new EqualsBuilder().append(amount, rhs.amount).append(action, rhs.action)
				.append(cardnumber, rhs.cardnumber).isEquals();
	}

}
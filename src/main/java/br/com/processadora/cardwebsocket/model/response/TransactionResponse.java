
package br.com.processadora.cardwebsocket.model.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TransactionResponse {

	private String action;
	private String code;
	private String authorizationCode;

	public TransactionResponse(String action, String code, String authorizationCode) {
		this.action = action;
		this.code = code;
		this.authorizationCode = authorizationCode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("action", action).append("code", code)
				.append("authorizationCode", authorizationCode).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(action).append(code).append(authorizationCode).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof TransactionResponse) == false) {
			return false;
		}
		TransactionResponse rhs = ((TransactionResponse) other);
		return new EqualsBuilder().append(action, rhs.action).append(code, rhs.code)
				.append(authorizationCode, rhs.authorizationCode).isEquals();
	}

}
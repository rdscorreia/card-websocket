package br.com.processadora.cardwebsocket.domain.enums;

/**
 * @author ricardoc
 *
 */
public enum TransactionEnum {
	APROVADA("00", "aprovada"), 
	SALDO_INSUFICIENTE("51", "saldo insuficiente"), 
	CONTA_INVALIDA("14", "conta inválida"),
	ERRO_PROCESSAMENTO("96", "erro de processamento");

	private String codigo;
	private String descricao;

	private TransactionEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TransactionEnum toEnum(String cod) {

		if (cod == null) {
			return null;
		}

		for (TransactionEnum x : TransactionEnum.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}

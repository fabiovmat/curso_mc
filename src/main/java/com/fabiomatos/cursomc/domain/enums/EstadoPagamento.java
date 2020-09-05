package com.fabiomatos.cursomc.domain.enums;

public enum EstadoPagamento {
	
	
	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private int cod;
	private String descPagamento;
	
	private EstadoPagamento(int cod, String descPagamento) {
		this.cod = cod;
		this.descPagamento = descPagamento;
	}
	
	public int getCod() {
		return cod;
	}

		
	public String getDescPagamento() {
		return descPagamento;
	}

	public static EstadoPagamento toEnum(Integer cod) {
	
	if(cod == null) {
		return null;
	}
	
	for(EstadoPagamento x : EstadoPagamento.values()) {
		if (cod.equals(x.getCod())) {
			return x;
		}
		
		
		
	}
	
	throw new IllegalArgumentException("Id invalido:" + cod);
	
	
}
	

}

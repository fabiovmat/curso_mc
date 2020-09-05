package com.fabiomatos.cursomc.domain;

import javax.persistence.Entity;

import com.fabiomatos.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
public PagamentoComCartao() {
		
	}

public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeparcelas) { 
	super(id, estado, pedido);
	
	this.numeroDeParcelas = numeroDeparcelas;
	
}

public Integer getNumeroDeParcelas() {
	return numeroDeParcelas;
}

public void setNumeroDeParcelas(Integer numeroDeParcelas) {
	this.numeroDeParcelas = numeroDeParcelas;
}


}

package com.fabiomatos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiomatos.cursomc.domain.Pedido;
import com.fabiomatos.cursomc.repositories.PedidoRepository;
import com.fabiomatos.cursomc.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}
	
}

package com.fabiomatos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiomatos.cursomc.domain.Categoria;
import com.fabiomatos.cursomc.repositories.CatRepository;


@Service
public class CategoriaService {
	
	@Autowired
	private CatRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);		
	}
	
}
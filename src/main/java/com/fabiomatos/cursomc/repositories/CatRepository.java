package com.fabiomatos.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fabiomatos.cursomc.domain.Categoria;

public interface CatRepository extends CrudRepository<Categoria, Long>{

	Optional<Categoria> findById(Integer id);

}

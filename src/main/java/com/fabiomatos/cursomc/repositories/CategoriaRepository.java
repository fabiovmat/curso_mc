package com.fabiomatos.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabiomatos.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

	Optional<Categoria> findById(Integer id);

}

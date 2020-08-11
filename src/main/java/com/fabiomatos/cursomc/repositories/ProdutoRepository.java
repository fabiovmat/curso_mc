package com.fabiomatos.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabiomatos.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Optional<Produto> findById(Integer id);

}

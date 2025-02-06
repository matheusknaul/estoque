package com.matheusknaul.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusknaul.estoque.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}

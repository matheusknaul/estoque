package com.matheusknaul.estoque.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.matheusknaul.estoque.domain.Produto;
import com.matheusknaul.estoque.repository.ProdutoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class DBService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void instanciaDB(){
		Produto produto = new Produto(null, "Base Mary Kay", 3, 50.90, 70.90);
		
		produtoRepository.saveAll(Arrays.asList(produto));
	}
}

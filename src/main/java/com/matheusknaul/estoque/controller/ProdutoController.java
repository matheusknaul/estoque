package com.matheusknaul.estoque.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.matheusknaul.estoque.domain.Produto;
import com.matheusknaul.estoque.repository.ProdutoRepository;
import com.matheusknaul.estoque.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos(){
		return ResponseEntity.ok(produtoService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
		Produto novoProduto = produtoService.salvar(produto);
		return ResponseEntity.ok(novoProduto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produto){
		Produto produtoEditado = produtoService.atualizar(id, produto);
		return ResponseEntity.ok(produtoEditado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

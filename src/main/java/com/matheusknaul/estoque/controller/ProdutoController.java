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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Produto criarProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produtoAtualizado){
		return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidade(produtoAtualizado.getQuantidade());
            Produto atualizado = produtoRepository.save(produto);
            return ResponseEntity.ok(atualizado);
        }).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        return produtoRepository.findById(id).map(produto -> {
            produtoRepository.delete(produto);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

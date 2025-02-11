package com.matheusknaul.estoque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matheusknaul.estoque.domain.Produto;
import com.matheusknaul.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	public Produto buscarPorId(Integer id) {
		return produtoRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Produto não encontrado!"));
	}
	
	public Produto salvar(Produto produto) {
		if(produto.getPrecoVenda() < 1.0 || produto.getPrecoCompra() < 1.0) {
			throw new IllegalArgumentException("O preço de venda ou compra "
					+ "do produto deve ser maior ou igual a 1.");
		}
		
		return produtoRepository.save(produto);
	}
	
	public Produto atualizar(Integer id, Produto produto) {
		Produto produtoExistente = buscarPorId(id);
		produtoExistente.setDescricao(produto.getDescricao());
		produtoExistente.setPrecoCompra(produto.getPrecoCompra());
		produtoExistente.setPrecoVenda(produto.getPrecoVenda());
		produtoExistente.setQuantidade(produto.getQuantidade());
		
		return produtoRepository.save(produtoExistente);
	}
	
	public void deletar(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

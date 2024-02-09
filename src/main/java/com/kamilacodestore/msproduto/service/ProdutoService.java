package com.kamilacodestore.msproduto.service;


import com.kamilacodestore.msproduto.model.Produto;
import com.kamilacodestore.msproduto.repository.ProdutoRepository;
import com.kamilacodestore.msproduto.service.aws.SqsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Autowired
    private SqsProducer sqsProducer;

    public Produto salvar(Produto produto){
         return  produtoRepository.salvar(produto);

    }

    public void adicionarCarrinho(Produto produto){
        sqsProducer.adicionarCarrinho(produto);
    }

    public Produto buscarProdutoPeloId(String id){
        return  produtoRepository.buscarProdutoPeloId(id);

    }

    public List<Produto> listarProdutos(){
        return  produtoRepository.listarTodosOsProdutos();

    }

    public Produto atualizarProduto(String id, Produto produto){
        return produtoRepository.atualizarProduto(id, produto);
    }

    public void excluirProduto(String id){
        produtoRepository.excluirProduto(id);
    }

}

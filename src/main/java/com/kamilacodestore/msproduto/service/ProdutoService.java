package com.kamilacodestore.msproduto.service;


import com.kamilacodestore.msproduto.model.Produto;
import com.kamilacodestore.msproduto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto salvar(Produto produto){
         return  produtoRepository.salvar(produto);

    }

}

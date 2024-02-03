package com.kamilacodestore.msproduto.service;


import com.kamilacodestore.msproduto.model.Produto;
import com.kamilacodestore.msproduto.repository.ProdutoRepository;
import com.kamilacodestore.msproduto.service.aws.SqsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}

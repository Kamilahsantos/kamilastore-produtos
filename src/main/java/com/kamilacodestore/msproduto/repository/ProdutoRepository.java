package com.kamilacodestore.msproduto.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.kamilacodestore.msproduto.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {


    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Produto salvar(Produto produto) {
        dynamoDBMapper.save(produto);
        return produto;
    }
}

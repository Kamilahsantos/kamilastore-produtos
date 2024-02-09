package com.kamilacodestore.msproduto.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.kamilacodestore.msproduto.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {


    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Produto salvar(Produto produto) {
        dynamoDBMapper.save(produto);
        return produto;
    }

    public Produto buscarProdutoPeloId(String id){
        return  dynamoDBMapper.load(Produto.class, id);
    }

    public List<Produto> listarTodosOsProdutos(){

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        return dynamoDBMapper.scan(Produto.class, scanExpression);
    }

    public Produto atualizarProduto(String id, Produto produto){
        dynamoDBMapper.save(new Produto(
                id,
                produto.getPrice(),
                produto.getDescription(),
                produto.getQuantity()),
                new DynamoDBSaveExpression()
                        .withExpectedEntry("product_id",
                                new ExpectedAttributeValue(
                                        new AttributeValue()
                                                .withS(id)))
        );

        return produto;
    }


    public void excluirProduto(String id){
        dynamoDBMapper.delete(this.buscarProdutoPeloId(id));
    }
}

package com.kamilacodestore.msproduto.service.aws;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.InvalidMessageContentsException;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.kamilacodestore.msproduto.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqsProducer {

    @Autowired
    private  AmazonSQS amazonSQSClient;

    private final String adicionaCarrinho = "https://sqs.sa-east-1.amazonaws.com/771177158205/adiciona-carrinho";


    public SqsProducer() {
    }

    public void adicionarCarrinho(Produto produto) {
        try {
            amazonSQSClient.sendMessage(adicionaCarrinho, produto.getProduct_id() + produto.getDescription()+ produto.getPrice()+ produto.getQuantity());


        } catch (QueueDoesNotExistException | InvalidMessageContentsException e) {
            System.out.println("erro ao adiconar compra" + e);
        }
    }

}

package com.kamilacodestore.msproduto.service.aws;


import com.amazonaws.services.dynamodbv2.xspec.S;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service

public class SqsConsumer {

    @Autowired
    private AmazonSQS amazonSQSClient;

    private final String pedidoFinalizado = "https://sqs.sa-east-1.amazonaws.com/771177158205/pedido-finalizado";

    private final String pedidoEstornado = "https://sqs.sa-east-1.amazonaws.com/771177158205/pedido-estornado";


    public SqsConsumer() {
    }

    @Scheduled(fixedDelay = 2000)
    public void receberPedidoFinalizado() {
        try {
            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(pedidoFinalizado);
            if (!receiveMessageResult.getMessages().isEmpty()) {
                Message message = receiveMessageResult.getMessages().get(0);
                pedidoFinalizado(message.getBody());
                amazonSQSClient.deleteMessage(pedidoFinalizado, message.getReceiptHandle());
            }
        } catch (QueueDoesNotExistException e) {
            System.out.println("Fila não existe " + e.getMessage());
        }
    }

    private void pedidoFinalizado(String body) {
        System.out.println("Pedido finalizado, dados do pedido" + body);
    }


    @Scheduled(fixedDelay = 5000)
    public void receberPedidoEstornado() {
        try {
            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(pedidoEstornado);
            if (!receiveMessageResult.getMessages().isEmpty()) {
                Message message = receiveMessageResult.getMessages().get(0);
                pedidoFinalizado(message.getBody());
                amazonSQSClient.deleteMessage(pedidoEstornado, message.getReceiptHandle());
            }
        } catch (QueueDoesNotExistException e) {
            System.out.println("Fila não existe " + e.getMessage());
        }
    }

    private void pedidoEstornado(String body) {
        System.out.println("Pedido estornado, dados do pedido" + body);
    }

}

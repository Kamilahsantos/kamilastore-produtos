package com.kamilacodestore.msproduto;

import com.kamilacodestore.msproduto.model.Produto;

import java.util.UUID;

public class ProdutoMock {

    public static Produto mockProduto (){
        return  new Produto("a1804ec6-9deb-4fcb-9f51-abeef451001b",
                123.45,
                "PRODUTO",
                123);
    }
}

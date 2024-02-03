package com.kamilacodestore.msproduto.controller;


import com.kamilacodestore.msproduto.model.Produto;
import com.kamilacodestore.msproduto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProdutoService produtoService;



    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody Produto produto){
        return  produtoService.salvar(produto);
    }

    @PostMapping("/carrinho")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adicionarCarrinho(@RequestBody Produto produto){
          produtoService.adicionarCarrinho(produto);
    }

}

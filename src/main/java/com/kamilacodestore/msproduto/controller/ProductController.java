package com.kamilacodestore.msproduto.controller;


import com.kamilacodestore.msproduto.model.Produto;
import com.kamilacodestore.msproduto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Produto buscarProdutoPeloId(@PathVariable("id") String id){
        return produtoService.buscarProdutoPeloId(id);

    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarTodosOsProdutos(){
        return produtoService.listarProdutos();

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Produto atualizarProduto(@PathVariable("id") String id, @RequestBody Produto produto){
        return produtoService.atualizarProduto(id, produto);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void excluirProduto(@PathVariable("id") String id){
         produtoService.excluirProduto(id);

    }

}

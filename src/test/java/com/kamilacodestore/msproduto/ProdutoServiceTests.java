package com.kamilacodestore.msproduto;


import com.kamilacodestore.msproduto.model.Produto;
import com.kamilacodestore.msproduto.repository.ProdutoRepository;
import com.kamilacodestore.msproduto.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.kamilacodestore.msproduto.ProdutoMock.mockProduto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTests {


    @Mock
    private ProdutoRepository produtoRepository;


    @InjectMocks
    private ProdutoService produtoService;


    @Test
    @DisplayName("sucesso - deve cadastrar produto com sucesso")
    void deveSalvarProdutoNaBaseComSucesso()  {
        Produto produto = new Produto();
        produto.setQuantity(123);
        when(produtoRepository.salvar(ArgumentMatchers.any(Produto.class))).thenReturn(mockProduto());
        Produto created = produtoService.salvar(produto);
        assertThat(created.getQuantity()).isSameAs(produto.getQuantity());
        assertNotNull(created.getProduct_id());
        verify(produtoRepository).salvar(produto);


    }




    @Test
    @DisplayName("sucesso - deve listar os produtos com sucesso")
    void deveRetornarListaDeProdutosComSucesso() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto());
        given(produtoRepository.listarTodosOsProdutos()).willReturn(List.of(mockProduto()));
        List<Produto> expected = produtoService.listarProdutos();
        assertEquals(1, expected.size());
        verify(produtoRepository).listarTodosOsProdutos();

    }

    @Test
    @DisplayName("sucesso - deve buscar produto pelo id com sucesso")
    void deveBuscarProdutoPeloIdComSucesso()  {
        Produto produto = new Produto();
        produto.setProduct_id("a1804ec6-9deb-4fcb-9f51-abeef451001b");
        produto.setDescription("PRODUTO");
        produto.setPrice(123.45);
        produto.setQuantity(123);


        when(produtoRepository.buscarProdutoPeloId(produto.getProduct_id())).thenReturn(mockProduto());
        Produto expected = produtoService.buscarProdutoPeloId(produto.getProduct_id());
        assertThat(expected.getProduct_id()).isEqualTo(mockProduto().getProduct_id());
        assertThat(expected.getQuantity()).isEqualTo(mockProduto().getQuantity());
        assertThat(expected.getPrice()).isEqualTo(mockProduto().getPrice());
        assertThat(expected.getDescription()).isEqualTo(mockProduto().getDescription());
        verify(produtoRepository).buscarProdutoPeloId(produto.getProduct_id());

    }

    @Test
    @DisplayName("sucesso - deve atualizar produto pelo id com sucesso")
    void deveAtualizarProdutoPeloIdComSucesso()  {
        Produto produto = new Produto();
        produto.setProduct_id("a1804ec6-9deb-4fcb-9f51-abeef451001b");
        produto.setDescription("PRODUTO");
        produto.setPrice(123.45);
        produto.setQuantity(123);


        when(produtoRepository.atualizarProduto(produto.getProduct_id(),produto)).thenReturn(produto);
        Produto expected = produtoService.atualizarProduto(produto.getProduct_id(), produto);
        assertThat(expected.getProduct_id()).isEqualTo(mockProduto().getProduct_id());
        assertThat(expected.getQuantity()).isEqualTo(mockProduto().getQuantity());
        assertThat(expected.getPrice()).isEqualTo(mockProduto().getPrice());
        assertThat(expected.getDescription()).isEqualTo(mockProduto().getDescription());
        verify(produtoRepository).atualizarProduto(produto.getProduct_id(),produto);

    }


    @Test
    @DisplayName("sucesso - deve excluir produto pelo id com sucesso")
    void deveExcluirProdutoPeloIdComSucesso() {
        produtoService.excluirProduto(mockProduto().getProduct_id());

        verify(produtoRepository, times(1)).excluirProduto(mockProduto().getProduct_id());
    }

}
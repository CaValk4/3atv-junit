package com.junit3.junit3;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

public class StoreTest {
    
    private List<Item> listaDeItensValidos;

    @BeforeEach
    void setup() {
        listaDeItensValidos = Arrays.asList(
                new Item("Arroz", 7.20, 12),
                new Item("Feijão", 5.30, 25),
                new Item("Óleo", 3.50, 8),
                new Item("Macarrão", 2.80, 0),
                new Item("Carne", 19.99, 5),
                new Item("Água", 1.50, 50)
        );
    }

    @Nested
    class CalculoTotalTest {

        @Test
        void valorTotal() {
            assertEquals(45.79, StoreService.calcularTotalPedido(listaDeItensValidos, 0));
        }

        @Test
        void desconto() {
            assertEquals(41.211, StoreService.calcularTotalPedido(listaDeItensValidos, 10));
        }

        @Test
        void descontoNegativo() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.calcularTotalPedido(listaDeItensValidos, -3));
        }

        @Test
        void listaNula() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.calcularTotalPedido(null, 60));
        }

        @Test
        void listaVazia() {
            assertEquals(0.0, StoreService.calcularTotalPedido(Collections.emptyList(), 0));
        }
    }

    @Nested
    class ProdutosEstoqueTest {

        @Test
        void listaProdutos() {
            List<Item> listaEsperada = Arrays.asList(
                    new Item("Arroz", 7.20, 12),
                    new Item("Feijão", 5.30, 25),
                    new Item("Óleo", 3.50, 8),
                    new Item("Carne", 19.99, 5),
                    new Item("Água", 1.50, 50)
            );
            assertIterableEquals(listaEsperada, StoreService.filtrarProdutosEmEstoque(listaDeItensValidos));
        }

        @Test
        void listaNula() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.filtrarProdutosEmEstoque(null));
        }

        @Test
        void listaVazia() {
            assertEquals(Collections.emptyList(), StoreService.filtrarProdutosEmEstoque(Collections.emptyList()));
        }
    }

    @Nested
    class ValidacaoCupomTest {

        @Test
        void cupomValido() {
            assertTrue(StoreService.validarCupom("CUPOM-123"));
        }

        @Test
        void cupomInvalido() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.validarCupom("INVALIDO"));
        }
    }

    @Nested
    class OrdenacaoPrecoTest {

        @Test
        void precosOrdenados() {
            double[] precosEsperados = {19.99, 7.20, 5.30, 3.50, 1.50, 2.80};
            assertArrayEquals(precosEsperados, StoreService.ordenarPrecos(listaDeItensValidos));
        }

        @Test
        void argumentoNulo() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.ordenarPrecos(null));
        }

        @Test
        void arrayVazio() {
            double[] arrayVazio = {};
            assertArrayEquals(arrayVazio, StoreService.ordenarPrecos(Collections.emptyList()));
        }
    }

    @Nested
    class VerificacaoEstoqueTest {

        @Test
        void produtosEmEstoque() {
            String[] produtosEsperados = {"Arroz", "Feijão", "Macarrão", "Carne"};
            assertArrayEquals(produtosEsperados, StoreService.verificarEstoque(listaDeItensValidos, 10));
        }

        @Test
        void produtosMenores() {
            String[] produtosEsperados = {"Arroz", "Macarrão"};
            assertArrayEquals(produtosEsperados, StoreService.verificarEstoque(listaDeItensValidos, 5));
        }

        @Test
        void listaNula() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.verificarEstoque(null, 10));
        }

        @Test
        void listaVazia() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.verificarEstoque(Collections.emptyList(), 10));
        }

        @Test
        void limiteInvalido() {
            assertThrows(IllegalArgumentException.class, () -> StoreService.verificarEstoque(listaDeItensValidos, 0));
        }
    }
}

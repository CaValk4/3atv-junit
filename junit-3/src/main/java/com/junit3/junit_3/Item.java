package com.junit3.junit_3;

import java.util.Objects;

public class Item {
    private String nome;
    private int quantidadeEmEstoque;
    private double preco;

    public Item(String nome, int estoque, double preco) {
        this.preco = preco;
        this.nome = nome;
        this.quantidadeEmEstoque = estoque;
    }

    public void alterarPreco(double novoPreco) {
        this.preco = novoPreco;
    }
    public int getEstoque() {
        return this.quantidadeEmEstoque;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco, quantidadeEmEstoque);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.preco, preco) == 0 &&
                quantidadeEmEstoque == item.quantidadeEmEstoque &&
                Objects.equals(nome, item.nome);
    }

}

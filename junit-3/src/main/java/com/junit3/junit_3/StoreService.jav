package com.junit3.junit3;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;


public class StoreService{
    private List<Item> itensEstocados;
    
    public StoreService(List<Item> Itens){
        this.itensEstocados = products;
    }

    public StoreService(){
        this.itensEstocados = Collections.emptyList();
    }

    public Product getItem(){
        return this.itensEstocados.getLast();
    }

    public void setItem(Product newItem){
        this.itensEstocados.add(newItem);
    }

    public static double calcularTotal(List<Item> items, int desconto) {

        if (items == null) {
            throw new IllegalArgumentException("A função espera uma lista válida de itens");
        }
    
        if (desconto < 0 || desconto > 70) {
            throw new IllegalArgumentException("O desconto não pode ser menor que 0% ou maior que 70%");
        }
    
        if (items.isEmpty()) {
            return 0.0;
        }
    
        double total = items.stream().mapToDouble(Item::getPreco).sum();
    
        return total - (total / 100) * desconto;
    }
    
    public static List<Item> filtrarItensEmEstoque(List<Item> listaDeItens) {
        
        if (listaDeItens.isEmpty()) {
            return listaDeItens;
        }
    
        if (listaDeItens == null) {
            throw new IllegalArgumentException("A lista de itens não pode ser nula");
        }
    
        return listaDeItens.stream()
                .filter(item -> item.getEstoque() > 0)
                .collect(Collectors.toList());
    }
    
    public static boolean validarCupom(String cupom) {
    
        if (!cupom.startsWith("CUPOM-")) {
            throw new IllegalArgumentException("O cupom não corresponde ao padrão esperado");
        }
    
        if (cupom == null || cupom.length() != 7) {
            throw new IllegalArgumentException("O cupom não posssui caracteres suficientes");
        }
    
        return true;
    }
    
    public static double[] ordenarPrecosDecrescente(List<Item> listaDeItens) {
    
        if (listaDeItens == null) {
            throw new IllegalArgumentException("O argumento deve ser uma lista de itens");
        }
    
        if (listaDeItens.isEmpty()) {
            return new double[0];
        }
    
        return listaDeItens.stream()
                .sorted((item1, item2) -> Double.compare(item2.getPreco(), item1.getPreco()))
                .mapToDouble(Item::getPreco)
                .toArray();
    }
    
    public static String[] obterItensComEstoqueBaixo(List<Item> listaDeItens, int estoqueMinimo) {
        if (listaDeItens == null || listaDeItens.isEmpty()) {
            throw new IllegalArgumentException("É esperada uma lista de itens");
        }
    
        if (estoqueMinimo < 1) {
            throw new IllegalArgumentException("Deve ter no minimo 1 item estocado");
        }
    
        return listaDeItens.stream()
                .filter(item -> item.getEstoque() < estoqueMinimo)
                .map(Item::getNome)
                .toArray(String[]::new);
    }
    




}
package com.hemmersonrosa;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto.Builder(1, "1234567890123", "Smartphone", 1999.99)
                .marca("Samsung")
                .modelo("Galaxy S21")
                .estoque(10)
                .categoria("Eletrônicos")
                .urlFoto("https://exemplo.com/foto.jpg")
                .build();

        System.out.println("Produto criado: " + produto);
    }
}
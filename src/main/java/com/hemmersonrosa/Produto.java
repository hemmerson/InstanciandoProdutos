package com.hemmersonrosa;

import java.time.LocalDate;

public class Produto {
    private final long id;
    private final String codigoEan;
    private final String descricao;
    private final String marca;
    private final String modelo;
    private final double preco;
    private final LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque;
    private final String categoria;
    private final String urlFoto;

    private Produto(Builder builder) {
        this.id = builder.id;
        this.codigoEan = builder.codigoEan;
        this.descricao = builder.descricao;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.preco = builder.preco;
        this.dataCadastro = builder.dataCadastro;
        this.dataUltimaAtualizacao = builder.dataUltimaAtualizacao;
        this.estoque = builder.estoque;
        this.categoria = builder.categoria;
        this.urlFoto = builder.urlFoto;
    }

    public static class Builder {
        private final long id;
        private final String codigoEan;
        private final String descricao;
        private final double preco;
        private final LocalDate dataCadastro = LocalDate.now();
        private String marca;
        private String modelo;
        private LocalDate dataUltimaAtualizacao = LocalDate.now();
        private int estoque = 0;
        private String categoria = "";
        private String urlFoto = "";

        public Builder(long id, String codigoEan, String descricao, double preco) {
            if (preco <= 0) {
                throw new IllegalArgumentException("O preço deve ser maior que zero.");
            }
            if (codigoEan == null || descricao == null) {
                throw new IllegalArgumentException("Código EAN e descrição não podem ser nulos.");
            }
            this.id = id;
            this.codigoEan = codigoEan;
            this.descricao = descricao;
            this.preco = preco;
        }

        public Builder marca(String marca) {
            if (marca == null) {
                throw new IllegalArgumentException("A marca não pode ser nula.");
            }
            this.marca = marca;
            return this;
        }

        public Builder modelo(String modelo) {
            if (this.marca == null) {
                throw new IllegalStateException("Não pode definir um modelo sem uma marca.");
            }
            this.modelo = modelo;
            return this;
        }

        public Builder dataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
            if (dataUltimaAtualizacao.isBefore(this.dataCadastro)) {
                throw new IllegalArgumentException("A data da última atualização não pode ser anterior à data de cadastro.");
            }
            this.dataUltimaAtualizacao = dataUltimaAtualizacao;
            return this;
        }

        public Builder estoque(int estoque) {
            if (estoque < 0) {
                throw new IllegalArgumentException("O estoque não pode ser negativo.");
            }
            this.estoque = estoque;
            return this;
        }

        public Builder categoria(String categoria) {
            if (categoria == null) {
                throw new IllegalArgumentException("A categoria não pode ser nula.");
            }
            this.categoria = categoria;
            return this;
        }

        public Builder urlFoto(String urlFoto) {
            if (urlFoto == null) {
                throw new IllegalArgumentException("A URL da foto não pode ser nula.");
            }
            this.urlFoto = urlFoto;
            return this;
        }

        public Produto build() {
            return new Produto(this);
        }
    }

    @Override
    public String toString() {
        return "Produto: \n" +
                "id=" + id +
                ", \ncodigoEan='" + codigoEan + '\'' +
                ", \ndescricao='" + descricao + '\'' +
                ", \nmarca='" + marca + '\'' +
                ", \nmodelo='" + modelo + '\'' +
                ", \npreco=" + preco +
                ", \ndataCadastro=" + dataCadastro +
                ", \ndataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", \nestoque=" + estoque +
                ", \ncategoria='" + categoria + '\'' +
                ", \nurlFoto='" + urlFoto + '\'';
    }
}


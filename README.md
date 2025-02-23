# Produto Builder

## Sobre o Projeto

Este projeto implementa a classe `Produto` utilizando o padrão de projeto **Builder**, que facilita a instanciação de objetos complexos, garantindo que todas as regras de validação sejam cumpridas.

## Requisitos da Classe Produto

A classe `Produto` possui os seguintes atributos:

- **id** (obrigatório)
- **codigoEan** (código de barras, obrigatório)
- **descricao** (obrigatório)
- **preco** (obrigatório, maior que zero)
- marca
- modelo (somente se uma marca for definida)
- dataCadastro (definida automaticamente como a data atual, não pode ser alterada)
- dataUltimaAtualizacao (não pode ser anterior à data de cadastro)
- estoque (padrão 0, não pode ser negativo)
- categoria
- urlFoto

## Padrão de Projeto Utilizado

O **Builder Pattern** foi utilizado para permitir a criação de objetos `Produto` de maneira clara e flexível, garantindo a integridade dos dados e evitando construtores longos com muitos parâmetros opcionais.

## Exemplo de Uso

Para instanciar um objeto `Produto` usando o Builder:

```java
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
```

## Licença

Este projeto é de uso livre para fins educacionais e pessoais.

## Autor
[Hemmerson Luis Barros da Rosa](https://github.com/hemmerson)
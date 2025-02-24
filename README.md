# Produto Builder

## Sobre o Projeto

Este projeto implementa a classe `Produto` utilizando o padrão de projeto **Builder**, que facilita a instanciação de objetos complexos, garantindo que todas as regras de validação sejam cumpridas.

## Instanciando Produtos

A classe `Produto` possui os seguintes atributos:

- **Long id** (obrigatório)
- **String codigoEan** (código de barras, obrigatório)
- **String descricao** (obrigatório)
- **double preco** (obrigatório, maior que zero)
- String marca
- String modelo (somente se uma marca for definida)
- LocalDate dataCadastro (definida automaticamente como a data atual, não pode ser alterada)
- LocalDate dataUltimaAtualizacao (não pode ser anterior à data de cadastro)
- int estoque (padrão 0, não pode ser negativo)
- String categoria
- String urlFoto

A classe possui os seguintes requisitos:

1. Os atributos em negrito são obrigatórios.
2. Não pode ser informado um modelo se não for informada a marca.
3. O preço deve ser maior que zero.
4. A data de cadastro não pode ser alterada e deve ser definida por padrão com a data atual.
5. A data da última atualização não pode ser anterior a data de cadastro.
6. O estoque padrão deve ser zero e não pode ser atribuído valor negativo.
7. Nenhum dos atributos String pode ser null.

## Responda
1. Que padrão de projeto pode ser utilizado para tornar mais fácil e claro o processo de instanciação de tal classe, uma vez que há dependências entre diferentes atributos, atributos obrigatórios e outros não? Implemente tal padrão para esta classe.

 - R: O padrão a ser utilizado é o padrão de projeto `Builder`.

## Padrão de Projeto Utilizado

O **Builder** foi utilizado para permitir a criação de objetos `Produto` para evitar que o construtor fique muito longo e ainda garantindo os requisitos na instanciação do objeto.

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
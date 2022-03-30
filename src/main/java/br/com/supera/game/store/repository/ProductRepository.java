package br.com.supera.game.store.repository;

import br.com.supera.game.store.model.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

public class ProductRepository {

  public ProductRepository() {
    loadRepository();
  }

  ArrayList<ProductModel> productRepositoryList = new ArrayList<>(); // Lista de produtos
  ArrayList<ProductModel> carrinhoList = new ArrayList<>(); // Lista de produtos do carrinho
  int frete = 0; // Valor do frete
  float total = 0; // Valor total do carrinho

  public void loadRepository() { // Carrega o repositório com os dados de teste
    ProductModel product1 = new ProductModel(); // Cria um produto
    product1.setId(312); // Define o id do produto
    product1.setName("Super Mario Odyssey"); // Define o nome do produto
    product1.setPrice(197.88); // Define o preço do produto
    product1.setScore(100); // Define o score do produto
    product1.setImage("super-mario-odyssey.png"); // Define a imagem do produto
    productRepositoryList.add(product1); // Adiciona o produto na lista de produtos

    ProductModel product2 = new ProductModel();
    product2.setId(201);
    product2.setName("Call Of Duty Infinite Warfare");
    product2.setPrice(49.99);
    product2.setScore(80);
    product2.setImage("call-of-duty-infinite-warfare.png");
    productRepositoryList.add(product2);

    ProductModel product3 = new ProductModel();
    product3.setId(102);
    product3.setName("The Witcher III Wild Hunt");
    product3.setPrice(119.5);
    product3.setScore(250);
    product3.setImage("the-witcher-iii-wild-hunt.png");
    productRepositoryList.add(product3);

    ProductModel product4 = new ProductModel();
    product4.setId(99);
    product4.setName("Call Of Duty WWII");
    product4.setPrice(249.99);
    product4.setScore(205);
    product4.setImage("call-of-duty-wwii.png");
    productRepositoryList.add(product4);

    ProductModel product5 = new ProductModel();
    product5.setId(12);
    product5.setName("Mortal Kombat XL");
    product5.setPrice(69.99);
    product5.setScore(150);
    product5.setImage("mortal-kombat-xl.png");
    productRepositoryList.add(product5);

    ProductModel product6 = new ProductModel();
    product6.setId(74);
    product6.setName("Shards of Darkness");
    product6.setPrice(71.94);
    product6.setScore(400);
    product6.setImage("shards-of-darkness.png");
    productRepositoryList.add(product6);

    ProductModel product7 = new ProductModel();
    product7.setId(31);
    product7.setName("Terra Média: Sombras de Mordor");
    product7.setPrice(79.99);
    product7.setScore(50);
    product7.setImage("terra-media-sombras-de-mordor.png");
    productRepositoryList.add(product7);

    ProductModel product8 = new ProductModel();
    product8.setId(420);
    product8.setName("FIFA 18");
    product8.setPrice(195.39);
    product8.setScore(325);
    product8.setImage("fifa-18.png");
    productRepositoryList.add(product8);

    ProductModel product9 = new ProductModel();
    product9.setId(501);
    product9.setName("Horizon Zero Dawn");
    product9.setPrice(115.8);
    product9.setScore(290);
    product9.setImage("horizon-zero-dawn.png");
    productRepositoryList.add(product9);
  }

  public List<ProductModel> findAllProducts() {
    if (productRepositoryList.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Nenhum produto encontrado"
      );
    }
    return productRepositoryList;
  }

  public List<ProductModel> findAllCart() {
    if (carrinhoList.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho vazio");
    } else {
      return carrinhoList;
    }
  }

  public String addCart(int id) { // Adiciona um produto no carrinho
    for (ProductModel lista : productRepositoryList) { // Percorre a lista de produtos
      if (lista.getId() == id) { // Verifica se o id do produto é igual ao id passado
        carrinhoList.add(lista); // Adiciona o produto na lista de produtos do carrinho
        total += lista.getPrice(); // Soma o preço do produto ao total
        frete = carrinhoList.size() * 10; // Calcula o valor do frete
        if (frete >= 250) { // Verifica se o frete é maior que 250
          return ( // / Se for, retorna "Frete: Gratis"
            "Produto: " +
            lista.getName() +
            " adicionado com sucesso!\nTotal: " +
            total +
            "\nFrete: Gratis"
          );
        } else { // Se não, retorna o valor do frete
          return (
            "Produto: " +
            lista.getName() +
            " adicionado com sucesso!\nTotal: " +
            "R$" +
            total +
            "\nFrete: " +
            "R$" +
            frete
          );
        }
      }
    }
    return "Produto com id especificado nao encontrado";
  }

  public String removeCart(int id) { // Remove um produto do carrinho
    for (ProductModel listaCarrinho : carrinhoList) { // Percorre a lista de produtos do carrinho
      if (listaCarrinho.getId() == id) { // Verifica se o id do produto é igual ao id passado
        carrinhoList.remove(listaCarrinho); // Remove o produto da lista de produtos do carrinho
        total -= listaCarrinho.getPrice(); // Subtrai o preço do produto do total
        frete = carrinhoList.size() * 10; // Calcula o valor do frete

        if (frete >= 250) {
          return (
            "Produto " +
            listaCarrinho.getName() +
            " removido com sucesso!\nTotal: " +
            "R$" +
            total +
            "\nFrete: Gratis"
          );
        } else {
          return (
            "Produto " +
            listaCarrinho.getName() +
            " removido com sucesso!\nTotal: " +
            "R$" +
            total +
            "\nFrete: " +
            frete
          );
        }
      }
    }
    return "Produto com id especificado nao encontrado";
  }
}

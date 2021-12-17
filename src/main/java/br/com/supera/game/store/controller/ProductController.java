package br.com.supera.game.store.controller;

import br.com.supera.game.store.model.ProductModel;
import br.com.supera.game.store.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(description = "Product API", name = "Product")
@RequiredArgsConstructor
@RestController
@RequestMapping("/Products")
public class ProductController {
  private final ProductRepository repository;

  @ApiResponses(
    value = {
      @ApiResponse(responseCode = "200", description = "Successful operation"),
      @ApiResponse(responseCode = "400", description = "Invalid request"),
      @ApiResponse(responseCode = "404", description = "Product not found"),
    }
  )
  @Operation(summary = "Retorna todos os produtos do carrinho")
  @GetMapping
  public List<ProductModel> findAllCart() {
    return repository.findAllCart();
  }

  @ApiResponses(
    value = {
      @ApiResponse(responseCode = "200", description = "Successful operation"),
      @ApiResponse(responseCode = "400", description = "Invalid request"),
      @ApiResponse(responseCode = "404", description = "Product not found"),
    }
  )
  @Operation(summary = "Retorna todos os produtos")
  @GetMapping("/{findAllProducts}")
  public List<ProductModel> findAllProducts() {
    return repository.findAllProducts();
  }

  @ApiResponses(
    value = {
      @ApiResponse(responseCode = "202", description = "Successful operation"),
      @ApiResponse(responseCode = "400", description = "Invalid request"),
      @ApiResponse(responseCode = "404", description = "Product not found"),
    }
  )
  @Operation(summary = "Adiciona um produto ao carrinho")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String addCart(int id) {
    return repository.addCart(id);
  }

  @ApiResponse(responseCode = "202", description = "Successful operation")
  @Operation(summary = "Remove um produto do carrinho")
  @DeleteMapping
  public String remove(int id) {
    return repository.removeCart(id);
  }
}

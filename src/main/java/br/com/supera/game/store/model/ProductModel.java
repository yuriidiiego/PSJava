package br.com.supera.game.store.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductModel {
  private int id;

  @Schema(description = "Nome do produto")
  private String name;

  @Schema(description = "Preço do produto")
  private double price;

  @Schema(description = "Pontuação do produto")
  private int score;

  @Schema(description = "Imagem do produto")
  private String image;
}

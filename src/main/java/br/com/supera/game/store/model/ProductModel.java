package br.com.supera.game.store.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Product")
@Getter
@Setter
public class ProductModel {
  private int id;

  private String name;

  private double price;

  private int score;

  private String image;
}

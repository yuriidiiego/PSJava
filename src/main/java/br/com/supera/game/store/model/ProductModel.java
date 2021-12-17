package br.com.supera.game.store.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProductModel {
  private int id;

  @Schema(description = "Nome do produto")
  private String name;

  @Schema(description = "Preço do produto")
  private double price;

  @Schema(description = "Pontuação do produto")
  private short score;

  private String image;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double d) {
    this.price = d;
  }

  public short getScore() {
    return score;
  }

  public void setScore(int i) {
    this.score = (short) i;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}

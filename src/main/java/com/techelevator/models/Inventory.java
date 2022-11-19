package com.techelevator.models;

import java.math.BigDecimal;

public class Inventory {
    private int quantity;
    private BigDecimal price;
    private String itemName;
    private String type;
    private String slot;
    private int soldAtNormalPrice;
    private int soldAtBOGODOPrice;

  public Inventory(String slot, String itemName, BigDecimal price, String type) {
      this.slot = slot;
      this.itemName = itemName;
      this.price = price;
      this.type = type;
      this.quantity = 6;
      this.soldAtNormalPrice = 0;
      this.soldAtBOGODOPrice = 0;
  }

    public void setQuantity(int quantity) {

      this.quantity = quantity;
    }

    public String getSlot() {

      return slot;
    }

    public int getQuantity() {

      return quantity;
    }

    public BigDecimal getPrice() {

      return price;
    }

    public String getItemName() {

      return itemName;
    }

    public String getType() {

      return type;
    }

    public int getSoldAtNormalPrice() {
        return soldAtNormalPrice;
    }

    public void setSoldAtNormalPrice(int soldAtNormalPrice) {
        this.soldAtNormalPrice = soldAtNormalPrice;
    }

    public int getSoldAtBOGODOPrice() {
        return soldAtBOGODOPrice;
    }

    public void setSoldAtBOGODOPrice(int soldAtBOGODOPrice) {
        this.soldAtBOGODOPrice = soldAtBOGODOPrice;
    }
}

package de.hftstuttgart.middleware;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ShoppingItem {

    @Id
    @GeneratedValue
    @JsonProperty
    long id;

    private String item;
    private int amount;

    public ShoppingItem(){}

    public ShoppingItem(String itemName){

        this.item = itemName;
    }

    public ShoppingItem(String itemName, int itemAmount){

        this.item = itemName;
        this.amount = itemAmount;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}

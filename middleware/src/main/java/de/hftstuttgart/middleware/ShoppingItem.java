package de.hftstuttgart.middleware;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShoppingItem {

    @Id
    @GeneratedValue
    long id;

    String item;
    int amount = 1;

    public ShoppingItem(){}

    public ShoppingItem(String itemName){

        item = itemName;
    }
    
}

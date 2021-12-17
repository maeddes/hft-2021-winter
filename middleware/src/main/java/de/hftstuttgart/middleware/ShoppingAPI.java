package de.hftstuttgart.middleware;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShoppingAPI {

    @Autowired
    ShoppingItemRepository shoppingItemRepository;


    @GetMapping("/shoppingItem/")
    public ArrayList<String> getShoppingItems() {
        
    
        Iterable<ShoppingItem> iterableItems = shoppingItemRepository.findAll();

        ArrayList<String> itemList = new ArrayList<String>();
        
        Iterator<ShoppingItem> itemTerator = iterableItems.iterator();
        while(itemTerator.hasNext()){
            ShoppingItem tempItem = itemTerator.next();
            itemList.add(tempItem.getItem());
        }

        return itemList;

    }

    @PostMapping("/shoppingItem/{item}")
    public String addShoppingItem(@PathVariable String item){

        ShoppingItem newItem = new ShoppingItem(item);
        shoppingItemRepository.save(newItem);

        return "Yay!";

    }
    
}

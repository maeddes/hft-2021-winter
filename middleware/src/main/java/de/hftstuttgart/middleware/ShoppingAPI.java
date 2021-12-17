package de.hftstuttgart.middleware;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class ShoppingAPI {

    @Autowired
    ShoppingItemRepository shoppingItemRepository;

    @GetMapping(produces = "application/json", path = "/shoppingItem/")
    public List<ShoppingItem> getShoppingItems() {
        
        List<ShoppingItem> itemList = shoppingItemRepository.findAll();

        // ArrayList<ShoppingItem> itemList = new ArrayList<String>();
        
        // Iterator<ShoppingItem> itemTerator = iterableItems.iterator();
        // while(itemTerator.hasNext()){
        //     ShoppingItem tempItem = itemTerator.next();
        //     itemList.add(tempItem.getItem());
        // }

        return itemList;

    }

    @PostMapping("/shoppingItem/{item}")
    public String addShoppingItemByName(@PathVariable String item){

        ShoppingItem newItem = new ShoppingItem(item);
        shoppingItemRepository.save(newItem);

        return "Yay!";

    }


    @PostMapping(consumes = "application/json", produces = "application/json", path = "/shoppingItem/")
    public ShoppingItem addShoppingItem(@RequestBody ShoppingItem item){

        System.out.println("ShoppingItem: "+item);
        System.out.println(item.getItem());
        System.out.println(item.getAmount());
        shoppingItemRepository.save(item);

        return item;

    }

    @DeleteMapping("/shoppingItem/{id}")
    public String deleteShoppingItem(@PathVariable long id){
       
        shoppingItemRepository.deleteById(id);
        return "Yay!";

    }
}

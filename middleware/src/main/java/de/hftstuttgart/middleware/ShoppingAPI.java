package de.hftstuttgart.middleware;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// TODO: Be careful with Auto Import!
// import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class ShoppingAPI {

    final Logger logger = LoggerFactory.getLogger(de.hftstuttgart.middleware.ShoppingAPI.class);

    @Autowired
    ShoppingItemRepository shoppingItemRepository;

    @Value("${HOSTNAME:not_found}")
    String hostname;

    @GetMapping(produces = "application/json", path = "/shoppingItem/")
    public List<ShoppingItem> getShoppingItems() {
        
        List<ShoppingItem> itemList = shoppingItemRepository.findAll();
        return itemList;

    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/shoppingItem")
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

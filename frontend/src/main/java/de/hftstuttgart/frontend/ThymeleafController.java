package de.hftstuttgart.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
public class ThymeleafController {

    @Value("${todolist.endpoint}")
	private String todolistEndpoint;

    @GetMapping("/")
	public String displayPage(Model model){

        ShoppingItem[] items = WebClient
            .create(todolistEndpoint)
            .get()
            .retrieve()
            .bodyToMono(ShoppingItem[].class)
            .block();

		model.addAttribute("message", "HfT");
        model.addAttribute("items", items);
		return "page";
	}

    @PostMapping("/")
	public String createItem(@RequestParam String newitem, @RequestParam long amount, Model model){

        ShoppingItem item = new ShoppingItem();
        item.item = newitem;
        item.amount = amount;

        WebClient
            .create(todolistEndpoint)
            .post()
            .body(Mono.just(item), ShoppingItem.class)
            .retrieve()
            .bodyToMono(ShoppingItem.class)
            .block();
            
		return "redirect:/";
	}

    @PostMapping("/delete")
	public String deleteItem(@RequestParam long id, Model model){

        WebClient
            .create(todolistEndpoint+id)
            .delete()
            .retrieve()
            .bodyToMono(Void.class)
            .block();
            
		return "redirect:/";
	}
    
}

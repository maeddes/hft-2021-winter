package com.example.ThymeleafUI;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("play")
public class WebClientPlaygroundController {

    @GetMapping("/getItemAsJSON") 
    public String simpleCallJSON(){

        return WebClient
            .create("http://localhost:8080/todos/one")
            .get()
            .retrieve()
            .bodyToMono(JsonNode.class)
            .block()
            .toString();

    }
     
    @GetMapping("/getItemAsObject") 
    public String simpleCallObject(){

        return WebClient
            .create("http://localhost:8080/todos/one")
            .get()
            .retrieve()
            .bodyToMono(Todo.class)
            .block()
            .getName();

    }

    @GetMapping("/getItems")
    public Todo[] queryList(){

        return WebClient
            .create("http://localhost:8080/todos/")
            .get()
            .retrieve()
            .bodyToMono(Todo[].class)
            .block();
        
    }

    @GetMapping("/testPost/{newItem}")
    public Todo testPost(@PathVariable String newItem){

        return WebClient
            .create("http://localhost:8080/todos/"+newItem)
            .post()
            .retrieve()
            .bodyToMono(Todo.class)
            .block();
    }

    @GetMapping("/testDelete/{oldItem}")
    public Void testDelete(@PathVariable String oldItem){

        return WebClient
            .create("http://localhost:8080/todos/"+oldItem)
            .delete()
            .retrieve()
            .bodyToMono(Void.class)
            .block();
    }

}

package de.hftstuttgart.frontend;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("play")
public class PlayAroundController {

    @GetMapping("/getItemAsJSON") 
    public String simpleCallJSON(){

        return WebClient
            .create("http://localhost:8080/shoppingItem/")
            .get()
            .retrieve()
            .bodyToMono(JsonNode.class)
            .block()
            .toString();

    }
    
}

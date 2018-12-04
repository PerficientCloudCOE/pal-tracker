package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {
    @Value("${WELCOME_MESSAGE}")
    public String message;
    public WelcomeController(@Value("${WELCOME_MESSAGE:NOT SET}") String msg){
        this.message = msg;

    }
    @GetMapping("/")

    public String sayHello() {
        return message;
    }

}

package dev.caloramp.buste.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    @RequestMapping(value = "/**/{path:[^\\.]*}") // Cattura tutte le richieste che non contengono un punto
    public String redirect() {
        return "forward:/index.html"; // Reindirizza al file index.html
    }
}

package aplicationjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BatallaController {

    // GET http://localhost:8080/batalla
    @GetMapping("/batalla")
    public String batalla() {
        return "batalla"; // busca templates/batalla.html
    }
}

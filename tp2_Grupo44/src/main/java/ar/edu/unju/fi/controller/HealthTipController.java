package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HealthTipController {

    @GetMapping("/consejos_de_salud")
    public String getHealthTipPage() {
        return "consejos_de_salud";
    }

}

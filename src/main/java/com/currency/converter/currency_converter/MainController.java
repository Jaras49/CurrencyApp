package com.currency.converter.currency_converter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping()
    public String test() {

        return "index.html";
    }
}

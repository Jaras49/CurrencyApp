package com.currency.converter.controller;

import com.currency.converter.connection.Connection;
import com.currency.converter.json.editor.Editor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private Connection connection;

    @Autowired
    private Editor editor;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView test() {

        ModelAndView modelAndView = new ModelAndView("index.html");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getData")
    public @ResponseBody
    String getData(@RequestParam String startDate, String endDate, String currencyCode ) throws IOException {

        return editor.processData(connection.getData(startDate, endDate, currencyCode));
    }
}



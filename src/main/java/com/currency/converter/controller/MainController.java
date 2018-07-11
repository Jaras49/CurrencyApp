package com.currency.converter.controller;

import com.currency.converter.connection.Connection;
import com.currency.converter.connection.crypto.compare.CryptoCompare;
import com.currency.converter.json.editor.Editor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Pattern;
import java.io.IOException;

@Controller
@Validated
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class MainController {

    private static final String VALID_DATE_PATTERN = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
    private static final String ERR_INVALID_FORMAT = "invalid date format";

    @Autowired
    private Connection connection;

    @Autowired
    private Editor editor;

    @Autowired
    private CryptoCompare cryptoCompare;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ModelAndView jsp() {

        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("test", "test text");
        modelAndView.addObject("data", cryptoCompare.getData("", "", "GBP", "BTC"));

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getData")
    public @ResponseBody
    String getData(@RequestParam
                   @Pattern(regexp = VALID_DATE_PATTERN, message = ERR_INVALID_FORMAT) String startDate,
                   @Pattern(regexp = VALID_DATE_PATTERN, message = ERR_INVALID_FORMAT) String endDate,
                   String currencyCode) throws IOException {

        return editor.processData(connection.getData(startDate, endDate, currencyCode));
    }
}



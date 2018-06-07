package com.currency.converter.controller;

import com.google.gson.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView test() {

        ModelAndView modelAndView = new ModelAndView("index.html");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getData")
    public @ResponseBody String getData() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            String content = entity.getContent().toString();

            JsonParser jsonParser = new JsonParser();
            String s1 = EntityUtils.toString(entity);

            JsonArray rates = jsonParser.parse(s1).getAsJsonObject().getAsJsonArray("rates");

            JsonArray resultArray = new JsonArray();
            for (JsonElement rate : rates) {

                JsonElement effectiveDate = rate.getAsJsonObject().get("effectiveDate");

            }


            return "szdsa";
        }
    }

    public static void main(String[] args) throws IOException {


        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            //String s1 = EntityUtils.toString(entity);
            //String s = new BasicResponseHandler().handleResponse(response);

            String content = entity.getContent().toString();

            JsonParser jsonParser = new JsonParser();
            String s1 = EntityUtils.toString(entity);

            System.out.println("TO JEST S1" + s1 + "TO JEST S1");
            System.out.println("TO JEST CONTENT" + content + "TO JEST CONTENT");
            JsonObject json = jsonParser.parse(s1).getAsJsonObject();
            System.out.println(json);

            String[][] arr = {{"2018-05-24", "4.9056"},{"2018-05-25, 4.7655"}};

            JsonArray jsonArray = new JsonArray();

            JsonArray jsonArraySubArray = new JsonArray();
            jsonArraySubArray.add("2018-05-24");
            jsonArraySubArray.add(4.0918);

            JsonArray jsonArraySubArray2 = new JsonArray();
            jsonArraySubArray2.add("2018-05-25");
            jsonArraySubArray2.add(4.5566);

            jsonArray.add(jsonArraySubArray);
            jsonArray.add(jsonArraySubArray2);

            String test = new Gson().toJson(arr);

            JsonObject asJsonObject = jsonParser.parse(s1).getAsJsonObject();
            JsonElement rates1 = asJsonObject.get("rates");
            JsonArray rates = asJsonObject.getAsJsonArray("rates");

            JsonArray resultArray = new JsonArray();
            for (JsonElement rate : rates) {

                System.out.println("THIS IS RATE ELEMENT");

                JsonArray jsonArray1 = new JsonArray();
                JsonObject asJsonObject1 = rate.getAsJsonObject();
                String effectiveDate = asJsonObject1.get("effectiveDate").getAsString();
                double mid = asJsonObject1.get("mid").getAsDouble();
                jsonArray1.add(effectiveDate);
                jsonArray1.add(mid);
                resultArray.add(jsonArray1);

                asJsonObject1.remove("no");
                System.out.println(asJsonObject1.toString());


                System.out.println("THIS IS RATE ELEMENT");

            }
            //JsonArray asJsonArray = jsonParser.parse(s1).getAsJsonArray();
            System.out.println("This is JSON ARRAY" + rates.toString() + "THIS IS JSON ARRAY");


            System.out.println("THIS IS RESPONSE BODY" + test + "END OF RESPONSE BODY");
            System.out.println("THIS IS JSON ARRAY" + jsonArray.toString()+ "THIS IS JSON ARRAY");
            System.out.println("THIS IS FINAL RESULT" + resultArray + "THIS IS FINAL ARRAY");
        }
/*
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json");
        InputStream is = url.openConnection().getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
*/
       // System.out.println(sb.toString());
    }
}



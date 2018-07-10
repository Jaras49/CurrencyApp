package com.currency.converter.connection.crypto.compare;

import com.currency.converter.connection.crypto.compare.response.JsonResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class CryptoCompareImpl implements CryptoCompare {

    private static final String CONNECTION_URL = "https://min-api.cryptocompare.com/data/histoday";

    @Value("${app.name}")
    private static String APP_NAME;

    //@Autowired
    private RestTemplate restTemplate;

    @Override
    public JsonResponse getData(String startDate, String endDate, String currencyCodeFrom, String currencyCodeTo) {

        restTemplate = new RestTemplate();
        URI uri = buildConnectionUri(startDate, endDate, currencyCodeFrom, currencyCodeTo);
        return restTemplate.getForObject(uri, JsonResponse.class);

    }

    private URI buildConnectionUri(String startDate, String endDate, String currencyCodeFrom, String currencyCodeTo) {

        return UriComponentsBuilder.fromHttpUrl(CONNECTION_URL)
                .queryParam("fsym", currencyCodeFrom)
                .queryParam("tsym", currencyCodeTo)
                .queryParam("limit", 5)
                .queryParam("toTs", 1452680400)
                .build().encode().toUri();

    }

    public static void main(String[] args) {
        CryptoCompare cryptoCompare = new CryptoCompareImpl();
        System.out.println(cryptoCompare.getData("dsad", "", "GBP", "BTC").toString());
    }
}

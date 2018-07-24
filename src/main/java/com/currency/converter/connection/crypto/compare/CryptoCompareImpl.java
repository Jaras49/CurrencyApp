package com.currency.converter.connection.crypto.compare;

import com.currency.converter.connection.crypto.compare.response.NbpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

//TODO
@Service
public class CryptoCompareImpl implements CryptoCompare {

    private static final String CONNECTION_URL = "https://min-api.cryptocompare.com/data/histoday";

    @Value("${app.name}")
    private static String APP_NAME;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public NbpResponse getData(String startDate, String endDate, String currencyCodeFrom, String currencyCodeTo) {

        URI uri = buildConnectionUri(startDate, endDate, currencyCodeFrom, currencyCodeTo);
        return restTemplate.getForObject(uri, NbpResponse.class);
    }

    private URI buildConnectionUri(String startDate, String endDate, String currencyCodeFrom, String currencyCodeTo) {

        return UriComponentsBuilder.fromHttpUrl(CONNECTION_URL)
                .queryParam("fsym", currencyCodeFrom)
                .queryParam("tsym", currencyCodeTo)
                .queryParam("limit", 5)
                .queryParam("toTs", 1452680400)
                .build().encode().toUri();
    }
}

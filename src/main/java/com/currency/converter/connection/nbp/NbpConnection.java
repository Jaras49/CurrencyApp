package com.currency.converter.connection.nbp;

import com.currency.converter.connection.Connection;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@Service
public class NbpConnection implements Connection {

    private static final String NBP_CONNECTION_STRING = "http://api.nbp.pl/api/exchangerates/rates/a";
    private static final String SLASH = "/";

    @Override
    public String getData(String startDate, String endDate, String currencyCode) throws IOException {

        String data;

        URI uri = buildNbpRequest(startDate, endDate, currencyCode);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse reesponse = httpClient.execute(httpGet);
            HttpEntity entity = reesponse.getEntity();
            data = EntityUtils.toString(entity);
        }

        return data;
    }

    private URI buildNbpRequest(String startDate, String endDate, String currencyCode) {

        return UriComponentsBuilder.fromHttpUrl(NBP_CONNECTION_STRING)
                .path(SLASH + currencyCode)
                .path(SLASH + startDate)
                .path(SLASH + endDate)
                .queryParam("format", "json")
                .build().encode().toUri();
    }
}

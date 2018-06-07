package com.currency.converter.connection.nbp;

import com.currency.converter.connection.Connection;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class NbpConnection implements Connection {

    private static final String NBP_CONNECTION_STRING = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json";

    @Override
    public String getData() throws IOException {

        String data;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(NBP_CONNECTION_STRING);
            CloseableHttpResponse reesponse = httpClient.execute(httpGet);
            HttpEntity entity = reesponse.getEntity();
            data = EntityUtils.toString(entity);
        }

        return data;
    }
}

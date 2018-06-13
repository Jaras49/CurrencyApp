package com.currency.converter.connection;

import java.io.IOException;

public interface Connection {

    String getData(String startDate, String endDate, String currencyCode) throws IOException;
}

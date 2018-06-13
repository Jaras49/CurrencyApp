package com.currency.converter.connection;

import java.io.IOException;

public interface Connection {

    String getData(String from, String to) throws IOException;
}

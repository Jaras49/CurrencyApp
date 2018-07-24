package com.currency.converter.connection.crypto.compare;

import com.currency.converter.connection.crypto.compare.response.NbpResponse;

public interface CryptoCompare {

    NbpResponse getData(String startDate, String endDate, String currencyCodeFrom, String currencyCodeTo);
}

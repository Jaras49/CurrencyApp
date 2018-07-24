package com.currency.converter.connection.crypto.compare;

import com.currency.converter.connection.crypto.compare.response.CryptoCompareResponse;

public interface CryptoCompare {

    CryptoCompareResponse getData(String startDate, String endDate, String currencyCodeFrom, String currencyCodeTo);
}

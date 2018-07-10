package com.currency.converter.connection.crypto.compare;

import com.currency.converter.connection.crypto.compare.response.JsonResponse;

public interface CryptoCompare {

    JsonResponse getData(String startDate, String endDate, String currencyCodeFrom, String currencyCodeTo);
}

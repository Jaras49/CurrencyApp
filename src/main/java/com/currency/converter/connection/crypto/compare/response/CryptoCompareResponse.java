package com.currency.converter.connection.crypto.compare.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCompareResponse {

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Data")
    private List<CryptoCompareResponseData> cryptoCompareResponseDataList;

    @JsonProperty("TimeTo")
    private long timeTo;

    @JsonProperty("TimeFrom")
    private long timeFrom;

    public CryptoCompareResponse(String response, List<CryptoCompareResponseData> cryptoCompareResponseDataList, long timeTo, long timeFrom) {
        this.response = response;
        this.cryptoCompareResponseDataList = cryptoCompareResponseDataList;
        this.timeTo = timeTo;
        this.timeFrom = timeFrom;
    }

    public CryptoCompareResponse() {

    }

    public String getResponse() {
        return response;
    }

    public List<CryptoCompareResponseData> getCryptoCompareResponseDataList() {
        return cryptoCompareResponseDataList;
    }

    public long getTimeTo() {
        return timeTo;
    }

    public long getTimeFrom() {
        return timeFrom;
    }

    @Override
    public String toString() {
        return "CryptoCompareResponse{" +
                "response='" + response + '\'' +
                ", cryptoCompareResponseDataList=" + cryptoCompareResponseDataList +
                ", timeTo=" + timeTo +
                ", timeFrom=" + timeFrom +
                '}';
    }
}

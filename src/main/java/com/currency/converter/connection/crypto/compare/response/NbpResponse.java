package com.currency.converter.connection.crypto.compare.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpResponse {

    @JsonProperty("Response")
    private String response;

    @JsonProperty("NbpResponseData")
    private List<NbpResponseData> nbpResponseDataList;

    @JsonProperty("TimeTo")
    private long timeTo;

    @JsonProperty("TimeFrom")
    private long timeFrom;

    public NbpResponse(String response, List<NbpResponseData> nbpResponseDataList, long timeTo, long timeFrom) {
        this.response = response;
        this.nbpResponseDataList = nbpResponseDataList;
        this.timeTo = timeTo;
        this.timeFrom = timeFrom;
    }

    public NbpResponse() {

    }

    public String getResponse() {
        return response;
    }

    public List<NbpResponseData> getNbpResponseDataList() {
        return nbpResponseDataList;
    }

    public long getTimeTo() {
        return timeTo;
    }

    public long getTimeFrom() {
        return timeFrom;
    }

    @Override
    public String toString() {
        return "NbpResponse{" +
                "response='" + response + '\'' +
                ", nbpResponseDataList=" + nbpResponseDataList +
                ", timeTo=" + timeTo +
                ", timeFrom=" + timeFrom +
                '}';
    }
}

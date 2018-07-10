package com.currency.converter.connection.crypto.compare.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResponse {

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Data")
    private List<Data> dataList;

    @JsonProperty("TimeTo")
    private long timeTo;

    @JsonProperty("TimeFrom")
    private long timeFrom;

    public JsonResponse(String response, List<Data> dataList, long timeTo, long timeFrom) {
        this.response = response;
        this.dataList = dataList;
        this.timeTo = timeTo;
        this.timeFrom = timeFrom;
    }

    public JsonResponse() {

    }

    public String getResponse() {
        return response;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public long getTimeTo() {
        return timeTo;
    }

    public long getTimeFrom() {
        return timeFrom;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "response='" + response + '\'' +
                ", dataList=" + dataList +
                ", timeTo=" + timeTo +
                ", timeFrom=" + timeFrom +
                '}';
    }
}

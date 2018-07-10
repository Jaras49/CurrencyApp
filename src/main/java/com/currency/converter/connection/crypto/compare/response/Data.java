package com.currency.converter.connection.crypto.compare.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class Data {

    @JsonProperty("time")
    private long time;

    @JsonProperty("close")
    private double close;

    @JsonProperty("high")
    private double high;

    @JsonProperty("low")
    private double low;

    @JsonProperty("open")
    private double open;

    public Data(long time, double close, double high, double low, double open) {
        this.time = time;
        this.close = close;
        this.high = high;
        this.low = low;
        this.open = open;
    }

    public Data() {

    }

    public long getTime() {
        return time;
    }

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getOpen() {
        return open;
    }

    @Override
    public String toString() {
        return "Data{" +
                "time=" + time +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", open=" + open +
                '}';
    }
}

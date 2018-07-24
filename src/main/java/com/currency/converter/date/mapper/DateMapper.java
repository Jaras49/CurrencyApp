package com.currency.converter.date.mapper;

import java.util.Date;

public class DateMapper {

    public String convertUnixToString(long unixTimestamp) {

        //1452680400

        Date date = new Date(unixTimestamp * 1000);

        return date.toString();
    }

    public static void main(String[] args) {
        DateMapper dateMapper = new DateMapper();
        System.out.println(dateMapper.convertUnixToString(1452680400));
    }
}

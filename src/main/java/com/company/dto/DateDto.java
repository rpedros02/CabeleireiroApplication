package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"day", "month", "year"})
@JacksonXmlRootElement(localName = "date")
public class DateDto {
    @JacksonXmlProperty(localName = "day")
    private int day;
    @JacksonXmlProperty(localName = "month")
    private int month; // 1- january, ... 12- December
    @JacksonXmlProperty(localName = "year")
    private int year;

    public DateDto() {
    }

    public DateDto(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }


    public int getMonth() {
        return month;
    }


    public int getYear() {
        return year;
    }

}

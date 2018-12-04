package ru.sofia.market;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.format.annotation.DateTimeFormat;

public class Message {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  date;

    private ArrayList<Correlation> values;

    public LocalDate  getDate() {
        return this.date;
    }

    public void setDate(LocalDate  date) {
        this.date = date;
    }

    public ArrayList<Correlation> getValue() {
        return this.values;
    }

    public void setValue(ArrayList<Correlation> value) {
        this.values = value;
    }

}
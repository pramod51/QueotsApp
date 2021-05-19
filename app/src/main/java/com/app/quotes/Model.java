package com.app.quotes;

public class Model {
    String title,occurrence,symbol;

    public Model(String title, String occurrence, String symbol) {
        this.title = title;
        this.occurrence = occurrence;
        this.symbol = symbol;
    }

    public String getTitle() {
        return title;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public String getSymbol() {
        return symbol;
    }
}

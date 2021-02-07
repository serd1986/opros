package com.processdev.model;

public enum AgeD {
    N1("18 - 24 года."),
    N2("25 - 54 года."),
    N3("55 лет и старше.");

    private final String displayValue;

    private AgeD(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public boolean getFlag(){
        return getDisplayValue().isEmpty();
    }
}

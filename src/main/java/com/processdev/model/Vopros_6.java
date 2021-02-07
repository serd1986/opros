package com.processdev.model;

public enum Vopros_6 {
    YES("В целом положительно"),
    YES_NO("Скорее положительно, чем негативно"),
    NO_YES("Скорее негативно, чем положительно"),
    NO("В целом негативно"),
    INCONCRETE("Затрудняюсь ответить");

    private final String displayValue;

    private Vopros_6(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getIdHtml(){
        return Vopros_6.class.getName()+"_"+Vopros_6.this;
    }
}

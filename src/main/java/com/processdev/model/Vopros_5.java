package com.processdev.model;

public enum Vopros_5 {
    YES("В целом доверяю"),
    YES_NO("Скорее доверяю, чем не доверяю"),
    NO("В целом не доверяю"),
    INCONCRETE("Затрудняюсь ответить");

    private final String displayValue;

    private Vopros_5(String displayValue) {
        this.displayValue = displayValue;
    }
    public String getDisplayValue() {
        return displayValue;
    }

    public String getIdHtml(){
        return Vopros_5.class.getName()+"_"+Vopros_5.this;
    }
}

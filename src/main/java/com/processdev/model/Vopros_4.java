package com.processdev.model;

public enum Vopros_4 {
    YES("Защищенным(-ной)"),
    YES_NO("Скорее защищенным(-ной), чем незащищенным(-ной)"),
    NO_YES("Скорее незащищенным(-ной), чем защищенным(-ной)"),
    NO("Незащищенным(-ной)"),
    INCONCRETE("Затрудняюсь ответить");

    private final String displayValue;

    private Vopros_4(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {

        return displayValue;
    }
    public String getIdHtml(){
        return Vopros_4.class.getName()+"_"+Vopros_4.this;
    }
}

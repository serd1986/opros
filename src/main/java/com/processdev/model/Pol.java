package com.processdev.model;

public enum Pol {
    Мужской,
    Женский;

    private final Boolean flag;

    private Pol() {
        flag=!this.equals("");
    }

    public Boolean getFlag(){
        return flag;
    }
}

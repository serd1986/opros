package com.processdev.model;

public enum Rayon {
//    Центральный,
//    Железнодорожный,
//    Ленинский

    ULIYN_RN("Ульяновский р-н"),
    CILN_RN("Цильнинский р-н"),
    NOVO_ULIAN("г.Новоульяновск");

    private String value;

  Rayon(String value){
        this.value= value;
  }
    public String getValue(){
          return value;
    }
    @Override
    public String toString() {
        return this.toString();
    }
}
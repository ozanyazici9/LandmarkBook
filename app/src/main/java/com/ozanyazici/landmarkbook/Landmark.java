package com.ozanyazici.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {
    //Serializable; Bir yere bişey gönderirken onu veriye çevirip göndermemizi sağlıyor. Buna serileştirme deniyor. Gönderdiğimiz yerde deserializable yapılıyor.Şifrelemeye benziyor
    //implements Serializable diyerek serileştirilebilir old. belirtiyoruz.

    String name;
    String country;
    int image;

    //Constructor

    public Landmark(String name, String country, int image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}

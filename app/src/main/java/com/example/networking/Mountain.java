package com.example.networking;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class Mountain {
    @SerializedName("ID")
    public String id;
    @SerializedName("name")
    public String name;
    public String type;
    public String company;
    public String location;
    public String category;
    @SerializedName("size")
    public int meters;
    @SerializedName("cost")
    public int feet;

    public Mountain(){
        name="Namn: ";
    }

    public Mountain(String name){
        this.name=name;
    }

    public String getTitle(){
        return name;
    }

    public String getName(){
        return name;
    }

    public String ToString(){
        return name;
    }



    /*{
    "ID": "mobilprog_kinnekulle",
    "name": "Kinnekulle",
    "type": "brom",
    "company": "",
    "location": "Skaraborg",
    "category": "",
    "size": 306,
    "cost": 1004,
    }*/
}

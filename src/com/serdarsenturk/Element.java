package com.serdarsenturk;

public class Element {
    private int Z;
    private String symbol;
    private String name;
    private String group;

    public Element(int Z, String symbol, String name, String group){
        this.Z = Z;
        this.symbol = symbol;
        this.name = name;
        this.group = group;
    }

    public String WriteType(){
        return "Element";
    }

    public String WriteFeatures(int Z, String symbol, String name, String group){
        String z = String.valueOf(Z);
        return (z +this.symbol + this.name + this.group);
    }

}

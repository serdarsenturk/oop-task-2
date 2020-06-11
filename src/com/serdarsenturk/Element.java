package com.serdarsenturk;

public class Element {
    private int Z;
    private String Sembol;
    private String Ad;
    private String Grup;

    public Element(int Z, String Sembol, String Ad, String Grup){
        this.Z = Z;
        this.Sembol = Sembol;
        this.Ad = Ad;
        this.Grup = Grup;
    }

    public String TurYazdir(){
        return "Element" + "-";
    }

    public String OzellikYazdir(){
        String z = String.valueOf(Z);
        return (z + "-" + this.Sembol + "-" + this.Ad + "-" + this.Grup);
    }

}

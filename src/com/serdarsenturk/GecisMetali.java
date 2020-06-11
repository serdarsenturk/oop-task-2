package com.serdarsenturk;

public class GecisMetali extends Element {


    public GecisMetali(int Z, String Sembol, String Ad, String Grup) {
        super(Z, Sembol, Ad, Grup);
    }

    public String TurYazdir(){
        return "Gecis Metali" + "-";
    }
}

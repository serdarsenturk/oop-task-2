package com.serdarsenturk;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Element> elementListesi = Dosya.DosyadanOku("semboller.txt");
        Dosya.DosyayaYaz("sonuc.txt", elementListesi);
    }
}

class Element {
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
        return "Element";
    }

    public String OzellikYazdir(){
        String formatStr = "%-15s %-15s %-15s %-15s";
        return String.format(formatStr, this.Z, this.Sembol, this.Ad, this.Grup);
    }
}

class AlkaliMetal extends Element {

    public AlkaliMetal(int Z, String Sembol, String Ad, String Grup) {
        super(Z, Sembol, Ad, Grup);
    }

    public String TurYazdir(){
        return "Alkali Metal";
    }
}

class GecisMetali extends Element {


    public GecisMetali(int Z, String Sembol, String Ad, String Grup) {
        super(Z, Sembol, Ad, Grup);
    }

    public String TurYazdir(){
        return "Gecis Metali";
    }
}

class Diger extends Element {

    public Diger(int Z, String Sembol, String Ad, String Grup) {
        super(Z, Sembol, Ad, Grup);
    }
}

class Dosya {
    public static ArrayList<Element> DosyadanOku(String dosyaYolu) throws IOException {
        ArrayList<Element> elementListesi = new ArrayList<Element>();
        List<String> lines = Files.readAllLines(Path.of(dosyaYolu));

        for(String line : lines){
            var isHeaderLine = line.startsWith("Z");
            if (isHeaderLine) continue;

            String[] ozellikler = line.split("\t");

            elementListesi.add(ElementOlustur(ozellikler));
        }

        return elementListesi;
    }

    public static void DosyayaYaz(String dosyaAdi, ArrayList<Element> elementListesi) throws IOException {
        FileWriter writer = new FileWriter(dosyaAdi);
        for(Element str :elementListesi){
            String formatStr = "%-20s %-15s%n";
            writer.write(String.format(formatStr, str.TurYazdir(), str.OzellikYazdir()));
        }
        writer.close();
    }

    private static Element ElementOlustur(String[] ozellikler){
        var z = Integer.parseInt(ozellikler[0]);
        var sembol = ozellikler[1];
        var ad = ozellikler[2];
        var grup = ozellikler[3];

        if(grup.contains("1A")){
            return new AlkaliMetal(z, sembol, ad, grup);
        }
        else if(grup.contains("B")){
            return new GecisMetali(z, sembol, ad, grup);
        }
        else {
            return new Diger(z, sembol, ad, grup);
        }
    }
}
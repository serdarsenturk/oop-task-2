package com.serdarsenturk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;

public class Dosya {
    public static ArrayList<Element> elementListesi = new ArrayList<Element>();

    public static ArrayList<Element> DosyadanOku(String dosyaYolu) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(dosyaYolu));
        for(String line : lines){
            line.split("\t");
            String[] sutunlar = line.split("\t");
            if(sutunlar[3].contains("1A")){
                elementListesi.add(new AlkaliMetal(Integer.parseInt(sutunlar[0]), sutunlar[1], sutunlar[2], sutunlar[3]));
            }
            else if(sutunlar[3].contains("B")){
                elementListesi.add(new GecisMetali(Integer.parseInt(sutunlar[0]), sutunlar[1], sutunlar[2], sutunlar[3]));
            }
            else {
                elementListesi.add(new Diger(Integer.parseInt(sutunlar[0]), sutunlar[1], sutunlar[2], sutunlar[3]));
            }
        }
        return elementListesi;
    }

    public static void DosyayaYaz(String dosyaAdi, ArrayList<Element> lise) throws IOException {
        FileWriter writer = new FileWriter(dosyaAdi);
        for(Element str :elementListesi){
            writer.write(str.TurYazdir() + "\t");
            writer.write( str.OzellikYazdir() + System.lineSeparator());
        }
        writer.close();
    }
}

package com.serdarsenturk;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Element> elementListesi = Dosya.DosyadanOku("/Users/serdar/workdir/github/oop-task-2/src/semboller.txt");
        Dosya.DosyayaYaz("sonuc.txt", elementListesi);
    }
}

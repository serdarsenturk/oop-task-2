package com.serdarsenturk;

public class AlkaliMetal extends Element {
    public AlkaliMetal(int Z, String symbol, String name, String group) {
        super(Z, symbol, name, group);
    }

    public String WriteType(){
        return "Alkali Metal";
    }
}

package com.serdarsenturk;

public class TransitionMetal extends Element {

    public TransitionMetal(int Z, String symbol, String name, String group) {
        super(Z, symbol, name, group);
    }

    public String WriteType(){
        return "Transition Metal";
    }
}

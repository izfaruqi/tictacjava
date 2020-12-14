package com.izfaruqi.tictacjava;

public class Player {
    private int score = 0;
    private String name;
    private char printSymbol;

    public Player(String name, char printSymbol){
        this.name = name;
        this.printSymbol = printSymbol;
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setScore(int score){
        this.score = score;
    }

    char getPrintSymbol(){
        return printSymbol;
    }
}

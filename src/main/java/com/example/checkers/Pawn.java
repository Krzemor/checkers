package com.example.checkers;

public class Pawn extends Figure {

    public Pawn(String color) {
        super(color);
    }

    public String getSymbol() {
        if (color.equals("white")) {
            return "P";
        } else if (color.equals("black")) {
            return "p";
        }
        return "";
    }
}

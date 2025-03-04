package com.example.checkers;

public class Queen extends Figure {

    public Queen(String color) {
        super(color);
    }

    public String getSymbol() {
        if (color.equals("white")) {
            return "Q";
        } else if (color.equals("black")) {
            return "q";
        }
        return "";
    }
}

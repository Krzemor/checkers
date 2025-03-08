package com.example.checkers;

public class None implements Figure {

    @Override
    public Color getColor() {
        return Color.NONE;
    }

    @Override
    public String getSymbol() {
        return "  ";
    }
}

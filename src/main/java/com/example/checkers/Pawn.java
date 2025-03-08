package com.example.checkers;

public class Pawn implements Figure {
    private Color color;

    public Pawn(Color color) {
       this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return color == Color.BLACK ? "BP" : "WP";
    }
}

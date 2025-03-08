package com.example.checkers;

public class Queen implements Figure {
    private Color color;

    public Queen(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return color == Color.BLACK ? "BQ" : "WQ";
    }
}

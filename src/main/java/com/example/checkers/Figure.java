package com.example.checkers;

enum Color {
    WHITE, BLACK, NONE;
}

interface Figure {
    Color getColor();
    String getSymbol();
}
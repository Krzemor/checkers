package com.example.checkers;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<Figure> figures;

    public BoardRow(int size) {
        this.figures = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            figures.add(new None());
        }
    }

    public List<Figure> getFigures(){
        return figures;
    }

    public Figure getFigure(int col) {
        return figures.get(col);
    }

    public void setFigure(int col, Figure figure) {
       figures.set(col, figure);
    }
}

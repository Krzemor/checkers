package com.example.checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows;

    public Board() {
        rows = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            rows.add(new BoardRow());
        }
    }

    public Figure getFigure(int row, int col) {
        return rows.get(row).getFigure(col);
    }

    public void setFigure(int row, int col, Figure figure) {
        rows.get(row).setFigure(col, figure);
    }

    @Override
    public String toString() {
        String output = "=========================\n";
        for (BoardRow row : rows) {
            output += "|";
            for (Figure figure : row.getFigures()) {
                output += figure.getSymbol() + "|";
            }
            output += "\n";
            output += "-------------------------\n";
        }
        return output;
    }
}

package com.example.checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows;
    private int size;

    public Board(int size) {
        this.size = size;
        rows = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            rows.add(new BoardRow(size));
        }
    }

    public Figure getFigure(int row, int col) {
        return rows.get(row).getFigure(col);
    }

    public void setFigure(int row, int col, Figure figure) {
        rows.get(row).setFigure(col, figure);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("= " + "=".repeat(size * 3) + " =\n");
        for (BoardRow row : rows) {
            str.append("| ");
            for (Figure figure : row.getFigures()) {
                str.append(figure.getSymbol()).append(" |");
            }
            str.append("\n");
            str.append("- ").append("-".repeat(size * 3)).append(" -\n");
        }
        return str.toString();
    }
}

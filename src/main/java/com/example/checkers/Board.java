package com.example.checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows;
    private Color whoseMove;

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

    public void baseBoard() {
        setFigure(0,0, new Pawn(Color.BLACK));
        setFigure(0,2, new Pawn(Color.BLACK));
        setFigure(0,4, new Pawn(Color.BLACK));
        setFigure(0,6, new Pawn(Color.BLACK));
        setFigure(1,1, new Pawn(Color.BLACK));
        setFigure(1,3, new Pawn(Color.BLACK));
        setFigure(1,5, new Pawn(Color.BLACK));
        setFigure(1,7, new Pawn(Color.BLACK));
        setFigure(2,0, new Pawn(Color.BLACK));
        setFigure(2,2, new Pawn(Color.BLACK));
        setFigure(2,4, new Pawn(Color.BLACK));
        setFigure(2,6, new Pawn(Color.BLACK));

        setFigure(5,1, new Pawn(Color.WHITE));
        setFigure(5,3, new Pawn(Color.WHITE));
        setFigure(5,5, new Pawn(Color.WHITE));
        setFigure(5,7, new Pawn(Color.WHITE));
        setFigure(6,0, new Pawn(Color.WHITE));
        setFigure(6,2, new Pawn(Color.WHITE));
        setFigure(6,4, new Pawn(Color.WHITE));
        setFigure(6,6, new Pawn(Color.WHITE));
        setFigure(7,1, new Pawn(Color.WHITE));
        setFigure(7,3, new Pawn(Color.WHITE));
        setFigure(7,5, new Pawn(Color.WHITE));
        setFigure(7,7, new Pawn(Color.WHITE));

    }

    public void setWhoseMove(Color figureColor) {
        this.whoseMove = figureColor;
    }

    public Color getWhoseMove() {
        return whoseMove;
    }

    public boolean move(Move move) {
        if (isValidMove(move)) {
            Figure figure = getFigure(move.getCol1(), move.getRow1());
            setFigure(move.getCol2(), move.getRow2(), figure);
            setFigure(move.getCol1(), move.getRow1(), new None());

            if (Math.abs(move.getRow2() - move.getRow1()) == 2) {
                int capturedRow = (move.getRow2() + move.getRow1()) / 2;
                int capturedCol = (move.getCol2() + move.getCol1()) / 2;
                setFigure(capturedCol, capturedRow, new None());
            }

            if (figure instanceof Pawn) {
                Color color = figure.getColor();
                if ((color == Color.WHITE && move.getCol2() == 0) ||
                        (color == Color.BLACK && move.getCol2() == 7)) {
                    setFigure(move.getRow2(), move.getCol2(), new Queen(color));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean hasWon(Color color) {
        for (BoardRow row : rows) {
            for (Figure figure : row.getFigures()) {
                if (figure instanceof Pawn || figure instanceof Queen) {
                    if (figure.getColor() != color) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private boolean isValidMove(Move move) {
        Figure figure = getFigure(move.getCol1(), move.getRow1());
        Figure destination = getFigure(move.getCol2(), move.getRow2());

        //Checking if figure belongs to current player
        if (figure.getColor() != whoseMove) {
            return false;
        }

        //Checking if destination field is clear
        if (!(destination instanceof None)) {
            return false;
        }

        //Checking correct checkers move
        int rowDiff = Math.abs(move.getRow2() - move.getRow1());
        int colDiff = Math.abs(move.getCol2() - move.getCol1());
        if (rowDiff == 1 || colDiff == 1) {
            return true;
        }

        //Handling capturing
        if (rowDiff == 2 && colDiff == 2) {
            int capturedRow = (move.getRow2() + move.getRow1()) / 2;
            int capturedCol = (move.getCol2() + move.getCol1()) / 2;
            Figure capturedFigure = getFigure(capturedRow, capturedCol);
            if (!(capturedFigure instanceof None) && capturedFigure.getColor() != whoseMove) {
                return true;
            }
        }
        // todo wykrywnie wygranej zakończenia minimax algorytm
        return true;
    }
}

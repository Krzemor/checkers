package com.example.checkers;

public class GameLogic {

    void play() {
        Board board = new Board();
        board.baseBoard();
        board.setWhoseMove(Color.WHITE);

        while (true) {
            UserDialogs.displayBoard(board);

            if (board.hasWon(Color.WHITE)) {
                System.out.println("White player wins!");
                break;
            } else if (board.hasWon(Color.BLACK)) {
                System.out.println("Black player wins!");
                break;
            }

            Move move = UserDialogs.getUserMove(board.getWhoseMove());
            if (board.move(move)) {
                board.setWhoseMove(oppositePlayer(board.getWhoseMove()));
            } else {
                UserDialogs.showInproperMove();
            }

        }
    }

    private Color oppositePlayer(Color whoseMove) {
        return (whoseMove == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

}

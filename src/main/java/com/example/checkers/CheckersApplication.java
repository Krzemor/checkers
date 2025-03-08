package com.example.checkers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckersApplication {

    public static void main(String[] args) {
        Board board = new Board();
        board.setFigure(0,1,new Queen(Color.BLACK));
        board.setFigure(1,7,new Queen(Color.WHITE));
        board.setFigure(7,7,new Queen(Color.BLACK));
        board.setFigure(0,2,new Pawn(Color.BLACK));
        board.setFigure(0,3,new Pawn(Color.WHITE));
        board.setFigure(1,6,new Pawn(Color.WHITE));

        System.out.println(board);
    }

}

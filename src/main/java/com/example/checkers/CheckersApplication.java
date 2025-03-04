package com.example.checkers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckersApplication {

    public static void main(String[] args) {
        Board board = new Board(8);
        board.setFigure(0,1,new Queen("white"));
        board.setFigure(1,7,new Queen("black"));
        board.setFigure(7,7,new Queen("black"));
        board.setFigure(0,2,new Pawn("white"));
        board.setFigure(0,3,new Pawn("white"));
        board.setFigure(1,6,new Pawn("black"));

        System.out.println(board);
    }

}

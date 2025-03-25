package com.example.checkers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CheckersApplication {

    public static void main(String[] args) {
        Board board = new Board();

        GameLogic game = new GameLogic();
        game.play();
        
    }

}

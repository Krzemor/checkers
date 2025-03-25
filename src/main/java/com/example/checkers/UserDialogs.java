package com.example.checkers;

import java.util.Scanner;

public class UserDialogs {
    public static Move getUserMove(Color whoseMove) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your next move (player " + whoseMove + ") [x1,y1,x2,y2]");
            String input = scanner.nextLine();
            String[] inputArray = input.split(",");
            if (inputArray.length != 4) {
                System.out.println("Invalid move, try again.");
            } else {
                try {
                    int[] inputNumberArray = new int[4];
                    for (int i = 0; i < inputArray.length; i++) {
                        inputNumberArray[i] = Integer.parseInt(inputArray[i]);
                    }
                    if (inputNumberArray[0] >= 0 && inputNumberArray[1] >= 0 && inputNumberArray[2] >= 0 && inputNumberArray[3] >= 0 &&
                            inputNumberArray[0] < 8 && inputNumberArray[1] < 8 && inputNumberArray[2] < 8 && inputNumberArray[3] < 8) {
                        return new Move(inputNumberArray[0], inputNumberArray[1], inputNumberArray[2], inputNumberArray[3]);
                    } else {
                        System.out.println("Invalid move, try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid move, try again.");
                }
            }
        }
    }

    public static void showInproperMove() {
        System.out.println("Wrong move, try again.");
    }

    public static void displayBoard(Board board) {
        System.out.println(board);
    }
}

package com.improve1.training;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Start<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        // get player names
        System.out.print("Please, enter Player 1 name: ");
        Scanner input = new Scanner(System.in);
        String player1Name = input.nextLine();
        System.out.print("Please, enter Player 2 name: ");
        String player2Name = input.nextLine();
        System.out.println();

        TennisGame game = new TennisGame(player1Name, player2Name);
        game.showResult();
        game.play(input);
        System.out.println("End>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
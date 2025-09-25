package com.improve1.training;

import java.util.Scanner;

public class TennisGame {
    String player1Name;
    String player2Name;
    ScoreEnum player1Score;
    ScoreEnum player2Score;
    boolean theGameIsOver = false;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = ScoreEnum.LOVE;
        this.player2Score = ScoreEnum.LOVE;
        System.out.println("Tennis game started between " + player1Name + " and " + player2Name + "...");
        System.out.println();
    }

    public void play(Scanner input) {
        if (theGameIsOver) {
            System.out.println("The game is already over.");
            return;
        }
//        System.out.println("Enter scores (e.g., '1 0' means " + player1Name + " scores, '0 1' means " + player2Name + " scores, '0 0' to end):");
        String enterScoreMessage = String.format("Who scored a point ('1' means %s scores, '2' means %s scores, '0' to cancel-the-game):", player1Name, player2Name);
        System.out.println(enterScoreMessage);
        // "Who scored a point (e.g., '1' means " + player1Name + " scores, '2' means " + player2Name + " scores, '0' to end):"
        // "Who scored a point (e.g., '1' means " + player1Name + " scores, '2' means " + player2Name + " scores, '0' to end):"
        // "Who scored a point (e.g., '1 0' means %s scores, '0 1' means %s scores, '0 0' to end):
        int winnerPlayerId = input.nextInt();
        System.out.println();
        while (winnerPlayerId != 0 || !theGameIsOver) {
            if (winnerPlayerId == 1) {
                increaseScore(player1Name);
                showResult();
            } else if (winnerPlayerId == 2) {
                increaseScore(player2Name);
                showResult();
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 0.");
            }
            if (theGameIsOver) {
                break;
            }
            System.out.println(enterScoreMessage);
            winnerPlayerId = input.nextInt();
        }
//        this.showResult();
        System.out.println("Game ended.");
    }

    private void increaseScore(String playerName) {
        if (playerName.equals(player1Name)) {
            if (player1Score == ScoreEnum.LOVE) {
                player1Score = ScoreEnum.FIFTEEN;
            } else if (player1Score == ScoreEnum.FIFTEEN) {
                player1Score = ScoreEnum.THIRTY;
            } else if (player1Score == ScoreEnum.THIRTY) {
                player1Score = ScoreEnum.FORTY;
            } else if (player1Score == ScoreEnum.FORTY) {
                if (player2Score == ScoreEnum.FORTY) {
                    player1Score = ScoreEnum.ADVANTAGE;
                } else if (player2Score == ScoreEnum.ADVANTAGE) {
                    player2Score = ScoreEnum.FORTY;
                } else {
                    player1Score = ScoreEnum.WIN;
                    System.out.println(player1Name + " wins the game!");
                    theGameIsOver = true;
                }
            } else if (player1Score == ScoreEnum.ADVANTAGE) {
                player1Score = ScoreEnum.WIN;
                System.out.println(player1Name + " wins the game!");
                theGameIsOver = true;
            }
        } else if (playerName.equals(player2Name)) {
            if (player2Score == ScoreEnum.LOVE) {
                player2Score = ScoreEnum.FIFTEEN;
            } else if (player2Score == ScoreEnum.FIFTEEN) {
                player2Score = ScoreEnum.THIRTY;
            } else if (player2Score == ScoreEnum.THIRTY) {
                player2Score = ScoreEnum.FORTY;
            } else if (player2Score == ScoreEnum.FORTY) {
                if (player1Score == ScoreEnum.FORTY) {
                    player2Score = ScoreEnum.ADVANTAGE;
                } else if (player1Score == ScoreEnum.ADVANTAGE) {
                    player1Score = ScoreEnum.FORTY;
                } else {
                    player2Score = ScoreEnum.WIN;
                    System.out.println(player2Name + " wins the game!");
                    theGameIsOver = true;
                }
            } else if (player2Score == ScoreEnum.ADVANTAGE) {
                player2Score = ScoreEnum.WIN;
                System.out.println(player2Name + " wins the game!");
                theGameIsOver = true;
            }
        }
    }
//    private void increaseScore(ScoreEnum playerScore) {
//        if (playerScore == ScoreEnum.LOVE) {
//            player1Score = ScoreEnum.FIFTEEN;
//        } else if (playerScore == ScoreEnum.FIFTEEN) {
//            player1Score = ScoreEnum.THIRTY;
//        } else if (playerScore == ScoreEnum.THIRTY) {
//            player1Score = ScoreEnum.FORTY;
//        } else if (playerScore == ScoreEnum.FORTY) {
//            if (player2Score == ScoreEnum.FORTY) {
//                player1Score = ScoreEnum.ADVANTAGE;
//            } else if (player2Score == ScoreEnum.ADVANTAGE) {
//                player2Score = ScoreEnum.FORTY;
//            } else {
//                player1Score = ScoreEnum.WIN;
//                System.out.println(player1Name + " wins the game!");
//            }
//        } else if (playerScore == ScoreEnum.ADVANTAGE) {
//            player1Score = ScoreEnum.WIN;
//            System.out.println(player1Name + " wins the game!");
//        }
//    }

    public void showResult() {
        System.out.println("Current Score: " + player1Name + " " + player1Score + " - " + player2Score + " " + player2Name);
        System.out.println();
    }
}

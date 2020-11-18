package com.main;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {

        boolean isDraw = player1Score == player2Score;
        boolean isEnd = player1Score >= 4 || player2Score >= 4;

        if (isDraw) {
            return getCallDrawGame(player1Score);
        } else if (isEnd) {
            return getCallEndGame(player1Score, player2Score);
        }
        String calledScore = getCallPlayerScore(player1Score) + " - " + getCallPlayerScore(player2Score);
        return calledScore;
    }

    private static String getCallDrawGame(int drawScore) {
        switch (drawScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static String getCallEndGame(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        int finalScore = player1Score - player2Score;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult > 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private static String getCallPlayerScore(int playerScore) {
        String call;
        switch (playerScore) {
            case 0:
                call = "Love";
                break;
            case 1:
                call = "Fifteen";
                break;
            case 2:
                call = "Thirty";
                break;
            default:
                call = "Forty";
                break;
        }
        return call;
    }
}
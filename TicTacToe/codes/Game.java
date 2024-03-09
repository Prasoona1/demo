package game;

import player.Player;

import java.util.Scanner;

import board.Board;

public class Game {
    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String zero;
    String cross;

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;
        StringBuilder z = new StringBuilder();
        StringBuilder o = new StringBuilder();
        for (int i = 0; i < board.size; i++) {
            z.append('0');
            o.append('X');
        }
        this.zero = z.toString();
        this.cross = o.toString();

    }

    public void printBoard() {
        int n = this.board.size;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // public void play(int x) {
    // printBoard();
    // int size = board.size;
    // if (x >= 1 && y <= size * size) {
    // return true;
    // } else {
    // return fasle;
    // }
    // }
    public void play() {
        printBoard();
        int sz = board.size;
        while (!gameOver) {
            noOfMoves++;
            int idx = getIndex();
            int row = idx / sz;
            int col = idx % sz;
            board.matrix[row][col] = players[turn].getSymbol();
            if (noOfMoves >= sz * sz) {
                System.out.println("Game draw");
                return;
            }
            if (noOfMoves >= 2 * sz - 1 && checkCombinations() == true) {
                gameOver = true;
                printBoard();
                System.out.println("Winner is:" + players[turn].getPlayerName());
                return;
            }
            turn=(turn+1)%2;
            printBoard();

        }

    }

    public int getIndex() {
        int size = board.size;
        while (true) {
            // player turns
            System.out.println("Players turn:" + players[turn].getPlayerName() + "  enter a position");
            Scanner scn = new Scanner(System.in);
            int pos = scn.nextInt() - 1;
            int row = pos / size;
            int col = pos % size;
            // checking for invalid
            if (row < 0 || row >= size || col < 0 || col >= size) {
                System.out.println("Invalid position");
                continue;
            }
            // checking for occupied
            if (board.matrix[row][col] != '-') {
                System.out.println("Position already occupied");
                continue;
            }
            return pos;
        }
    }

    public boolean checkCombinations() {
        int n = board.size;
        // row-wise
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board.matrix[i][j]);
            }
            String pattern = sb.toString();
            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }
        // col-wise
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board.matrix[j][i]);
            }
            String pattern = sb.toString();
            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }
        // diagonal wise
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }
        // antidiagonal wise
        i = 0;
        j = n - 1;
        sb = new StringBuilder();
        while (i < n) {
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }
        return false;
    }
}

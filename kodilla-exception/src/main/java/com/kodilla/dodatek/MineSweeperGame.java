package com.kodilla.dodatek;

import java.util.Random;
import java.util.Scanner;

public class MineSweeperGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj szerokość planszy: ");
        int width = scanner.nextInt();

        System.out.print("Podaj wysokość planszy: ");
        int height = scanner.nextInt();

        System.out.print("Podaj liczbę min: ");
        int numMines = scanner.nextInt();

        Board board = new Board(width, height, numMines);
        board.printBoard();

        while (!board.isGameover()) {
            System.out.print("Podaj współrzędne (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (!board.isValidMove(x, y)) {
                System.out.println("Nieprawidłowy ruch. Spróbuj ponownie.");
                continue;
            }

            board.makeMove(x, y);
            board.printBoard();
        }

        if (board.isWin()) {
            System.out.println("Gratulacje! Wygrałeś!");
        } else {
            System.out.println("Przegrałeś. Koniec gry.");
        }

        scanner.close();
    }
}

class Board {
    private final int width;
    private final int height;
    private final int numMines;
    private boolean[][] mines;
    private boolean[][] revealed;
    private boolean gameover;
    private boolean win;

    public Board(int width, int height, int numMines) {
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        this.mines = new boolean[width][height];
        this.revealed = new boolean[width][height];
        this.gameover = false;
        this.win = false;

        initializeBoard();
    }

    private void initializeBoard() {
        Random random = new Random();

        for (int i = 0; i < numMines; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            if (!mines[x][y]) {
                mines[x][y] = true;
            } else {
                i--;
            }
        }
    }

    public void printBoard() {
        System.out.println("Plansza:");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (revealed[x][y]) {
                    if (mines[x][y]) {
                        System.out.print(" * "); // Mina odkryta
                    } else {
                        int numMinesAround = countMinesAround(x, y);
                        System.out.print(" " + numMinesAround + " ");
                    }
                } else {
                    System.out.print(" ? "); // Komórka nieodkryta
                }
            }
            System.out.println();
        }

        System.out.println("----------");
    }

    private int countMinesAround(int x, int y) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    if (mines[newX][newY]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height && !revealed[x][y];
    }

    public void makeMove(int x, int y) {
        if (mines[x][y]) {
            gameover = true;
        } else {
            revealed[x][y] = true;

            // Odkryj sąsiednie komórki, jeśli nie ma min wokół
            if (countMinesAround(x, y) == 0) {
                revealNeighbors(x, y);
            }

            // Sprawdź warunek zwycięstwa
            win = checkWin();
        }
    }

    private void revealNeighbors(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;

                if (isValidMove(newX, newY)) {
                    revealed[newX][newY] = true;

                    if (countMinesAround(newX, newY) == 0) {
                        revealNeighbors(newX, newY);
                    }
                }
            }
        }
    }

    private boolean checkWin() {
        int numUnrevealed = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!revealed[x][y]) {
                    numUnrevealed++;
                }
            }
        }

        return numUnrevealed == numMines;
    }

    public boolean isGameover() {
        return gameover || win;
    }

    public boolean isWin() {
        return win;
    }
}

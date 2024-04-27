package models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playertype;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playertype) {
        this.name = name;
        this.symbol = symbol;
        this.playertype = playertype;
    }

    public Move makeMove(Board board) {
        // ask the user where they want to place symbol - input
        System.out.println("Enter the ROW where you want to place your symbol: ");
        int row = scanner.nextInt();
        System.out.println("Enter the COLUMN where you want to place your symbol: ");
        int col = scanner.nextInt();

        return new Move(new Cell(row,col), this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayertype() {
        return playertype;
    }

    public void setPlayertype(PlayerType playertype) {
        this.playertype = playertype;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Player.scanner = scanner;
    }
}

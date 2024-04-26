package models;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playertype;

    public Player(String name, Symbol symbol, PlayerType playertype) {
        this.name = name;
        this.symbol = symbol;
        this.playertype = playertype;
    }
}

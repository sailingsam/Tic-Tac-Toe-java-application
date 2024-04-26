package models;

public class Bot extends Player {
    BotDifficultyLevel difficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playertype, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, playertype);
        this.difficultyLevel = difficultyLevel;
    }
}

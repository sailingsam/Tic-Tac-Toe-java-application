package models;

import java.util.List;

public class Bot extends Player {
    BotDifficultyLevel difficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playertype, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, playertype);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        //just fill first empty cell
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellstate().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}

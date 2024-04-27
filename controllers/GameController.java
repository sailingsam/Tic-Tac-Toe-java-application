package controllers;

import exceptions.invalidMoveException;
import models.GameState;
import models.Player;
import models.Game;

import java.util.*;

public class GameController {
    public Game startGame(int dimension, List<Player> players) {
        // todo validate game parameters
        return new Game(dimension, players);
    }

    public void makeMove(Game game) throws invalidMoveException {
        // todo implement game logic
        game.makeMove();
        return;
    }

    public GameState checkstate(Game game) {
        return game.getGamestate();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}

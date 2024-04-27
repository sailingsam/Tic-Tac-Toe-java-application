import controllers.GameController;
import exceptions.invalidMoveException;
import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws invalidMoveException {
        System.out.println("Welcome to the Game! Lets start the game");
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
//        System.out.println("Enter the dimension of the board: ");
        int dimension = 3;
        List<Player> players = List.of(new Player("sam", new Symbol('x'), PlayerType.human),
                new Bot("tom", new Symbol('y'), PlayerType.bot, BotDifficultyLevel.easy));

        Game game = gameController.startGame(dimension, players);
//        gameController.printBoard(game);

        while (game.getGamestate() == GameState.inProgress) {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        if (game.getGamestate() == GameState.draw) {
            System.out.println("The game is a draw!");
        } else {
            gameController.printBoard(game);
            System.out.println(game.getWinner().getName() + " won the Game");
        }

//        if (!gameController.checkstate(game).equals(GameState.ended)) {
//            game.setGamestate(GameState.draw);
//            System.out.println("Game Draw! Over!");
//        } else {
//            System.out.println("The winner is: " + gameController.getWinner(game).getName());
//        }
    }
}

package models;

import exceptions.invalidMoveException;
import strategies.WinningAlgorithm;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moves;
    private GameState gamestate;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.gamestate = GameState.inProgress;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextPlayerIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerMoveIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }

        return board.getBoard().get(row).get(col).getCellstate().equals(CellState.EMPTY);
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public void makeMove() throws invalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);

        System.out.println("Player " + currentPlayer.getName() + " turn");

        //current player ka move
        Move move = currentPlayer.makeMove(board);

        //check if move is valid
        if (!validateMove(move)) {
            //exception
            throw new invalidMoveException("Invalid Move, Try again " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellstate(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();

        //check if curr move is winning move
        if (winningAlgorithm.checkWinner(board, finalMove)) {
            winner = currentPlayer;
            gamestate = GameState.ended;
        }
    }

}

import java.util.*;
import models.Board;
import models.GameState;
import models.Move;
import models.Player;

public class game {
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private Player winner;
    private List<Move> moves;
    private GameState gamestate;

    public game (int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.gamestate = GameState.inProgress;
    }
}

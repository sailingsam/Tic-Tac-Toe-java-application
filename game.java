import java.util.*;
import models.Board;
import models.GameState;
import models.Move;
import models.Player;

public class game {
    Board board;
    List<Player> players;
    int nextPlayerIndex;
    Player winner;
    List<Move> moves;
    GameState gamestate;
}

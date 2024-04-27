package strategies;

import models.Board;
import models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    // hashmap row no -> hashmap for that row
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    // hashmap col no -> hashmap for that col
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    // hashmap diag no -> hashmap for that diag
    HashMap<Character , Integer> leftDiagMaps = new HashMap<>();
    HashMap<Character , Integer> rightDiagMaps = new HashMap<>();

    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getaChar();


        //row
        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> currRowMap = rowMaps.get(row);

        if (!currRowMap.containsKey(character)) {
            currRowMap.put(character, 1);
        } else {
            currRowMap.put(character, currRowMap.get(character) + 1);
        }

        if (currRowMap.get(character) == board.getSize()) {
            return true;
        }


        //col
        if (!colMaps.containsKey(col)) {
            colMaps.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currColMap = colMaps.get(col);

        if (!currColMap.containsKey(character)) {
            currColMap.put(character, 1);
        } else {
            currColMap.put(character, currColMap.get(character) + 1);
        }

        if (currColMap.get(character) == board.getSize()) {
            return true;
        }

        //left diag
        if (row == col) {
            if (!leftDiagMaps.containsKey(character)) {
                leftDiagMaps.put(character, 1);
            } else {
                leftDiagMaps.put(character, leftDiagMaps.get(character) + 1);
            }

            if (leftDiagMaps.get(character) == board.getSize()) {
                return true;
            }
        }

        //right diag
        if (row + col == board.getSize() - 1) {
            if (!rightDiagMaps.containsKey(character)) {
                rightDiagMaps.put(character, 1);
            } else {
                rightDiagMaps.put(character, rightDiagMaps.get(character) + 1);
            }

            if (rightDiagMaps.get(character) == board.getSize()) {
                return true;
            }
        }

        return false;
    }
}

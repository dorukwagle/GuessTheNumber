package PuzzleEngine;

import java.util.List;

public class Puzzle {

    private final List<List<String>> puzzle;
    private final int solution;

    public Puzzle(List<List<String>> puzzle, int hiddenNumber) {
        this.puzzle = puzzle;
        this.solution = hiddenNumber;
    }

    public List<List<String>> getPuzzle() {
        return this.puzzle;
    }

    public int getSolution() {
        return this.solution;
    }
}

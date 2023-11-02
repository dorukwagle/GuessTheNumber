package PuzzleEngine;

import java.util.*;

public class Engine {
    private final int MAX_NUMBER = 999;
    private final int MIN_NUMBER = 100;
    private final Operator[] operators = { Operator.Add, Operator.Sub };

    private List<List<Operator>> operatorList = new ArrayList<>();
    private List<List<Integer>> puzzleMatrix = new ArrayList<>();

    // track all the generated numbers to avoid redundancy
    private Set<Integer> matrixTracker = new HashSet<>();

    //generate left hand side matrix i.e the puzzle without RHS vertical and horizontal sums
    public Puzzle generatePuzzle(int rowCount, int termsCount) {
        for (var i = 0; i < rowCount; ++i) {
            var operationRow = new ArrayList<Operator>();
            var rowMatrix = new ArrayList<Integer>();

            for (var j = 0; j < termsCount; ++j) {
                operationRow.add(generateRandomOperator());
                int num;
                // if the number already exists, regenerate it until it becomes distinct
                while (matrixTracker.contains((num = generateRandomValue(MIN_NUMBER, MAX_NUMBER))))
                    ;
                matrixTracker.add(num);
                rowMatrix.add(num);
            }
            operatorList.add(operationRow);
            puzzleMatrix.add(rowMatrix);
        }
        return parseMatrix();
    }

    public Puzzle generatePuzzle(int rowCount) {
        return generatePuzzle(rowCount, rowCount);
    }

    public void reset() {
        this.operatorList.clear();
        this.puzzleMatrix.clear();
        this.matrixTracker.clear();
    }

    private Puzzle parseMatrix() {
        // generate a hidden number for tomato placement
        var hiddenNumber = generateHiddenNumber();

        // send the matrix for parsing into the puzzle
        return new PuzzleParser(this.puzzleMatrix, this.operatorList, hiddenNumber)
                .parse();
    }

    private int generateHiddenNumber() {
        var numString = new StringBuilder();

        matrixTracker.forEach(numString::append);
        var ind = generateRandomValue(0, numString.length() - 1);
        return Character.getNumericValue(numString.charAt(ind));
    }

    private int generateRandomValue(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    private Operator generateRandomOperator() {
        return operators[generateRandomValue(0, 1)];
    }
}

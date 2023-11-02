package PuzzleEngine;

import java.util.List;
import java.util.Queue;

public class PuzzleParser {
    private List<List<Integer>> puzzleMatrix;
    private List<List<Operator>> operatorList;
    private int hiddenNumber;
    private int rowCount;
    private int colCount;

    private List<List<String>> puzzle;

    public PuzzleParser(List<List<Integer>> puzzleMatrix, List<List<Operator>> operatorList, int hiddenNumber) {
        this.puzzleMatrix = puzzleMatrix;
        this.operatorList = operatorList;
        this.hiddenNumber = hiddenNumber;
        this.rowCount = puzzleMatrix.size();
        this.colCount = puzzleMatrix.get(0).size();
    }

    public Puzzle parse() {
        // calculate the sum of both rows and columns
        var rowSum = getRowsSum();
        var colSum = getColumnsSum();


        return null;
    }

    private int[] getRowsSum() {
        var row = new int[rowCount];

        return row;
    }

    private int[] getColumnsSum() {
        var column = new int[colCount];

        return column;
    }
}

package PuzzleEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleParser {
    private List<List<Integer>> puzzleMatrix;
    private List<List<Operator>> operatorList;
    private int hiddenNumber;
    private int rowCount;
    private int colCount;

    private List<List<String>> puzzle = new ArrayList<>();

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

        for (var i = 0; i < rowCount; ++i) {
            var row = puzzleMatrix.get(i);
            var operRow = operatorList.get(i);
            var rowPuzzle = new ArrayList<String>();

            for (var j = 0; j < colCount; ++j) {
                rowPuzzle.add(hideNumber(row.get(j)));
                var op = operRow.get(j) == Operator.Add ? "+" : "-";
                if (op.equals("+") && i == 0) continue;
                rowPuzzle.add(op);
            }

            rowPuzzle.add("=");
            rowPuzzle.add(String.valueOf(rowSum[i]));

            puzzle.add(rowPuzzle);
        }

        // add equals sign at second last row
        var equalsRow = new ArrayList<String>();
        for (var i = 0; i < colCount; ++i)
            equalsRow.add("=");

        // add colSum as the last row
        var colSumRow = new ArrayList<String>();
        Arrays.stream(colSum).forEach(num -> colSumRow.add(String.valueOf(num)));

        puzzle.add(equalsRow);
        puzzle.add(colSumRow);

        return new Puzzle(puzzle, hiddenNumber);
    }

    private String hideNumber(int number) {
        return String.valueOf(number).replaceAll(String.valueOf(hiddenNumber), "T");
    }

    private int[] getRowsSum() {
        var row = new int[rowCount];

        for (var i = 0; i < rowCount; ++i) {
            var list = puzzleMatrix.get(i);
            var operList = operatorList.get(i);
            var rowSum = 0;
            for (var j = 0; j < colCount; ++j) {
                var num = list.get(j);
                var numSign = operList.get(j);
                rowSum = numSign == Operator.Add ? rowSum + num : rowSum - num;
            }
            row[i] = rowSum;
        }

        return row;
    }

    private int[] getColumnsSum() {
        var column = new int[colCount];

        for (var i = 0; i < colCount; ++i) {
            var colSum = 0;
            for (var j = 0; j < rowCount; ++j) {
                var list = puzzleMatrix.get(j);
                var operList = operatorList.get(j);

                var num = list.get(i);
                var numSign = operList.get(i);
                colSum = numSign == Operator.Add ? colSum + num : colSum - num;
            }
            column[i] = colSum;
        }

        return column;
    }
}

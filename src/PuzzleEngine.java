import java.util.*;

public class PuzzleEngine {
    // getSquarePuzzle
    // getPuzzle
    private final int MAX_NUMBER = 999;
    private final int MIN_NUMBER = 100;
    private final Operator[] operators = { Operator.Add, Operator.Sub };

    private Queue<Queue<Operator>> operationQueue = new ArrayDeque<>();
    private List<List<Integer>> puzzleMatrix = new ArrayList<>();
    private Set<Integer> tracker = new HashSet<>();

    public int generatePuzzle(int rowCount, int termsCount) {
        for (var i = 0; i < rowCount; ++i) {
            var operationRow = new ArrayDeque<Operator>();
            var rowMatrix = new ArrayList<Integer>();

            for (var j = 0; j < termsCount; ++j) {
                operationRow.push(generateRandomOperator());
                int num;
                // if the number already exists, regenerate it until it becomes distinct
                while (tracker.contains((num = generateRandomValue(MIN_NUMBER, MAX_NUMBER))))
                    ;
                tracker.add(num);
                rowMatrix.add(num);
            }
            operationQueue.add(operationRow);
            puzzleMatrix.add(rowMatrix);
        }
        return 0;
    }

    public void reset() {
        this.operationQueue.clear();
        this.puzzleMatrix.clear();
    }

    private int generateRandomValue(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    private Operator generateRandomOperator() {
        return operators[generateRandomValue(0, 1)];
    }
}

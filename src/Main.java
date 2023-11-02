import PuzzleEngine.Engine;
import PuzzleEngine.Puzzle;

public class Main {
    public static void main(String[] args) {
        var obj = new Engine();
        var puzzle = obj.generatePuzzle(2);
        obj.reset();
        var puzzle2 = obj.generatePuzzle(3);
        printPuzzle(puzzle);
        printPuzzle(puzzle2);
    }

    private static void printPuzzle(Puzzle puzzle) {
        puzzle.getPuzzle().forEach(lst -> {
            lst.forEach(num -> System.out.print(num + "\t"));
            System.out.println("\n");
        });
        System.out.println("answer: " + puzzle.getSolution());
    }
}
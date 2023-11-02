public class PuzzleEngine {
    // getSquarePuzzle
    // getPuzzle

    public int getPuzzle() {
        return generateRandomValue(0, 9);
    }

    private int generateRandomValue(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }
}

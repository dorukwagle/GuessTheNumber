import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        var obj = new PuzzleEngine();
        System.out.println("Hello world!");
        for (int i = 0; i < 5; ++i)
            System.out.println(obj.generatePuzzle(2, 3));
    }
}
package dev.kstatz12;

public class App
{
    public static void main(String[] args) {
        System.out.println(exec(new TwoP2(new Input())));
    }

    private static <T> T exec(AbstractPuzzle<T> puzzle) {
        return puzzle.run();
    }
}

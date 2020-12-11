package dev.kstatz12;

public class App
{
    public static void main(String[] args) {
        exec(new Four(new Input()));
    }

    private static <T> void exec(AbstractPuzzle<T> puzzle) {
        System.out.println(puzzle.run());
    }
}

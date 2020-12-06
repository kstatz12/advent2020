package dev.kstatz12;

public class App
{
    public static void main(String[] args) {
        Two two = new Two(new Input());
        System.out.println(exec(two));
    }

    private static <T> T exec(AbstractPuzzle<T> puzzle) {
        return puzzle.run();
    }
}

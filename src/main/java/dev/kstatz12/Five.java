package dev.kstatz12;

import java.util.List;
import java.util.NoSuchElementException;

public class Five extends AbstractPuzzle<Integer> {

    private final AbstractInput input;

    public Five(final AbstractInput input) {
        this.input = input;

    }

    @Override
    public Integer run() {
        return getInput().stream()
            .map(x -> getSeatId(x))
            .mapToInt(x -> x)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }

    private Integer getSeatId(String input) {
        input = input.replace('F', '0');
        input = input.replace('B', '1');
        input = input.replace('L', '0');
        input = input.replace('R', '1');
        return Integer.parseInt(input, 2);
    }


    private List<String> getInput() {
        final String fileName = "/home/karl.statz/src/advent_data/five.txt";

        return input.getFileLines(fileName);
    }
}

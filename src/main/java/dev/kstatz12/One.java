package dev.kstatz12;

import java.util.List;
import java.util.stream.Collectors;

public class One extends AbstractPuzzle<Integer> {
    private AbstractInput input;

    public One(AbstractInput input) {
        this.input = input;
    }

    @Override
    public Integer run() {
        List<Integer> inputs = getInput();
        return calc(inputs);
    }

    private Integer calc(List<Integer> inputs) {
        for (Integer a : inputs) {
            for (Integer b : inputs) {
                if (a + b == 2020) {
                    Integer result = (a * b);
                    return result;
                }
            }
        }
        return 0;
    }

    private List<Integer> getInput() {
        String fileName = "/home/karl.statz/src/advent_data/one.txt";

        return input.getFileLines(fileName).stream().map(l -> Integer.parseInt(l)).collect(Collectors.toList());

    }

}

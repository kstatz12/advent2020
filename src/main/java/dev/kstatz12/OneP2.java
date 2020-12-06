package dev.kstatz12;

import java.util.List;
import java.util.stream.Collectors;

public class OneP2 extends AbstractPuzzle<Integer> {

    public OneP2(AbstractInput input) {
        this.input = input;
    }

    private final AbstractInput input;

    @Override
    public Integer run() {
        List<Integer> inputs = getInput();
        return calc(inputs);
    }

    private Integer calc(List<Integer> inputs) {
        for (Integer a : inputs) {
            for (Integer b : inputs) {
                for (Integer c : inputs) {
                    if (a + b + c == 2020) {
                        Integer result = (a * b * c);
                        return result;
                    }
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

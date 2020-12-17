package dev.kstatz12;

import java.util.List;

public class Three extends AbstractPuzzle<Integer> {

    private final AbstractInput input;

    public Three(final AbstractInput input) {
        this.input = input;
    }

    @Override
    public Integer run() {
        final List<String> input = getInput();
        Integer rowLength = input.get(0).length();
        System.out.println(rowLength);
        return getRouteTrees(input, rowLength, 3);
    }

    private Integer getRouteTrees(final List<String> input, Integer rowLength, Integer moveLength) {
        Integer count = 0;
        Integer idx = 0;
        for (Integer i = 1; i < input.size(); i++) {

            idx = calculateIndex(idx, rowLength, moveLength);
            char c = input.get(i).toCharArray()[idx];
            if (c == '#') {
                count++;
            }

        }
        return count;
    }

    private Integer calculateIndex(Integer prevIndex, Integer rowLength, Integer moveLength) {
        Integer newIndex = (prevIndex + moveLength);
        if (newIndex >= rowLength) {
            // calculate overflow
            return newIndex - rowLength;
        }
        return newIndex;
    }

    private List<String> getInput() {
        final String fileName = "/home/karl.statz/src/advent_data/three.txt";
        return input.getFileLines(fileName);
    }
}

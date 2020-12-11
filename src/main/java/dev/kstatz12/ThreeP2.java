package dev.kstatz12;

import java.util.List;

public class ThreeP2 extends AbstractPuzzle<Integer> {

    private AbstractInput input;

    public ThreeP2(AbstractInput input) {
        this.input = input;

    }

    @Override
    public Integer run() {
        final List<String> inputs = getInput();
        Integer rowLength = inputs.get(0).length();
        Integer oneByOne = getRouteTrees(inputs, rowLength, 1);
        Integer threeByOne = getRouteTrees(inputs, rowLength, 3);
        Integer fiveByOne = getRouteTrees(inputs, rowLength, 5);
        Integer sevenByOne = getRouteTrees(inputs, rowLength, 7);
        Integer oneByTwo = getRouteTreesEvens(inputs, rowLength, 1);
        return oneByOne * threeByOne * fiveByOne * sevenByOne * oneByTwo;
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

    private Integer getRouteTreesEvens(final List<String> input, Integer rowLength, Integer moveLength) {
        Integer count = 0;
        Integer idx = 0;
        for (Integer i = 2; i < input.size(); i++) {

            // skip the first row or odd rows
            if (i % 2 == 0) {

                idx = calculateIndex(idx, rowLength, moveLength);
                char c = input.get(i).toCharArray()[idx];
                if (c == '#') {
                    count++;
                }
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

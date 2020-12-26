package dev.kstatz12;

import java.util.ArrayList;
import java.util.List;

public class Six extends AbstractPuzzle<Long> {

    private AbstractInput input;

    public Six(AbstractInput input) {
        this.input = input;

    }

    @Override
    public Long run() {
        return getInput().stream().map(x -> {
            List<List<String>> ret = new ArrayList<>();

            List<String> group = new ArrayList<>();
            if (x.equals("")) {
                ret.add(group);
                group.clear();
            }
            group.add(x);

            return ret;
            }).flatMap(List::stream).map(y -> y.stream().reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                            .toString().chars().distinct().count()).mapToLong(x -> x).sum();
    }

    private List<String> getInput() {
        final String fileName = "/home/karl.statz/src/advent_data?six.txt";
        return input.getFileLines(fileName);
    }

}

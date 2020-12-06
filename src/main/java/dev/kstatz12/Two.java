package dev.kstatz12;

import java.util.List;
import java.util.stream.Collectors;

public class Two extends AbstractPuzzle<Integer> {

    private final AbstractInput input;

    public Two(final AbstractInput input) {
        this.input = input;

    }

    @Override
    public Integer run() {
        final List<String> inputs = getInput();
        return countInvalidPasswords(inputs);
    }

    private List<String> getInput() {
        final String fileName = "/home/karl.statz/src/advent_data/two.txt";
        return input.getFileLines(fileName);
    }

    private Input parse(final String str) {
        String[] chunks = str.split(" ");

        // work on first chunk
        String rawLimits = chunks[0];

        String[] limitChunks = rawLimits.split("-");
        Integer min = Integer.parseInt(limitChunks[0]);
        Integer max = Integer.parseInt(limitChunks[1]);

        char letter = chunks[1].charAt(0);

        String password = chunks[2];

        return new Input(min, max, letter, password);
    }

    private boolean validate(final Input input) {
        if(input == null) {
            return false;
        }
        final Integer charCount = countChar(input.getPassword(), input.getLetter());
        if (charCount >= input.getMin() && charCount <= input.getMax()) {
            return true;
        }
        return false;
    }

    private Integer countChar(final String input, final char letter) {
        final char[] arry = input.toCharArray();
        Integer count = 0;
        for (final char element : arry) {
            if (element == letter) {
                count++;
            }
        }
        return count;
    }

    private Integer countInvalidPasswords(final List<String> input) {
        return input.stream().filter(x -> validate(parse(x))).collect(Collectors.toList()).size();
    }

    private class Input {
        private final Integer min;
        private final Integer max;
        private final char letter;
        private final String password;

        public Integer getMin() {
            return min;
        }

        public String getPassword() {
            return password;
        }

        public char getLetter() {
            return letter;
        }

        public Integer getMax() {
            return max;
        }

        public Input(final Integer min, final Integer max, final char letter, final String password) {
            this.min = min;
            this.max = max;
            this.letter = letter;
            this.password = password;
        }
    }

}

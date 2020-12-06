package dev.kstatz12;

import static java.lang.System.out;

import java.util.List;
import java.util.stream.Collectors;

public class TwoP2 extends AbstractPuzzle<Integer> {

    private final AbstractInput input;

    public TwoP2(final AbstractInput input) {
        this.input = input;

    }

    @Override
    public Integer run() {
        List<String> inputs = getInput();
        return countValidPasswords(inputs);
    }

    private Input parse(final String str) {
        String[] chunks = str.split(" ");

        // work on first chunk
        String rawLimits = chunks[0];

        String[] posChunks = rawLimits.split("-");
        Integer firstPos = Integer.parseInt(posChunks[0]);
        Integer secondPos = Integer.parseInt(posChunks[1]);

        char letter = chunks[1].charAt(0);

        String password = chunks[2];

        return new Input(firstPos, secondPos, letter, password);
    }

    private boolean validate(final Input input) {
        if (input == null) {
            return false;
        }

        Integer firstPos = input.getFirstPos() - 1;
        Integer secondPos = input.getSecondPos() - 1;


        char firstPosChar = safeCharAt(input.getPassword(), firstPos);
        char secondPosChar = safeCharAt(input.getPassword(), secondPos);

        Integer matchCount = 0;
        if(firstPosChar == input.getLetter()) {
            matchCount++;
        }

        if(secondPosChar == input.getLetter()) {
            matchCount++;
        }

        return matchCount == 1;
    }

    private char safeCharAt(String input, Integer idx) {
        if(idx > input.length()){
            return '\u0000'; //null char
        }
        return input.charAt(idx);
    }

    private Integer countValidPasswords(final List<String> input) {
        return input.stream().filter(x -> validate(parse(x))).collect(Collectors.toList()).size();
    }

    private List<String> getInput() {
        final String fileName = "/home/karl.statz/src/advent_data/two.txt";
        return input.getFileLines(fileName);
    }

    private class Input {
        private final Integer firstPos;
        private final Integer secondPos;
        private final char letter;
        private final String password;

        public Integer getFirstPos() {
            return firstPos;
        }

        public String getPassword() {
            return password;
        }

        public char getLetter() {
            return letter;
        }

        public Integer getSecondPos() {
            return secondPos;
        }

        public Input(final Integer firstPos, final Integer secondPos, final char letter, final String password) {
            this.firstPos = firstPos;
            this.secondPos = secondPos;
            this.letter = letter;
            this.password = password;
        }
    }
}

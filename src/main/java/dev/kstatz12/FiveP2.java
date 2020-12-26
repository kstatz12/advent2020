package dev.kstatz12;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FiveP2 extends AbstractPuzzle<Integer> {

    private final AbstractInput input;

    public FiveP2(AbstractInput input){
        this.input = input;
    }

	@Override
	public Integer run() {
        List<Integer> seatIds = getInput().stream()
            .map(x -> getSeatId(x))
            .collect(Collectors.toList());
        IntStream range = IntStream.rangeClosed(seatIds.stream()
                              .mapToInt(x -> x)
                              .min()
                              .orElseThrow(NoSuchElementException::new),
                              seatIds.size() + 1);

        return range.boxed().filter(x -> !seatIds.contains(x)).collect(Collectors.toList()).get(0);
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

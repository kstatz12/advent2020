package dev.kstatz12;

import java.util.Arrays;
import java.util.List;

public class MockInputThree extends AbstractInput {

	@Override
	public List<String> getFileLines(String fileName) {
        return Arrays.asList("..##.......",
                             "#...#...#..",
                             ".#....#..#.",
                             "..#.#...#.#",
                             ".#...##..#.",
                             "..#.##.....",
                             ".#.#.#....#",
                             ".#........#",
                             "#.##...#...",
                             "#...##....#",
                             ".#..#...#.#");
	}

}

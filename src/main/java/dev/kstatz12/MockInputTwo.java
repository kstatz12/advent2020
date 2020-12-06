package dev.kstatz12;

import java.util.Arrays;
import java.util.List;

public class MockInputTwo extends AbstractInput {

	@Override
	public List<String> getFileLines(String fileName) {
        return Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
	}

}

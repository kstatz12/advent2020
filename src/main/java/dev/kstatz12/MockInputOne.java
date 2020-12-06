package dev.kstatz12;

import java.util.Arrays;
import java.util.List;

public class MockInputOne extends AbstractInput {

    @Override
    public List<String> getFileLines(String fileName) {
        return Arrays.asList("1721", "979", "366", "299", "675", "1456");
    }

}

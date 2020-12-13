package dev.kstatz12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Four extends AbstractPuzzle<Integer> {

    private final AbstractInput input;

    public Four(AbstractInput input) {
        this.input = input;
    }

    @Override
    public Integer run() {
        List<String> result = getInput();
        List<String> validEntites = parse(result);
        return validEntites.size();
    }

    private List<String> getInput() {
        final String fileName = "/home/karl.statz/src/advent_data/four.txt";
        return input.getFileLines(fileName);
    }

    private List<String> parse(List<String> input) {
        StringBuilder sb = new StringBuilder();
        List<String> ret = new ArrayList<>();
        for (String i : input) {
            if (i.equals("")) {
                String flattened = sb.toString();
                sb = new StringBuilder();
                if (validate(flattened)) {
                    ret.add(flattened);
                }
            } else {
                sb.append(" ").append(i);
            }
        }
        //handle last since the buffer will have at least one line left.
        String last = sb.toString();
        if(validate(last)) {
            ret.add(last);
        }
        return ret;
    }

    private boolean validate(String str) {
        String[] chunks = str.split(" ");
        Map<String, String> vals = toMap(chunks);
        return validate(vals);
    }

    private boolean validate(Map<String, String> map) {
        if (!map.containsKey("byr")) {
            return false;
        }
        if (!map.containsKey("iyr")) {
            return false;
        }
        if (!map.containsKey("eyr")) {
            return false;
        }
        if (!map.containsKey("hgt")) {
            return false;
        }
        if (!map.containsKey("hcl")) {
            return false;
        }
        if (!map.containsKey("ecl")) {
            return false;
        }
        if (!map.containsKey("pid")) {
            return false;
        }
        return true;
    }

    private Map<String, String> toMap(String[] chunks) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < chunks.length; i++) {
            String chunk = chunks[i];
            System.out.println(chunk);
            String[] pair = chunk.split(":");
            if (pair.length == 2) {

                map.put(pair[0], pair[1]);
            }
        }
        return map;
    }

}

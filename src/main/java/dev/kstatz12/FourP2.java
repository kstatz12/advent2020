package dev.kstatz12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FourP2 extends AbstractPuzzle<Integer> {

    private final List<String> eyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
    private final AbstractInput input;

    public FourP2(final AbstractInput input) {
        this.input = input;

    }

    @Override
    public Integer run() {
        final List<String> inputs = getInput();
        final List<String> results = parse(inputs);
        return results.size();
    }

    private List<String> getInput() {
        final String fileName = "/home/karl.statz/src/advent_data/four.txt";
        return input.getFileLines(fileName);
    }

    private List<String> parse(final List<String> input) {
        StringBuilder sb = new StringBuilder();
        final List<String> ret = new ArrayList<>();
        for (final String i : input) {
            if (i.equals("")) {
                final String flattened = sb.toString();
                sb = new StringBuilder();
                if (validate(flattened)) {
                    ret.add(flattened);
                }
            } else {
                sb.append(" ").append(i);
            }
        }
        // handle last since the buffer will have at least one line left.
        final String last = sb.toString();
        if (validate(last)) {
            ret.add(last);
        }
        return ret;
    }

    private boolean validate(final String str) {
        final String[] chunks = str.split(" ");
        final Map<String, String> vals = toMap(chunks);
        return validate(vals);
    }

    private boolean validate(final Map<String, String> map) {
        if (!validateBirthYear(map)) {
            System.out.println("Birth year Invalid");
            return false;
        }
        if (!validateIssueYear(map)) {
            System.out.println("Issue Year Invalid");
            return false;
        }
        if (!validateExpirationYear(map)) {
            System.out.println("Expiriation Year Invalid");
            return false;
        }
        if (!validateHeight(map)) {
            System.out.println("Height Invalid");
            return false;
        }
        if (!validateHairColor(map)) {
            System.out.println("Hair Color Invalid");
            return false;
        }
        if (!validateEyeColor(map)) {
            System.out.println("Eye Color Invalid");
            return false;
        }
        if (!validatePid(map)) {
            System.out.println("Invalid PID");
            return false;
        }
        return true;
    }

    // tonns of small methods for validating. keeps my brains from scrambling
    private boolean validatePid(final Map<String, String> map) {
        if (!map.containsKey("pid")) {
            return false;
        }

        final String value = map.get("pid");

        if (value.length() != 9) {
            return false;
        }

        if (!isInteger(value)) {
            return false;
        }

        return true;
    }

    private boolean validateEyeColor(final Map<String, String> map) {
        if (!map.containsKey("ecl")) {
            return false;
        }

        final String value = map.get("ecl");

        return eyeColors.contains(value);
    }

    private boolean validateHairColor(final Map<String, String> map) {
        if (!map.containsKey("hcl")) {
            return false;
        }

        final String value = map.get("hcl");

        if (!(value.length() == 7)) {
            System.out.printf("Value Not 7 characters long");
            return false;
        }

        if (!value.startsWith("#")) {
            System.out.println("Does not start with #");
            return false;
        }

        final String hex = value.substring(1);

        System.out.println(hex);

        final String pattern = "^[a-fA-F0-9]+$";

        final Pattern r = Pattern.compile(pattern);

        final Matcher m = r.matcher(hex);

        return m.find();
    }

    private boolean validateHeight(final Map<String, String> map) {
        if (!map.containsKey("hgt")) {
            return false;
        }
        final String value = map.get("hgt");

        if (value.endsWith("cm")) {
            return validateIntegerPrefix(value, "c");
        } else if (value.endsWith("in")) {
            return validateIntegerPrefix(value, "i");
        }
        return false;
    }

    private boolean validateIntegerPrefix(final String input, final String endChar) {
        final String prefix = input.substring(0, input.indexOf(endChar));

        if (!isInteger(prefix)) {
            return false;
        }
        if (endChar.equals("c")) {
            return isBetween(Integer.parseInt(prefix), 150, 193);
        } else {
            return isBetween(Integer.parseInt(prefix), 59, 76);
        }
    }

    private boolean validateExpirationYear(final Map<String, String> map) {
        if (!map.containsKey("eyr")) {
            return false;
        }

        final String value = map.get("eyr");

        if (value.length() != 4) {
            return false;
        }

        if (!isInteger(value)) {
            return false;
        }

        if (!isBetween(Integer.parseInt(value), 2020, 2030)) {
            return false;
        }

        return true;

    }

    private boolean validateIssueYear(final Map<String, String> map) {
        if (!map.containsKey("iyr")) {
            return false;
        }
        final String value = map.get("iyr");

        if (value.length() != 4) {
            return false;
        }

        if (!isInteger(value)) {
            return false;
        }

        if (!isBetween(Integer.parseInt(value), 2010, 2020)) {
            return false;
        }

        return true;
    }

    private boolean validateBirthYear(final Map<String, String> map) {

        if (!map.containsKey("byr")) {
            System.out.printf("Key Missing %s\n", "byr");
            return false;
        }

        final String value = map.get("byr");

        if (value.length() != 4) {
            System.out.println("value length not 4");
            return false;
        }

        if (!isInteger(value)) {
            return false;
        }

        if (!isBetween(Integer.parseInt(value), 1920, 2002)) {
            return false;
        }

        return true;
    }

    private boolean isInteger(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            System.out.printf("Failed Because %s Not A Number\n", input);
            return false;
        }
    }

    private boolean isBetween(final Integer input, final Integer lower, final Integer upper) {

        if (input > upper || input < lower) {
            System.out.printf("%d Not Between %d and %d \n", input, lower, upper);
            return false;
        }
        return true;
    }

    private Map<String, String> toMap(final String[] chunks) {
        final Map<String, String> map = new HashMap<>();
        for (int i = 0; i < chunks.length; i++) {
            final String chunk = chunks[i];
            final String[] pair = chunk.split(":");
            if (pair.length == 2) {

                map.put(pair[0], pair[1]);
            }
        }
        return map;
    }

}

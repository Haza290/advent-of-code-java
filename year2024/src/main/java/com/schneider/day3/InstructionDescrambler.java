package com.schneider.day3;

import com.schneider.util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionDescrambler {

    public static void main(String[] args) {
        try {
            File testFile = new File(InstructionDescrambler.class.getClassLoader().getResource("day3/input.txt").toURI());
            String string = ReadFile.fileToString(testFile);
            System.out.println(process(string));
            System.out.println(complexProcess(string));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static int process(String scrambledInstruction) {
        Pattern pattern = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");
        Matcher matcher = pattern.matcher(scrambledInstruction);
        int total = 0;
        while (matcher.find()) {
            String[] split = matcher.group(0).substring(4, matcher.group(0).length() - 1).split(",");
            total += (Integer.parseInt(split[0]) * Integer.parseInt(split[1]));
        }
        return total;
    }

    public static int complexProcess(String scrambledInstruction) {
        Pattern doPattern = Pattern.compile("do\\(\\)");
        Pattern dontPattern = Pattern.compile("don't\\(\\)");

        String string = "";

        while (true) {
            Matcher dontMatcher = dontPattern.matcher(scrambledInstruction);
            if (dontMatcher.find()) {
                int ignoreStart = dontMatcher.start();
                string = string + scrambledInstruction.substring(0, ignoreStart);
                scrambledInstruction = scrambledInstruction.substring(ignoreStart);
            } else {
                return process(string + scrambledInstruction);
            }
            Matcher doMatcher = doPattern.matcher(scrambledInstruction);
            if (doMatcher.find()) {
                int ignoreEnd = doMatcher.start();
                scrambledInstruction = scrambledInstruction.substring(ignoreEnd);
            } else {
                return process(string);
            }
        }

    }

}

package com.schneider.day7;


import com.schneider.day3.InstructionDescrambler;
import com.schneider.util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class EquationsChecker {

    public static void main(String[] args) {
        try {
            File testFile = new File(EquationsChecker.class.getClassLoader().getResource("day7/input.txt").toURI());
            List<String> strings = ReadFile.toStringList(testFile);
            List<Equation> equations = strings.stream().map(EquationsChecker::stringToEquation).toList();
            System.out.println(EquationsChecker.sumTotalsOfPossibleEquations(equations));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    private static Equation stringToEquation(String string) {
        String[] split = string.split(": ");
        return new Equation(Long.parseLong(split[0]), Arrays.stream(split[1].split(" ")).map(Long::parseLong).toList());
    }

    public static Long sumTotalsOfPossibleEquations(List<Equation> equations) {
        return equations.stream().filter(Equation::isPossible).mapToLong(Equation::getTotal).sum();
    }

}

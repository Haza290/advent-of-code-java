package com.schneider.day2;

import com.schneider.util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReactorSafety {
    public static void main(String[] args) {
        try {
            File testFile = new File(ReactorSafety.class.getClassLoader().getResource("day2/input.txt").toURI());
            List<List<Integer>> reports = ReadFile.toListOfIntegerList(testFile);

            long numberOfSafeRectors = reports.stream().filter(report -> isSafeWithFailureTolerance(report, 0)).count();
            System.out.println("Number of safe reactors with no failure tolerance: " + numberOfSafeRectors);

            numberOfSafeRectors = reports.stream().filter(report -> isSafeWithFailureTolerance(report, 1)).count();
            System.out.println("Number of safe reactors with 1 failure tolerance: " + numberOfSafeRectors);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static SafetyCheck checkIfSafe(List<Integer> report) {
        boolean isIncreasing = report.get(0) < report.get(1);
        for (int i = 0; i < report.size() - 1; i++) {
            // if 2 sequential integers are the same then reactor is unsafe
            if (Objects.equals(report.get(i), report.get(i + 1))) return new SafetyCheck(false, i);
            // if 2 sequential integers don't follow the trend of either increasing or decreasing then reactor is unsafe
            if ((report.get(i) > report.get(i + 1) == isIncreasing)) return new SafetyCheck(false, i);
            // if 2 sequential integers are different by more than 3 then reactor is unsafe
            if (Math.abs(report.get(i) - report.get(i + 1)) > 3) return new SafetyCheck(false, i);
        }
        return new SafetyCheck(true, null);
    }

    public static boolean isSafeWithFailureTolerance(List<Integer> report, Integer tolerance) {
        if (report.size() <= tolerance) {
            return true;
        }
        if (tolerance == 0) {
            return checkIfSafe(report).isSafe;
        }
        SafetyCheck safetyCheck = checkIfSafe(report);
        if (safetyCheck.isSafe) {
            return true;
        }
        ArrayList<Integer> newReport1 = new ArrayList<>(report);
        ArrayList<Integer> newReport2 = new ArrayList<>(report);
        ArrayList<Integer> newReport3 = new ArrayList<>(report);
        // This needs to be cast at a int as remove(Integer) will try to remove any elements that match the Integer
        // instead of removing the nth element.
        newReport1.remove((int) safetyCheck.failurePoint);
        newReport2.remove(safetyCheck.failurePoint + 1);
        if (safetyCheck.failurePoint > 0) {
            newReport3.remove(safetyCheck.failurePoint - 1);
        }
        return isSafeWithFailureTolerance(newReport1, tolerance - 1)
                || isSafeWithFailureTolerance(newReport2, tolerance - 1)
                || (safetyCheck.failurePoint > 0) && (isSafeWithFailureTolerance(newReport3, tolerance - 1));
    }

    public record SafetyCheck(boolean isSafe, Integer failurePoint) {}
}

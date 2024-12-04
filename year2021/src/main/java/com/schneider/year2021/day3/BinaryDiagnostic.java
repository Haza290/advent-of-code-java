package com.schneider.year2021.day3;

import com.schneider.util.ReadFile;
import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class BinaryDiagnostic {

    public static void main(String[] args) {
        try {
            File testFile = new File(BinaryDiagnostic.class.getClassLoader().getResource("day3/input.txt").toURI());
            int answer = BinaryDiagnostic.diagnose(testFile);
            System.out.println(answer);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static int diagnose(File file) {
        List<String> list = ReadFile.toStringList(file);
        int stringLength = list.get(0).length();
        StringBuilder binaryStringBuilder = new StringBuilder();
        StringBuilder invertedBinaryStringBuilder = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            int finalI = i;
            int sum = list.stream()
                    .map(s -> s.charAt(finalI))
                    .mapToInt(c -> Integer.parseInt(c.toString()))
                    .sum();
            if(sum >= list.size()/2) {
                binaryStringBuilder.append("1");
                invertedBinaryStringBuilder.append("0");
            } else {
                binaryStringBuilder.append("0");
                invertedBinaryStringBuilder.append("1");
            }
        }

        int gamma = Integer.parseInt(binaryStringBuilder.toString(), 2);
        int epsilon = Integer.parseInt(invertedBinaryStringBuilder.toString(), 2);

        return gamma * epsilon;
    }
}

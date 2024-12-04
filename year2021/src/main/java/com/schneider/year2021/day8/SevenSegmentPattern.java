package com.schneider.year2021.day8;

import lombok.*;

import java.util.*;

@RequiredArgsConstructor
public class SevenSegmentPattern {

    private final String pattern;

    public long getOutputValue() {
        String[] inputs = this.pattern.substring(0, this.pattern.indexOf("|")).split(" ");
        String[] outputs = this.pattern.substring(this.pattern.indexOf("|") + 1).split(" ");
        StringBuilder signalOuput = new StringBuilder();
        for (String ouput : outputs) {
            // 1
            if(ouput.length() == 2) {
                signalOuput.append(1);
            }
            // 7
            else if(ouput.length() == 3) {
                signalOuput.append(7);
            }
            // 4
            else if(ouput.length() == 4) {
                signalOuput.append(4);
            }
            // 8
            else if(ouput.length() == 7) {
                signalOuput.append(8);
            }
            // 2,3,5
            else if(ouput.length() == 5) {
                String oneSignal = Arrays.stream(inputs).filter(s -> s.length() == 2).findAny().get();
                if(containsAllChars(ouput, oneSignal)) {
                    signalOuput.append(3);
                } else if(containsAllChars(getNineSignal(inputs), ouput)){
                    signalOuput.append(5);
                } else {
                    signalOuput.append(2);
                }
            }
            // 6,9,0
            else if(ouput.length() == 6) {
                String oneSignal = Arrays.stream(inputs).filter(s -> s.length() == 2).findAny().get();
                String fourSignal = Arrays.stream(inputs).filter(s -> s.length() == 4).findAny().get();
                if(containsAllChars(ouput, fourSignal)) {
                    signalOuput.append(9);
                } else if(containsAllChars(ouput, oneSignal)) {
                    signalOuput.append(0);
                } else {
                    signalOuput.append(6);
                }
            }
        }
        return Long.parseLong(signalOuput.toString());
    }

    private static String getNineSignal(String[] inputs) {
        String fourSignal = Arrays.stream(inputs).filter(s -> s.length() == 4).findAny().get();
        return Arrays.stream(inputs).filter(s -> s.length() == 6).filter(s -> containsAllChars(s, fourSignal)).findAny().get();
    }

    private static boolean containsAllChars(String container, String containee) {
        return stringToCharacterSet(container).containsAll(stringToCharacterSet(containee));
    }

    public static Set<Character> stringToCharacterSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public int count147and8() {
        String[] outputs = this.pattern.substring(this.pattern.indexOf("|") + 1).split(" ");
        return (int) Arrays.stream(outputs)
                .filter(s -> s.length() == 2 || s.length() == 4 || s.length() == 3 || s.length() == 7)
                .count();
    }
}

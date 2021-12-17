package day8;

import lombok.*;

import java.util.*;

@RequiredArgsConstructor
public class SevenSegmentPattern {

    private final String pattern;

    public int count147and8() {
        String[] outputs = this.pattern.substring(this.pattern.indexOf("|") + 1).split(" ");
        return (int) Arrays.stream(outputs)
                .filter(s -> s.length() == 2 || s.length() == 4 || s.length() == 3 || s.length() == 7)
                .count();
    }
}

package day8;

import util.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class SevenSegmentSearch {

    private final List<SevenSegmentPattern> patterns;

    public static void main(String[] args) throws URISyntaxException {
        File testFile = new File(SevenSegmentSearch.class.getResource("/day8/input.txt").toURI());

        System.out.println(new SevenSegmentSearch(testFile).count1478Outputs());
        System.out.println(new SevenSegmentSearch(testFile).sumOutputs());
    }

    public SevenSegmentSearch(File signalsFile) {
        this.patterns = ReadFile.toStringList(signalsFile).stream().map(SevenSegmentPattern::new).toList();
    }

    public int count1478Outputs() {
        return this.patterns.stream().mapToInt(SevenSegmentPattern::count147and8).sum();
    }

    public long sumOutputs() {
        return this.patterns.stream().map(SevenSegmentPattern::getOutputValue).reduce(0L, Long::sum);
    }
}

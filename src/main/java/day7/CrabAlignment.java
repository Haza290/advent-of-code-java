package day7;

import util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrabAlignment {

    public static int findOptimalAttackPoint(List<Integer> crabPositions) {
        int max = crabPositions.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = crabPositions.stream().mapToInt(Integer::intValue).min().getAsInt();

        HashMap<Integer, Long> crabPositionsFrequencyMap = crabPositions.stream()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        return IntStream.rangeClosed(min, max).map(i -> crabPositionsFrequencyMap.keySet().stream().reduce(0, (subtotal, element) -> Math.toIntExact(subtotal + ((Math.abs(i - element) * (Math.abs(i - element) + 1)) / 2) * crabPositionsFrequencyMap.get(element)))).min().getAsInt();


//        Integer optimalAttackPoint = IntStream.rangeClosed(min, max).boxed().min((i, j) -> Integer.compare(
//                crabPositionsFrequencyMap.keySet().stream().reduce(0, (subtotal, element) -> Math.toIntExact(subtotal + ((Math.abs(element - i) * crabPositionsFrequencyMap.get(element))))),
//                crabPositionsFrequencyMap.keySet().stream().reduce(0, (subtotal, element) -> Math.toIntExact(subtotal + ((Math.abs(element - j) * crabPositionsFrequencyMap.get(element))))))
//        ).get();
//
//        return crabPositionsFrequencyMap.keySet().stream().reduce(0, (subtotal, element) -> Math.toIntExact(subtotal + ((Math.abs(element - optimalAttackPoint) * crabPositionsFrequencyMap.get(element)))));
    }

    public static void main(String[] args) throws URISyntaxException {
        File testFile = new File(CrabAlignment.class.getResource("/day7/input.txt").toURI());
        List<Integer> crabPositions = Arrays.stream(ReadFile.toStringList(testFile).get(0).split(",")).map(Integer::parseInt).toList();
        System.out.println(CrabAlignment.findOptimalAttackPoint(crabPositions));
    }
    
}

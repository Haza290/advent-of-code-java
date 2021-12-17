package day5;

import util.ReadFile;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class HydrothermalVenture {

    public static int pointsWithMultipleHitsCount(File file, boolean axialOnly) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        ReadFile.toStringList(file).stream()
                .map(Line::new)
                .filter(l -> l.isAxial() || !axialOnly)
                .forEach(l -> coordinates.addAll(l.getCoordinates()));

        Map<Coordinate, Long> coordinatesFrequency = coordinates.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return (int) coordinatesFrequency.keySet().stream().filter(k -> coordinatesFrequency.get(k) > 1).count();
    }

    public static void main(String[] args) throws URISyntaxException {
        File testFile = new File(HydrothermalVenture.class.getResource("/day5/input.txt").toURI());
        System.out.println(HydrothermalVenture.pointsWithMultipleHitsCount(testFile, true));
        System.out.println(HydrothermalVenture.pointsWithMultipleHitsCount(testFile, false));
    }

}

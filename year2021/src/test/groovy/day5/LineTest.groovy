package day5

import com.schneider.year2021.day5.Coordinate
import com.schneider.year2021.day5.Line
import spock.lang.Specification

class LineTest extends Specification {

    def "Get the coordinates from a vertical line" () {
        given: "I have a vertical line"
        Line line = new Line("1,1 -> 1,3")
        when: "I calculate the points on that line"
            ArrayList<Coordinate> coordinates = line.getCoordinates()
        then: "I get the correct list of coordinates"
            coordinates.size() == 3
            coordinates.contains(new Coordinate(1,1))
            coordinates.contains(new Coordinate(1,2))
            coordinates.contains(new Coordinate(1,3))
    }

    def "Get the coordinates from a horizontal line" () {
        given: "I have a horizontal line"
            Line line = new Line("9,7 -> 7,7")
        when: "I calculate the points on that line"
            ArrayList<Coordinate> coordinates = line.getCoordinates()
        then: "I get the correct list of coordinates"
            coordinates.size() == 3
            coordinates.contains(new Coordinate(9,7))
            coordinates.contains(new Coordinate(8,7))
            coordinates.contains(new Coordinate(7,7))
    }

    def "Get the coordinates from a diagonal line" () {
            given: "I have a diagonal line"
        Line line = new Line("1,1 -> 3,3")
            when: "I calculate the points on that line"
            ArrayList<Coordinate> coordinates = line.getCoordinates()
        then: "I get the correct list of coordinates"
            coordinates.size() == 3
            coordinates.contains(new Coordinate(1,1))
            coordinates.contains(new Coordinate(2,2))
            coordinates.contains(new Coordinate(3,3))
    }

    def "Get the coordinates from a diagonal line2" () {
        given: "I have a diagonal line"
        Line line = new Line("9,7 -> 7,9")
        when: "I calculate the points on that line"
        ArrayList<Coordinate> coordinates = line.getCoordinates()
        then: "I get the correct list of coordinates"
        coordinates.size() == 3
        coordinates.contains(new Coordinate(9,7))
        coordinates.contains(new Coordinate(8,8))
        coordinates.contains(new Coordinate(7,9))
    }

    def "Check that a vertical line is axial"() {
        given: "A vertical line"
            Line line = new Line("1,1 -> 1,3")
        when: "I check that the line is axial"
            boolean isAxial = line.isAxial()
        then: "I get true"
            isAxial
    }

    def "Check that a horizontal line is axial"() {
        given: "A horizontal line"
            Line line = new Line("9,7 -> 7,7")
        when: "I check that the line is axial"
            boolean isAxial = line.isAxial()
        then: "I get true"
            isAxial
    }

    def "Check that a non axial line is axial"() {
        given: "A non axial line"
            Line line = new Line("1,1 -> 9,3")
        when: "I check that the line is axial"
            boolean isAxial = line.isAxial()
        then: "I get false"
            !isAxial
    }
}

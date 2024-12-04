package com.schneider.day1

import spock.lang.Specification


class LocationListComparisonSpec extends Specification {
    def "Test distance between lists"() {
        given: "Two lists"
        List<Integer> list1 = Arrays.asList(3, 4, 2, 1, 3, 3)
        List<Integer> list2 = Arrays.asList(4, 3, 5, 3, 9, 3)

        when: "I compare the lists"
        int difference = LocationListComparison.compare(list1, list2)

        then: "I get the correct difference"
        difference == 11
    }

    def "Test frequency of id's"() {
        given: "Two lists of id's"
        List<Integer> list1 = Arrays.asList(3, 4, 2, 1, 3, 3)
        List<Integer> list2 = Arrays.asList(4, 3, 5, 3, 9, 3)

        when: "I sum the values of the id's in the first list multiplied by their frequency in the second list"
        int total = LocationListComparison.sumOfIdsTimesFrequency(list1, list2);

        then: "I get the correct answer"
        total == 31
    }
}

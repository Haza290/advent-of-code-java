package com.schneider.day2

import day2.ReactorSafety
import spock.lang.Specification

class ReactorSafetySpec extends Specification {
    def "Test multiple reactor reports with basic safety"() {
        given: "a reactor report"

        when: "I check if it is safe"
        boolean isSafe = ReactorSafety.isSafeWithFailureTolerance(report, 0)

        then: "I get the correct answer"
        isSafe == expectedIsSafe

        where:
        report                       || expectedIsSafe
        Arrays.asList(7, 6, 4, 2, 1) || true
        Arrays.asList(1, 2, 7, 8, 9) || false
        Arrays.asList(9, 7, 6, 2, 1) || false
        Arrays.asList(1, 3, 2, 4, 5) || false
        Arrays.asList(8, 6, 4, 4, 1) || false
        Arrays.asList(1, 3, 6, 7, 9) || true
        Arrays.asList(1, 3, 6, 7, 9) || true

    }

    def "Test multiple reactor reports with single failure tolerance"() {
        given: "a reactor report"

        when: "I check if it is safe with single failure tolerance"
        boolean isSafe = ReactorSafety.isSafeWithFailureTolerance(report, 1)

        then: "I get the correct answer"
        isSafe == expectedIsSafe

        where:
        report                                    || expectedIsSafe
        Arrays.asList(7, 6, 4, 2, 1)              || true
        Arrays.asList(1, 2, 7, 8, 9)              || false
        Arrays.asList(9, 7, 6, 2, 1)              || false
        Arrays.asList(1, 3, 2, 4, 5)              || true
        Arrays.asList(8, 6, 4, 4, 1)              || true
        Arrays.asList(1, 3, 6, 7, 9)              || true
        Arrays.asList(56, 59, 60, 61, 63, 66, 73) || true
        Arrays.asList(41, 45, 47, 48, 50)         || true


    }
}

package com.schneider.day6

import spock.lang.Specification

class GuardTrackingSpec extends Specification {

    def "Count number of distinct positions the guard will visit"() {
        given: "A map"
        def map = List.of("....#.....", ".........#", "..........", "..#.......",
                ".......#..", "..........", ".#..^.....", "........#.", "#.........", "......#...")

        when: "We calculate the number of distinct positions the guard will visit"
        def count = new GuardTracking().getDistinctGuardPositionsCount(map)

        then: "We get the correct value"
        count == 41
    }

    def "Count how many loops we can create by adding 1 more blocker"() {
        given: "A map"
        def map = List.of("....#.....", ".........#", "..........", "..#.......",
                ".......#..", "..........", ".#..^.....", "........#.", "#.........", "......#...")

        when: "We how many loops we can create by adding 1 more blocker"
        def count = new GuardTracking().countLoopsCreatedByAddingBlocker(map)

        then: "We get the correct value"
        count == 6
    }
}

package com.schneider.day4

import spock.lang.Specification

class XmasSearchSpec extends Specification{

    def "Count the number of MAS x's in the word search"() {
        given: "a word search"
        List<String> WordSearchBoard = Arrays.asList(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        )
        when: "I search of 'XMAS'"
        def count = XmasSearch.count(WordSearchBoard)

        then: "I get the correct count"
        count == 9
    }
}

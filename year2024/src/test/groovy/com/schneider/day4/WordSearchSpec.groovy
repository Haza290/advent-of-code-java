package com.schneider.day4

import spock.lang.Specification

class WordSearchSpec extends Specification {

    def "Count the number of 'XMAS' in the word search"() {
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
        def count = WordSearch.count(WordSearchBoard, 'XMAS')

        then: "I get the correct count"
        count == 18
    }
}

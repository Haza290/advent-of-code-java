package com.schneider

import com.schneider.util.ReadFile
import spock.lang.Specification

class ReadFileTest extends Specification {

    def "Read file to String array"() {
        given: "That I have a file with multiple text lines"
            File testFile = new File(getClass().getResource('/MultiLineFile.txt').toURI())
        when: "I read the file into a list"
            List<String> actualList = ReadFile.toStringList(testFile);
        then: "The list is created correctly"
            actualList == ["This is a test" , "It should work fine" , "Hello world" , ":) <3 & * \" \\" , "123456" , "" , "boo"]
    }

    def "Read file to Integer array"() {
        given: "That I have a file with multiple text lines"
            File testFile = new File(getClass().getResource('/MultiLineNumberFile.txt').toURI())
        when: "I read the file into a list"
            List<Integer> actualList = ReadFile.toIntegerList(testFile);
        then: "The list is created correctly"
            actualList == [123, 558, 0, 21, 12001]
    }
}

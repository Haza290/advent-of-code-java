package day3

import day3.BinaryDiagnostic
import spock.lang.Specification

class BinaryDiagnosticTest extends Specification {
    def "Test BinaryDiagnostic"() {
        given: "That I have an input file"
            File testFile = new File(getClass().getResource('/day3/testInput.txt').toURI())
        when: "I diagnose my input file"
            int actual = BinaryDiagnostic.diagnose(testFile)
        then: "I get the correct answer"
            actual == 198
    }

}

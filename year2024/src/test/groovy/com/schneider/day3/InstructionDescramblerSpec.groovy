package com.schneider.day3

import spock.lang.Specification

class InstructionDescramblerSpec extends Specification {
    def "Descramble instruction"() {
        given: "A scrambled instruction"
        def scrambledInstruction = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

        when: "I descramble and process it"
        def ans = InstructionDescrambler.process(scrambledInstruction);

        then: "I get the correct output"
        ans == 161
    }

    def "Descramble complex instruction"() {
        given: "A scrambled instruction"
        def scrambledInstruction = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        when: "I descramble and process it"
        def ans = InstructionDescrambler.complexProcess(scrambledInstruction);

        then: "I get the correct output"
        ans == 48
    }
}

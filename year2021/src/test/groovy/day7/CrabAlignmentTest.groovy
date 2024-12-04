package day7

import com.schneider.year2021.day7.CrabAlignment
import spock.lang.Specification

class CrabAlignmentTest extends Specification {
    def "Find the optimal attack point for a give set of carb positions"() {
        given: "I have some attack crabs"
            ArrayList<Integer> crabPositions = Arrays.asList(16,1,2,0,4,2,7,1,2,14)
        when: "I find the optimal attack point"
            int fuelNeeded = CrabAlignment.findOptimalAttackPoint(crabPositions)
        then: "It is correct"
            fuelNeeded == 37
    }
}

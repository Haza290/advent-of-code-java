package day6

import spock.lang.Specification

class LanternfishGrowthModelTest extends Specification {

    def "Calculate the number of Lanternfish after 18 days"() {
        given: "I have a starting set of Lanternfish"
            ArrayList<Integer> lanternfish = Arrays.asList(3,4,3,1,2)
        when: "I calculate the number of Lanternfish after 80 days"
            int numberOfLanternfish = LanternfishGrowthModel.calculateNumberOfLanternfish(lanternfish, 80)
        then: "I get the correct amount"
            numberOfLanternfish == 5934
    }
}

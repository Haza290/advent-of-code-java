package com.schneider.day5


import spock.lang.Specification

class PageOrderingRulesAndUpdatesReaderSpec extends Specification {

    def "Read page ordering rules and updates"() {
        given: "A txt file with page ordering rules and updates"
        File testFile = new File(getClass().getResource('/day5/PageOrderingRulesAndUpdates.txt').toURI())
        when: "I read the txt file"
        def pageOrderingRulesAndUpdates = PageOrderingRulesAndUpdatesReader.read(testFile)

        then: "I get the correct page ordering rules and updates"
        pageOrderingRulesAndUpdates.pageOrderingRule() == getExpectedPageOrderingRules()
        pageOrderingRulesAndUpdates.updates() == getExpectedUpdates()
    }

    private static getExpectedPageOrderingRules() {
        def expectedPageOrderingRules = new ArrayList<>()
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 53))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 13))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 61))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 47))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 29))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(61, 13))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 53))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(29, 13))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 29))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(53, 29))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(61, 53))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 53))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(61, 29))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 13))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 47))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 75))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 61))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 61))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 29))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 13))
        expectedPageOrderingRules.add(new UpdatesManager.PageOrderingRule(53, 13))
        return expectedPageOrderingRules
    }

    private static getExpectedUpdates() {
        ArrayList<ArrayList<Integer>> expectedUpdates = new ArrayList<>();
        expectedUpdates.add(List.of(75,47,61,53,29) as ArrayList<Integer>)
        expectedUpdates.add(List.of(97,61,53,29,13) as ArrayList<Integer>)
        expectedUpdates.add(List.of(75,29,13) as ArrayList<Integer>)
        expectedUpdates.add(List.of(75,97,47,61,53) as ArrayList<Integer>)
        expectedUpdates.add(List.of(61,13,29) as ArrayList<Integer>)
        expectedUpdates.add(List.of(97,13,75,29,47) as ArrayList<Integer>)
        return expectedUpdates
    }
}

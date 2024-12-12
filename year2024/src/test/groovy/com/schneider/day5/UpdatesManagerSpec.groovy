package com.schneider.day5


import spock.lang.Specification

class UpdatesManagerSpec extends Specification {

    def "sum the middle value of updates that pass all the page ordering rules"() {

        given: "A list of page ordering rules"
        ArrayList<UpdatesManager.PageOrderingRule> pageOrderingRules = getPageOrderingRules()

        and: "A list of updates"
        ArrayList<ArrayList<Integer>> updates = getUpdates()

        when: "We sum the middle value of updates that pass all the page ordering rules"
        int sum = UpdatesManager.sumMiddleValuesOfCorrectUpdates(pageOrderingRules, updates)

        then: "We get the correct value"
        sum == 143
    }

    def "sum the middle value of updates that don't pass all the page ordering rules"() {

        given: "A list of page ordering rules"
        ArrayList<UpdatesManager.PageOrderingRule> pageOrderingRules = getPageOrderingRules()

        and: "A list of updates"
        ArrayList<ArrayList<Integer>> updates = getUpdates()

        when: "We sum the middle value of updates that don't pass all the page ordering rules"
        int sum = UpdatesManager.sumMiddleValuesOfIncorrectUpdates(pageOrderingRules, updates)

        then: "We get the correct value"
        sum == 123
    }

    private static getPageOrderingRules() {
        ArrayList<UpdatesManager.PageOrderingRule> pageOrderingRules = new ArrayList<>()
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 53))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 13))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 61))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 47))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 29))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(61, 13))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 53))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(29, 13))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 29))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(53, 29))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(61, 53))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 53))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(61, 29))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 13))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 47))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(97, 75))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 61))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 61))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(47, 29))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(75, 13))
        pageOrderingRules.add(new UpdatesManager.PageOrderingRule(53, 13))
        pageOrderingRules
    }

    private static getUpdates() {
        ArrayList<ArrayList<Integer>> updates = new ArrayList<>();
        updates.add(List.of(75, 47, 61, 53, 29) as ArrayList<Integer>)
        updates.add(List.of(97, 61, 53, 29, 13) as ArrayList<Integer>)
        updates.add(List.of(75, 29, 13) as ArrayList<Integer>)
        updates.add(List.of(75, 97, 47, 61, 53) as ArrayList<Integer>)
        updates.add(List.of(61, 13, 29) as ArrayList<Integer>)
        updates.add(List.of(97, 13, 75, 29, 47) as ArrayList<Integer>)
        updates
    }
}

package com.schneider.day5;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UpdatesManager {

    public static void main(String[] args) {
        try {
            File testFile = new File(UpdatesManager.class.getClassLoader().getResource("day5/input.txt").toURI());
            PageOrderingRulesAndUpdatesReader.PageOrderingRulesAndUpdates pageOrderingRulesAndUpdates = PageOrderingRulesAndUpdatesReader.read(testFile);
            System.out.println(sumMiddleValuesOfCorrectUpdates(pageOrderingRulesAndUpdates.pageOrderingRule(), pageOrderingRulesAndUpdates.updates()));
            System.out.println(sumMiddleValuesOfIncorrectUpdates(pageOrderingRulesAndUpdates.pageOrderingRule(), pageOrderingRulesAndUpdates.updates()));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static int sumMiddleValuesOfCorrectUpdates(ArrayList<PageOrderingRule> pageOrderingRules, ArrayList<ArrayList<Integer>> updates) {
        return updates.stream()
                .filter(update -> isValidUpdate(pageOrderingRules, update))
                .mapToInt(update -> update.get((update.size() - 1) / 2))
                .sum();
    }

    public static int sumMiddleValuesOfIncorrectUpdates(ArrayList<PageOrderingRule> pageOrderingRules, ArrayList<ArrayList<Integer>> updates) {

        return updates.stream()
                .filter(update -> !isValidUpdate(pageOrderingRules, update))
                .map(update -> fixUpdates(pageOrderingRules, update))
                .mapToInt(update -> update.get((update.size() - 1) / 2))
                .sum();
    }

    private static List<Integer> fixUpdates(ArrayList<PageOrderingRule> pageOrderingRules, ArrayList<Integer> update) {
        for (int i = 0; i < update.size(); i++) {
            int currentPage = update.get(i);
            List<Integer> pagesThatCantOccurBeforeCurrentPage = pageOrderingRules.stream()
                    .filter(rule -> rule.beforePage == currentPage)
                    .map(rule -> rule.afterPage)
                    .toList();
            Optional<Integer> beforePage = update.subList(0, i).stream().filter(pagesThatCantOccurBeforeCurrentPage::contains).findFirst();

            if (beforePage.isPresent()) {
                Integer pageToMove = update.get(i);
                update.remove(i);
                update.add(update.indexOf(beforePage.get()), pageToMove);
                return fixUpdates(pageOrderingRules, update);
            }
        }
        return update;
    }

    private static boolean isValidUpdate(ArrayList<PageOrderingRule> pageOrderingRules, ArrayList<Integer> update) {
        for (int i = 0; i < update.size(); i++) {
            int currentPage = update.get(i);
            List<Integer> pagesThatCantOccurBeforeCurrentPage = pageOrderingRules.stream()
                    .filter(rule -> rule.beforePage == currentPage)
                    .map(rule -> rule.afterPage)
                    .toList();
            if (update.subList(0, i).stream().anyMatch(pagesThatCantOccurBeforeCurrentPage::contains)) {
                return false;
            }
        }
        return true;
    }

    public record PageOrderingRule(int beforePage, int afterPage) {
    }
}

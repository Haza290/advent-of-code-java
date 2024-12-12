package com.schneider.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PageOrderingRulesAndUpdatesReader {

    public static PageOrderingRulesAndUpdates read(File file) {
        ArrayList<UpdatesManager.PageOrderingRule> pageOrderingRules = new ArrayList<>();
        ArrayList<ArrayList<Integer>> updates = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while (!(line = br.readLine()).isEmpty()) {
                String[] split = line.split("\\|");
                pageOrderingRules.add(new UpdatesManager.PageOrderingRule(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            }
            while ((line = br.readLine()) != null) {
                ArrayList<Integer> update = new ArrayList<>(Arrays.stream(line.split(",")).map(Integer::parseInt).toList());
                updates.add(update);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new PageOrderingRulesAndUpdates(pageOrderingRules, updates);
    }

    public record PageOrderingRulesAndUpdates(ArrayList<UpdatesManager.PageOrderingRule> pageOrderingRule,
                                              ArrayList<ArrayList<Integer>> updates) {
    }
}

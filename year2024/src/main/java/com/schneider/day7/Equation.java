package com.schneider.day7;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Equation {
    @Getter
    private final Long total;
    private final List<Long> numbers;

    public boolean isPossible() {
        Long total = numbers.get(0);
        return isPossible(total, new ArrayList<>(numbers.subList(1, numbers.size())));
    }

    private boolean isPossible(Long currentTotal, List<Long> numbers) {
        if (numbers.isEmpty()) {
            return currentTotal.equals(total);
        }

        Long concatenateNumbers = Long.parseLong(currentTotal.toString() + numbers.get(0).toString());

        return isPossible(currentTotal + numbers.get(0), new ArrayList<>(numbers.subList(1, numbers.size()))) ||
                isPossible(currentTotal * numbers.get(0), new ArrayList<>(numbers.subList(1, numbers.size()))) ||
                isPossible(concatenateNumbers, new ArrayList<>(numbers.subList(1, numbers.size())));
    }

}

package org.boyu.interview.arrays;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        // TODO: #1679 - Impl.
        final List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int pairCounter = 0;

        final Map<Integer, List<Integer>> collected = list.stream().collect(groupingBy(it -> it));
        for (Integer pairCandidate : collected.keySet()) {
            final int remainingLivesForCurrentCandidate = collected.get(pairCandidate).size();
            if (remainingLivesForCurrentCandidate < 1) {
                continue;
            }
            final int supplePairLives = collected.getOrDefault(k - pairCandidate, new ArrayList<>()).size();
            if (supplePairLives < 1) {
                continue;
            }

            pairCounter++;
            collected.get(pairCandidate).remove(0);
            collected.get(k - pairCandidate).remove(0);
        }
        return pairCounter;
    }
}

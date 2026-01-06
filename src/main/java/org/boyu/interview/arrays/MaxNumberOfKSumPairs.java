package org.boyu.interview.arrays;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        final List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int pairCounter = 0;

        final Map<Integer, List<Integer>> map = list.stream().collect(groupingBy(it -> it));
        for (Integer pairCandidate : map.keySet()) {
            final int remainingLivesForCurrentCandidate = map.get(pairCandidate).size();
            if (remainingLivesForCurrentCandidate < 1) {
                continue;
            }
            map.get(pairCandidate).remove(0);

            final int supplePairLives = map.getOrDefault(k - pairCandidate, new ArrayList<>()).size();
            final boolean foundAPair = supplePairLives >= 1;

            if (foundAPair) {
                pairCounter++;
                map.get(k - pairCandidate).remove(0);
            } else {
                map.get(pairCandidate).add(pairCandidate);
            }
        }
        return pairCounter;
    }
}

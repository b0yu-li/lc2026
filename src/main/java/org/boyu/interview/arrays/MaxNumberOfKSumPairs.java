package org.boyu.interview.arrays;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        final List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int pairCounter = 0;

        // TODO: #1679 - Refactor
        final Map<Integer, Long> map = list.stream().collect(groupingBy(it -> it, Collectors.counting()));
        for (Integer pairCandidate : map.keySet()) {
            boolean amIDoneWithThisKey = false;

            while (!amIDoneWithThisKey) {
                final Long remainingLivesForCurrentCandidate = map.get(pairCandidate);
                if (remainingLivesForCurrentCandidate < 1) {
                    amIDoneWithThisKey = true;
                    continue;
                }
                // tentatively remove this candidate, if fail to form a pair, revive it
                map.put(pairCandidate, remainingLivesForCurrentCandidate - 1);

                final Long supplePairLives = map.getOrDefault(k - pairCandidate, 0L);
                final boolean foundAPair = supplePairLives >= 1;

                if (foundAPair) {
                    pairCounter++;
                    map.put(k - pairCandidate, supplePairLives - 1);
                } else {
                    map.put(pairCandidate, remainingLivesForCurrentCandidate);
                    amIDoneWithThisKey = true;
                    continue;
                }

                if (map.get(pairCandidate) < 2) {
                    amIDoneWithThisKey = true;
                }
            }

        }
        return pairCounter;
    }
}

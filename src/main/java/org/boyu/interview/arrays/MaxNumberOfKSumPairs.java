package org.boyu.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        // TODO: #1679 - Impl. the waiting room analogy
        final Map<Integer, Integer> waitingRoom = new HashMap<>();
        int count = 0;

        for (int currentGuest : nums) {
            final int partner = k - currentGuest;
            if (waitingRoom.containsKey(partner) && waitingRoom.get(partner) > 0) {
                final Integer candidatePartnersCount = waitingRoom.get(partner);
                waitingRoom.put(partner, candidatePartnersCount - 1);
                count++;
                continue;
            }
            final Integer existingCountOfCurrentGuest = waitingRoom.getOrDefault(currentGuest, 0);
            waitingRoom.put(currentGuest, existingCountOfCurrentGuest + 1);
        }

        return count;
    }
}

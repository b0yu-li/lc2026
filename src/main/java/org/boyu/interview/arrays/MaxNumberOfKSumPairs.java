package org.boyu.interview.arrays;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        // Step 0: Line them up smallest to biggest (sorting)
        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            final int leftCandidate = nums[left];
            final int rightCandidate = nums[right];
            // Case I: Found one pair, congrads! Let both go and count them up!
            if (k == leftCandidate + rightCandidate) {
                count++;
                left++;
                right--;
                continue;
            }
            // Case II: One has to be bigger, only LEFT side can be bigger
            if (k > leftCandidate + rightCandidate) {
                left++;
                continue;
            }
            // Case II: One has to be smaller, only RIGHT side can be smaller
            if (k < leftCandidate + rightCandidate) {
                right--;
            }
        }

        return count;
    }
}

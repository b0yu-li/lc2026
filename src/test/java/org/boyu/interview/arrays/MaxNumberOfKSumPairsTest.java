package org.boyu.interview.arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MaxNumberOfKSumPairsTest {
    @Nested
    class MaxOperationsTest {

        @Test
        void should_return_1_given_1_pair() {
            // given
            final MaxNumberOfKSumPairs sut = new MaxNumberOfKSumPairs();
            final int[] nums = {3, 1, 3, 4, 3};
            final int k = 6;

            // when
            final int result = sut.maxOperations(nums, k);

            // then
            assertThat(result).isEqualTo(1);
        }

        @Test
        void should_return_2_given_2_pairs() {
            // given
            final MaxNumberOfKSumPairs sut = new MaxNumberOfKSumPairs();
            final int[] nums = {1, 2, 3, 4};
            final int k = 5;

            // when
            final int result = sut.maxOperations(nums, k);

            // then
            assertThat(result).isEqualTo(2);
        }
    }
}

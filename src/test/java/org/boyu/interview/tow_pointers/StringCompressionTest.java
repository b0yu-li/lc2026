package org.boyu.interview.tow_pointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringCompressionTest {
    @Nested
    class CompressTest {
        @Test
        void should_new_length_given_chars() {
            // given
            final StringCompression sut = new StringCompression();

            final char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
            // when
            final int result = sut.compress(chars);

            // then
            assertThat(result).isEqualTo(6);
        }

        @Test
        void should_new_length_given_chars_2() {
            // given
            final StringCompression sut = new StringCompression();

            final char[] chars = {'a'};
            // when
            final int result = sut.compress(chars);

            // then
            assertThat(result).isEqualTo(1);
        }

        @Test
        void should_new_length_given_chars_3() {
            // given
            final StringCompression sut = new StringCompression();

            final char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
            // when
            final int result = sut.compress(chars);

            // then
            assertThat(result).isEqualTo(4);
        }
    }
}

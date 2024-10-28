package algorithms.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.leetcode.algorithms.easy.RemoveDuplicatesFromSortedArray;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RemoveDuplicatesFromSortedArrayTest {

    static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    void removeDuplicatesTest(int[] initArray, int[] expectedArray) {
        int n = RemoveDuplicatesFromSortedArray.removeDuplicates(initArray);

        int[] actualArray = Arrays.copyOfRange(initArray, 0, n);

        assertThat(actualArray).usingDefaultComparator().isEqualTo(expectedArray);

    }
}

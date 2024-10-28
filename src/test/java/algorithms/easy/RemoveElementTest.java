package algorithms.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.leetcode.algorithms.easy.RemoveElement;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RemoveElementTest {

    static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(new int[]{3}, 3, new int[]{}),
                Arguments.of(new int[]{7, 25, 21, 2, 20, 7, 24, 9, 24, 24, 6, 22, 5, 1, 26, 17, 18, 29, 25,
                                9, 8, 27, 6, 26, 8, 5, 27, 5, 0, 29, 26, 29, 24, 18, 23, 14, 25, 17, 15, 20, 11, 22, 4,
                                17, 15, 0, 26, 3, 21, 21, 12, 0, 10, 10, 26, 19, 15, 23, 16, 7, 14, 12, 7, 8, 0, 0, 14,
                                26, 18, 22, 8, 21, 6, 12, 0, 21, 4, 26, 16, 26, 18, 21},
                        26,
                        new int[]{7, 25, 21, 2, 20, 7, 24, 9, 24, 24, 6, 22, 5, 1, 21, 17, 18, 29, 25, 9, 8, 27, 6, 18,
                                8, 5, 27, 5, 0, 29, 16, 29, 24, 18, 23, 14, 25, 17, 15, 20, 11, 22, 4, 17, 15, 0, 4, 3,
                                21, 21, 12, 0, 10, 10, 21, 19, 15, 23, 16, 7, 14, 12, 7, 8, 0, 0, 14, 0, 18, 22, 8, 21,
                                6, 12}),
                Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                Arguments.of(new int[]{}, 3, new int[]{}),
                Arguments.of(new int[]{2}, 3, new int[]{2})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    void removeDuplicatesTest(int[] initArray, int numberToRemove, int[] expectedArray) {
        int n = RemoveElement.removeElement(initArray, numberToRemove);

        int[] actualArray = Arrays.copyOfRange(initArray, 0, n);

        assertThat(actualArray).usingDefaultComparator().isEqualTo(expectedArray);
    }
}

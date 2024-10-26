package algorithms.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.leetcode.algorithms.easy.ValidParentheses;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidParenthesesTest {

    static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("()", true),
                org.junit.jupiter.params.provider.Arguments.of("()[]{}", true),
                org.junit.jupiter.params.provider.Arguments.of("(]", false),
                org.junit.jupiter.params.provider.Arguments.of("([])", true),
                org.junit.jupiter.params.provider.Arguments.of("(){}}{", false),
                org.junit.jupiter.params.provider.Arguments.of("([)]", false),
                org.junit.jupiter.params.provider.Arguments.of("((", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    void testIfStringIsValid(String str, Boolean expected) {
        boolean actual = ValidParentheses.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void testIfStringContainsOddNumberOfParenthesis() {
        boolean actual = ValidParentheses.isValid("[");

        assertFalse(actual);
    }
}

package algorithms.easy;

import org.junit.jupiter.api.Test;
import org.leetcode.algorithms.easy.LongestCommonPrefix;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    @Test
    void WhenLongestCommonPrefixIsMoreThanZero () {
        //given
        String expectedResult = "fl";

        //when
        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        String actualResult = LongestCommonPrefix.findLongestCommonPrefix(new String[]{"flower","flow","flight"});

        long endTime = System.nanoTime();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Memory used: " + memoryUsed/ 1024.0 + " kilobytes");
        System.out.println("Execution time: " + (endTime - startTime) / 1000000.0 + " milliseconds");

        long startTimeOptimised = System.nanoTime();
        Runtime runtimeOptimised = Runtime.getRuntime();
        runtime.gc();
        long usedMemoryBeforeOptimised = runtime.totalMemory() - runtime.freeMemory();

        String actualResultOptimised = LongestCommonPrefix.longestCommonPrefixOptimised(new String[]{"flower","flow","flight"});

        long endTimeOptimised = System.nanoTime();
        long usedMemoryAfterOptimised = runtimeOptimised.totalMemory() - runtimeOptimised.freeMemory();
        long memoryUsedOptimised = usedMemoryAfterOptimised - usedMemoryBeforeOptimised;
        System.out.println("Memory used: " + memoryUsedOptimised/ 1024.0 + " kilobytes");
        System.out.println("Execution time: " + (endTimeOptimised - startTimeOptimised) / 1000000.0 + " milliseconds");

        //then
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, actualResultOptimised);
    }

    @Test
    void WhenArrayContainsOnlyOneElement_ShouldReturnThisElement () {
        //given
        String expectedResult = "a";

        //when
        long startTime = System.nanoTime();

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        String actualResult = LongestCommonPrefix.findLongestCommonPrefix(new String[]{"a"});

        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) / 1000000.0 + " milliseconds");

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        long memoryUsed = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Memory used: " + memoryUsed/ 1024.0 + " kilobytes");

        //then
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void WhenLongestCommonPrefixIsZero () {
        //given
        String expectedResult = "";

        //when
        String actualResult = LongestCommonPrefix.findLongestCommonPrefix(new String[]{"apples", "bananas", "chery"});

        //then
        assertEquals(expectedResult, actualResult);
    }
}

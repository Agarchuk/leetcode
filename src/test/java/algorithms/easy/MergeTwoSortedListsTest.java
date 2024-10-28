package algorithms.easy;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.leetcode.algorithms.easy.MergeTwoSortedLists.ListNode;
import org.leetcode.algorithms.easy.MergeTwoSortedLists.MergeTwoSortedLists;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MergeTwoSortedListsTest {
    static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{2}, new int[]{1}, new int[]{1, 2})
        );
    }


    @ParameterizedTest
    @MethodSource("provideTestArguments")
    void MergeTwoSortedList(int[] list1, int[] list2, int[] expectedList) {
        //given
        ListNode head1 = generateListNodes(list1);
        ListNode head2 = generateListNodes(list2);
        ListNode expected = generateListNodes(expectedList);

        //when
        ListNode actual = MergeTwoSortedLists.mergeTwoLists(head1, head2);

        //then

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }


    private ListNode generateListNodes(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

}



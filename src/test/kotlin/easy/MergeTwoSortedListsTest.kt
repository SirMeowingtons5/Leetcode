package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.toListNode
import java.util.stream.Stream
import kotlin.test.assertEquals

class MergeTwoSortedListsTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                MergeTwoSortedListsTestData(
                    list1 = intArrayOf(1, 2, 4).toListNode(),
                    list2 = intArrayOf(1, 3, 4).toListNode(),
                    expected = intArrayOf(1, 1, 2, 3, 4, 4).toListNode(),
                )
            ),
            arguments(
                MergeTwoSortedListsTestData(
                    list1 = null,
                    list2 = null,
                    expected = null,
                )
            ),
            arguments(
                MergeTwoSortedListsTestData(
                    list1 = null,
                    list2 = intArrayOf(0).toListNode(),
                    expected = intArrayOf(0).toListNode(),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MergeTwoSortedListsTestData) {
        val actual = MergeTwoSortedLists().mergeTwoLists(
            list1 = data.list1,
            list2 = data.list2
        )

        assertEquals(data.expected, actual)
    }

    data class MergeTwoSortedListsTestData(val list1: ListNode?, val list2: ListNode?, val expected: ListNode?)
}
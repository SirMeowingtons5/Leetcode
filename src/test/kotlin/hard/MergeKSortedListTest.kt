package hard

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.toInt
import utils.toListNode
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MergeKSortedListTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(
                    arrayOf(
                        intArrayOf(1, 4, 5).toListNode(),
                        intArrayOf(1, 3, 4).toListNode(),
                        intArrayOf(2, 6).toListNode()
                    ),
                    intArrayOf(1, 1, 2, 3, 4, 4, 5, 6).toListNode()
                ),
                arguments(
                    emptyArray<ListNode?>(),
                    null
                ),
                arguments(
                    arrayOf<ListNode?>(null),
                    null
                )
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(lists: Array<ListNode?>, expected: ListNode?) {
        assertEquals(expected?.toInt(), MergeKSortedList().mergeKLists(lists)?.toInt())
    }
}
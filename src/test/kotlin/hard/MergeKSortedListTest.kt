package hard

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.listNodeOf
import utils.toReversedInt
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MergeKSortedListTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(
                    arrayOf(
                        listNodeOf(1, 4, 5),
                        listNodeOf(1, 3, 4),
                        listNodeOf(2, 6)
                    ),
                    listNodeOf(1, 1, 2, 3, 4, 4, 5, 6)
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
        assertEquals(expected?.toReversedInt(), MergeKSortedList().mergeKLists(lists)?.toReversedInt())
    }
}
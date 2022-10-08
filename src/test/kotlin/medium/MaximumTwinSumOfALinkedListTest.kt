package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.listNodeOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class MaximumTwinSumOfALinkedListTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                MaximumTwinSumOfALinkedListTestData(
                    head = listNodeOf(5, 4, 2, 1)!!,
                    expected = 6,
                )
            ),
            arguments(
                MaximumTwinSumOfALinkedListTestData(
                    head = listNodeOf(4, 2, 2, 3)!!,
                    expected = 7,
                )
            ),
            arguments(
                MaximumTwinSumOfALinkedListTestData(
                    head = listNodeOf(1, 100000)!!,
                    expected = 100001,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MaximumTwinSumOfALinkedListTestData) {
        val actual = MaximumTwinSumOfALinkedList().pairSum(data.head)

        assertEquals(data.expected, actual)
    }

    data class MaximumTwinSumOfALinkedListTestData(val head: ListNode, val expected: Int)
}
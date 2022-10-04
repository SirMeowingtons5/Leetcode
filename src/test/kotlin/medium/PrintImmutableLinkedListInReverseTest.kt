package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ImmutableListNode
import utils.immutableListNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class PrintImmutableLinkedListInReverseTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                PrintImmutableLinkedListInReverseTestData(
                    head = immutableListNodesOf(1, 2, 3, 4),
                    expected = listOf("4", "3", "2", "1")
                )
            ),
            arguments(
                PrintImmutableLinkedListInReverseTestData(
                    head = immutableListNodesOf(0,-4,-1,3,-5),
                    expected = listOf("-5","3","-1","-4","0")
                )
            ),
            arguments(
                PrintImmutableLinkedListInReverseTestData(
                    head = immutableListNodesOf(-2,0,6,4,4,-6),
                    expected = listOf("-6","4","4","6","0","-2")
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: PrintImmutableLinkedListInReverseTestData) {
        ImmutableListNode.log.clear()
        PrintImmutableLinkedListInReverse().printLinkedListInReverse(data.head)
        val actual = ImmutableListNode.log

        assertEquals(data.expected, actual)
    }

    data class PrintImmutableLinkedListInReverseTestData(val head: ImmutableListNode?, val expected: List<String>)
}
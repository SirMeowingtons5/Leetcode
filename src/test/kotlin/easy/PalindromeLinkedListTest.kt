package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.listNodeOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class PalindromeLinkedListTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                PalindromeLinkedListTestData(
                    root = listNodeOf(1, 2, 2, 1)!!,
                    expected = true,
                )
            ),
            arguments(
                PalindromeLinkedListTestData(
                    root = listNodeOf(1, 2)!!,
                    expected = false,
                )
            ),
            arguments(
                PalindromeLinkedListTestData(
                    root = listNodeOf(1, 2, 1)!!,
                    expected = true,
                )
            ),
            arguments(
                PalindromeLinkedListTestData(
                    root = listNodeOf(1)!!,
                    expected = true,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: PalindromeLinkedListTestData) {
        val actual = PalindromeLinkedList().isPalindrome(data.root)

        assertEquals(data.expected, actual)
    }

    data class PalindromeLinkedListTestData(val root: ListNode, val expected: Boolean)
}
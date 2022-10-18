package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class CountUnivalueSubtreesTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                CountUnivalueSubtreesTestData(
                    root = treeNodesOf(5, 1, 5, 5, 5, null, 5),
                    expected = 4,
                )
            ),
            arguments(
                CountUnivalueSubtreesTestData(
                    root = null,
                    expected = 0,
                )
            ),
            arguments(
                CountUnivalueSubtreesTestData(
                    root = treeNodesOf(5, 5, 5, 5, 5, null, 5),
                    expected = 6,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: CountUnivalueSubtreesTestData) {
        val actual = CountUnivalueSubtrees().countUnivalSubtrees(data.root)

        assertEquals(data.expected, actual)
    }

    data class CountUnivalueSubtreesTestData(val root: TreeNode?, val expected: Int)
}
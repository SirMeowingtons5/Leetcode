package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class BinaryTreePreorderTraversalTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                BinaryTreePreorderTraversalTestData(
                    root = treeNodesOf(1, null, 2, 3),
                    expected = listOf(1, 2, 3),
                )
            ),
            arguments(
                BinaryTreePreorderTraversalTestData(
                    root = null,
                    expected = emptyList(),
                )
            ),
            arguments(
                BinaryTreePreorderTraversalTestData(
                    root = treeNodesOf(1),
                    expected = listOf(1),
                )
            ),
        )
    }

    private val subject = BinaryTreePreorderTraversal()

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: BinaryTreePreorderTraversalTestData) {
        val actualCurrentlySelected = subject.preorderTraversal(data.root)
        val actualRecursive = subject.testRecursive(data.root)
        val actualIterative = subject.testIterative(data.root)

        assertEquals(data.expected, actualCurrentlySelected)
        assertEquals(data.expected, actualRecursive)
        assertEquals(data.expected, actualIterative)
    }

    data class BinaryTreePreorderTraversalTestData(val root: TreeNode?, val expected: List<Int>)
}
package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class BinaryTreeInorderTraversalTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                BinaryTreeInorderTraversalTestData(
                    root = treeNodesOf(1, null, 2, 3),
                    expected = listOf(1, 3, 2)
                )
            ),
            arguments(
                BinaryTreeInorderTraversalTestData(
                    root = null,
                    expected = emptyList()
                )
            ),
            arguments(
                BinaryTreeInorderTraversalTestData(
                    root = treeNodesOf(1),
                    expected = listOf(1)
                )
            ),
        )
    }

    private val subject = BinaryTreeInorderTraversal()

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: BinaryTreeInorderTraversalTestData) {
        val actualCurrentlySelected = subject.inorderTraversal(data.root)
        val actualRecursive = subject.testRecursive(data.root)
        val actualIterative = subject.testIterative(data.root)

        assertEquals(data.expected, actualCurrentlySelected)
        assertEquals(data.expected, actualRecursive)
        assertEquals(data.expected, actualIterative)
    }

    data class BinaryTreeInorderTraversalTestData(val root: TreeNode?, val expected: List<Int>)
}
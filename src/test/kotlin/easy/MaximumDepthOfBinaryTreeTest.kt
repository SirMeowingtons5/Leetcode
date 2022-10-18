package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class MaximumDepthOfBinaryTreeTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                MaximumDepthOfBinaryTreeTestData(
                    root = treeNodesOf(3, 9, 20, null, null, 15, 7)!!,
                    expected = 3,
                )
            ),
            arguments(
                MaximumDepthOfBinaryTreeTestData(
                    root = treeNodesOf(1, null, 2)!!,
                    expected = 2,
                )
            ),
        )
    }

    private val subject = MaximumDepthOfBinaryTree()

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MaximumDepthOfBinaryTreeTestData) {
        val actualCurrentlySelected = subject.maxDepth(data.root)
        val actualIterative = subject.testIterative(data.root)
        val actualRecursiveBottomTop = subject.testRecursiveBottomTop(data.root)
        val actualRecursiveTopBottom = subject.testRecursiveTopBottom(data.root)

        assertEquals(data.expected, actualCurrentlySelected)
        assertEquals(data.expected, actualIterative)
        assertEquals(data.expected, actualRecursiveBottomTop)
        assertEquals(data.expected, actualRecursiveTopBottom)
    }

    data class MaximumDepthOfBinaryTreeTestData(val root: TreeNode, val expected: Int)
}
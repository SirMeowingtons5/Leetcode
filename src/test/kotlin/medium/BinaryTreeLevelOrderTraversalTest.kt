package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class BinaryTreeLevelOrderTraversalTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                BinaryTreeLevelOrderTraversalTestData(
                    root = treeNodesOf(3, 9, 20, null, null, 15, 7),
                    expected = listOf(
                        listOf(3),
                        listOf(9, 20),
                        listOf(15, 7)
                    )
                )
            ),
            arguments(
                BinaryTreeLevelOrderTraversalTestData(
                    root = treeNodesOf(1),
                    expected = listOf(
                        listOf(1)
                    )
                )
            ),
            arguments(
                BinaryTreeLevelOrderTraversalTestData(
                    root = null,
                    expected = emptyList(),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: BinaryTreeLevelOrderTraversalTestData) {
        val actual = BinaryTreeLevelOrderTraversal().levelOrder(data.root)

        assertEquals(data.expected, actual)
    }

    data class BinaryTreeLevelOrderTraversalTestData(val root: TreeNode?, val expected: List<List<Int>>)
}
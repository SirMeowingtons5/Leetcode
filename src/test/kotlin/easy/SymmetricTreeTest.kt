package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class SymmetricTreeTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                SymmetricTreeTestData(
                    root = treeNodesOf(1, 2, 2, 3, 4, 4, 3),
                    expected = true,
                )
            ),
            arguments(
                SymmetricTreeTestData(
                    root = treeNodesOf(1, 2, 2, null, 3, null, 3),
                     expected = false,
                )
            )
        )
    }

    private val subject = SymmetricTree()

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: SymmetricTreeTestData) {
        val actualCurrentlySelected = subject.isSymmetric(data.root)
        val actualRecursive = subject.testSymmetricRecursive(data.root)
        val actualIterative = subject.testSymmetricIterative(data.root)

        assertEquals(data.expected, actualCurrentlySelected)
        assertEquals(data.expected, actualRecursive)
        assertEquals(data.expected, actualIterative)
    }

    data class SymmetricTreeTestData(val root: TreeNode?, val expected: Boolean)
}
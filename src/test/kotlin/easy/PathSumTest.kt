package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class PathSumTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                PathSumTestData(
                    root = treeNodesOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1),
                    target = 22,
                    expected = true,
                )
            ),
            arguments(
                PathSumTestData(
                    root = treeNodesOf(1,2,3),
                    target = 5,
                    expected = false,
                )
            ),
            arguments(
                PathSumTestData(
                    root = null,
                    target = 0,
                    expected = false,
                )
            ),
            arguments(
                PathSumTestData(
                    root = treeNodesOf(-2,null,-3),
                    target = -5,
                    expected = true
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: PathSumTestData) {
        val actual = PathSum().hasPathSum(data.root, data.target)

        assertEquals(data.expected, actual)
    }

    data class PathSumTestData(val root: TreeNode?, val target: Int, val expected: Boolean)
}
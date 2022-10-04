package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class DeepestLeavesSumTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                DeepestLeavesSumTestData(
                    root = treeNodesOf(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8),
                    expected = 15
                )
            ),
            arguments(
                DeepestLeavesSumTestData(
                    root = treeNodesOf(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5),
                    expected = 19
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: DeepestLeavesSumTestData) {
        val actual = DeepestLeavesSum().deepestLeavesSum(data.root)

        assertEquals(data.expected, actual)
    }

    data class DeepestLeavesSumTestData(val root: TreeNode?, val expected: Int)
}
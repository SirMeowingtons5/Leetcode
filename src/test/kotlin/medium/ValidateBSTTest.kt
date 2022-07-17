package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.TreeNode
import utils.treeNodesOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class ValidateBSTTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                ValidateBSTTestData(
                    root = treeNodesOf(2, 1, 3)!!,
                    expected = true,
                ),
                ValidateBSTTestData(
                    root = treeNodesOf(5, 1, 4, null, null, 3, 6)!!,
                    expected = false,
                ),
                ValidateBSTTestData(
                    root = treeNodesOf(2, 2, 2)!!,
                    expected = false,
                ),
                ValidateBSTTestData(
                    root = treeNodesOf(5, 4, 6, null, null, 3, 7)!!,
                    expected = false,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ValidateBSTTestData) {
        val actual = ValidateBST().isValidBST(data.root)

        assertEquals(data.expected, actual)
    }

    data class ValidateBSTTestData(val root: TreeNode, val expected: Boolean)
}
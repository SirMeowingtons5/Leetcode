package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.NestedInteger
import java.util.stream.Stream
import kotlin.test.assertEquals

class NestedListWeightSumTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                NestedListWeightSumTestData(
                    nestedList = listOf(
                        NestedInteger().apply {
                            add(NestedInteger(1))
                            add(NestedInteger(1))
                        },
                        NestedInteger(2),
                        NestedInteger().apply {
                            add(NestedInteger(1))
                            add(NestedInteger(1))
                        },
                    ),
                    expected = 10
                )
            ),
            arguments(
                NestedListWeightSumTestData(
                    nestedList = listOf(
                        NestedInteger(1),
                        NestedInteger().apply {
                            add(NestedInteger(4))
                            add(NestedInteger().apply {
                                add(NestedInteger(6))
                            }
                            )
                        },
                    ),
                    expected = 27
                )
            ),
            arguments(
                NestedListWeightSumTestData(
                    nestedList = listOf(
                        NestedInteger(0),
                    ),
                    expected = 0
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: NestedListWeightSumTestData) {
        val actual = NestedListWeightSum().depthSum(data.nestedList)

        assertEquals(data.expected, actual)
    }

    data class NestedListWeightSumTestData(val nestedList: List<NestedInteger>, val expected: Int)
}
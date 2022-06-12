package medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RotateImageTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                RotateImageTestData(
                    matrix = arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9)
                    ),
                    expected = arrayOf(
                        intArrayOf(7, 4, 1),
                        intArrayOf(8, 5, 2),
                        intArrayOf(9, 6, 3)
                    )
                ),
                RotateImageTestData(
                    matrix = arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7),
                        intArrayOf(15, 14, 12, 16)
                    ),
                    expected = arrayOf(
                        intArrayOf(15, 13, 2, 5),
                        intArrayOf(14, 3, 4, 1),
                        intArrayOf(12, 6, 8, 9),
                        intArrayOf(16, 7, 10, 11)
                    )
                ),
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: RotateImageTestData) {
        RotateImage().rotate(data.matrix)

        for (i in 0 until data.expected.size) {
            assertArrayEquals(data.expected, data.matrix)
        }
    }

    data class RotateImageTestData(val matrix: Array<IntArray>, val expected: Array<IntArray>)
}
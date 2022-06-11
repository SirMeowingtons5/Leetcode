package easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class IntersectionOfTwoArrays2Test {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(
                    IntersectionOfTwoArrays2TestData(
                        nums1 = intArrayOf(1, 2, 2, 1),
                        nums2 = intArrayOf(2, 2),
                        expected = intArrayOf(2, 2)
                    ),
                    IntersectionOfTwoArrays2TestData(
                        nums1 = intArrayOf(4,9,5),
                        nums2 = intArrayOf(9,4,9,8,4),
                        expected = intArrayOf(4, 9),
                    )
                )
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: IntersectionOfTwoArrays2TestData) {
        val actual = IntersectionOfTwoArrays2().intersect(data.nums1, data.nums2)

        assertArrayEquals(data.expected, actual)
    }

    data class IntersectionOfTwoArrays2TestData(val nums1: IntArray, val nums2: IntArray, val expected: IntArray)
}
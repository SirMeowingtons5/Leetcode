package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class GroupThePeopleGivenTheGroupSizeTheyBelongToTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                GroupThePeopleGivenTheGroupSizeTheyBelongToTestData(
                    groupSizes = intArrayOf(3, 3, 3, 3, 3, 1, 3),
                    expected = listOf(
                        listOf(0, 1, 2),
                        listOf(5),
                        listOf(3, 4, 6)
                    )
                ),
                GroupThePeopleGivenTheGroupSizeTheyBelongToTestData(
                    groupSizes = intArrayOf(2,1,3,3,3,2),
                    expected = listOf(
                        listOf(1),
                        listOf(2, 3, 4),
                        listOf(0, 5)
                    )
                ),
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: GroupThePeopleGivenTheGroupSizeTheyBelongToTestData) {
        val actual = GroupThePeopleGivenTheGroupSizeTheyBelongTo().groupThePeople(data.groupSizes)

        assertEquals(data.expected, actual)
    }

    data class GroupThePeopleGivenTheGroupSizeTheyBelongToTestData(
        val groupSizes: IntArray,
        val expected: List<List<Int>>
    )
}
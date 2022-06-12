package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class FirstUniqueCharacterInAStringTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(FirstUniqueCharacterInAStringTestData(s = "leetcode", expected = 0)),
            arguments(FirstUniqueCharacterInAStringTestData(s = "loveleetcode", expected = 2)),
            arguments(FirstUniqueCharacterInAStringTestData(s = "aabb", expected = -1)),
            arguments(FirstUniqueCharacterInAStringTestData(s = "", expected = -1)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: FirstUniqueCharacterInAStringTestData) {
        val actual = FirstUniqueCharacterInAString().firstUniqChar(data.s)

        assertEquals(data.expected, actual)
    }

    data class FirstUniqueCharacterInAStringTestData(val s: String, val expected: Int,)
}
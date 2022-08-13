package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class SimplifyPathTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(SimplifyPathTestData(path = "/home/", expected = "/home")),
            arguments(SimplifyPathTestData(path = "/../", expected = "/")),
            arguments(SimplifyPathTestData(path = "/home//foo/", expected = "/home/foo")),
            arguments(SimplifyPathTestData(path = "/a//b////c/d//././/..", expected = "/a/b/c"))
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: SimplifyPathTestData) {
        val actual = SimplifyPath().simplifyPath(data.path)

        assertEquals(data.expected, actual)
    }

    data class SimplifyPathTestData(val path: String, val expected: String)
}
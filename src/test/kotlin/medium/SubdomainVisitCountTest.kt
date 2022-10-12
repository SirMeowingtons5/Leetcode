package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class SubdomainVisitCountTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                SubdomainVisitCountTestData(
                    cpdomains = arrayOf("9001 discuss.leetcode.com"),
                    expected = listOf("9001 leetcode.com", "9001 discuss.leetcode.com", "9001 com").sorted(),
                )
            ),
            arguments(
                SubdomainVisitCountTestData(
                    cpdomains = arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"),
                    expected = listOf("901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com").sorted(),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: SubdomainVisitCountTestData) {
        val actual = SubdomainVisitCount().subdomainVisits(data.cpdomains).sorted()

        assertEquals(data.expected, actual)
    }

    data class SubdomainVisitCountTestData(val cpdomains: Array<String>, val expected: List<String>)
}
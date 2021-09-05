package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class KPalindromeTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(KPalindromeSampleData("annabelle", 2, true)),
                arguments(KPalindromeSampleData("leetcode", 3, false)),
                arguments(KPalindromeSampleData("true", 4, true)),
                arguments(KPalindromeSampleData("yzyzyzyzyzyzyzy", 2, true)),
                arguments(KPalindromeSampleData("cr", 7, false)),
                )

        @JvmStatic
        fun leetcodeTestData(): Stream<Arguments> =
            Stream.of(
                arguments(KPalindromeSampleData("qlkzenwmmnpkopu",15, true)),
                arguments(KPalindromeSampleData("dhtoglkxhclrhipoxbfxqwqrxpcyucfnconitxbskzadzvbxrjbaywsixmrhdgkhyurqstugcgyaxjgiigkccdrhsmpafclkrkvxzvvhdrg", 88, true))
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(sampleData: KPalindromeSampleData) {
        val actual = KPalindrome().canConstruct(sampleData.s, sampleData.k)

        assertEquals(sampleData.expected, actual)
    }

    @ParameterizedTest
    @MethodSource("leetcodeTestData")
    fun `leetcode data test`(sampleData: KPalindromeSampleData) {
        val actual = KPalindrome().canConstruct(sampleData.s, sampleData.k)

        assertEquals(sampleData.expected, actual)
    }

    internal data class KPalindromeSampleData(val s: String, val k: Int, val expected: Boolean)
}
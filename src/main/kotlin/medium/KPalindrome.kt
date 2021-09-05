package medium

/**
 * https://leetcode.com/problems/construct-k-palindrome-strings/
 */


/**
 * With paired chars you may build any number of palindromes in [1;pairedChars]
 * since any pair may represent 3 numbers of palindromes:
 * 2 (each char is palindrome), 1 (pair is palindrome), 0 (added to previous palindrome).
 * So we have to build the solution around single chars
 */
class KPalindrome {

    fun canConstruct(s: String, k: Int): Boolean {
        val map = HashMap<Char, Int>()

        s.forEach { char ->
            if (map.contains(char)) {
                map[char] = map[char]!! + 1
            } else {
                map[char] = 1
            }
        }

        var singleChars = 0
        var pairedChars = 0

        map.values.forEach { charCount -> // split all chars into pairs with optional unique. i.e. aaa -> aa(pair) + 1 (a)
            if (charCount > 1) pairedChars += charCount / 2 * 2 //round down to closest even number
            if (charCount % 2 == 1) singleChars++
        }

        return (singleChars <= k
                && singleChars + pairedChars >= k)
    }
}
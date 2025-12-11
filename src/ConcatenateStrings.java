/*
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

    For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.

Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.



Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].



Constraints:

    1 <= s.length <= 104
    1 <= words.length <= 5000
    1 <= words[i].length <= 30
    s and words[i] consist of lowercase English letters.


 */
import java.util.*;

public class ConcatenateStrings {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return result;

        // Frequency map of words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words)
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);

        // We will slide window starting from each possible offset in [0..wordLen-1]
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            // Move in steps of wordLen
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String w = s.substring(j, j + wordLen);

                // If valid word
                if (wordMap.containsKey(w)) {
                    seen.put(w, seen.getOrDefault(w, 0) + 1);
                    count++;

                    // Shrink window if this word occurs too many times
                    while (seen.get(w) > wordMap.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If we matched all words
                    if (count == wordCount) {
                        result.add(left);
                        // Move left window forward
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Reset window
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }

    // Optional: For testing
    public static void main(String[] args) {
        ConcatenateStrings cs = new ConcatenateStrings();
        System.out.println(cs.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})); // [0, 9]
        System.out.println(cs.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})); // []
        System.out.println(cs.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"})); // [6,9,12]
    }
}

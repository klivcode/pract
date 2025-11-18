/*

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.​​​​
    '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".



Constraints:

    1 <= s.length <= 20
    1 <= p.length <= 20
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.




 */


public class RegularExpressionMatching {

        public boolean isMatch(String s, String p) {
           if(p.isEmpty())
               return s.isEmpty();

           boolean firstMatch=
                   (!s.isEmpty() &&
                           (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

           if(p.length()>=2 && p.charAt(1) == '*') {

               return (
                       isMatch(s, p.substring(2))
                       ||
                               ( firstMatch && isMatch(s.substring(1), p)));
           }
           return  firstMatch && isMatch(s.substring(1), p.substring(1));
        }





    public static void main(String[] args) {
        RegularExpressionMatching s = new RegularExpressionMatching();
        System.out.println(s.isMatch("aab", ".*a"));
    }

}

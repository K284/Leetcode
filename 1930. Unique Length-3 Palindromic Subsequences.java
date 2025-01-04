/*
1930. Unique Length-3 Palindromic Subsequences
Solved
Medium
Topics
Companies
Hint
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.
*/
class Pair{
    int firstOcc;
    int secondOcc;
    Pair(int firstOcc, int secondOcc ){
        this.firstOcc=firstOcc;
        this.secondOcc=secondOcc;
    }
}
class Solution {
    public int countPalindromicSubsequence(String s) {
        Pair arr[] = new Pair[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new Pair(-1,-1);
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a'].firstOcc==-1){
                arr[s.charAt(i)-'a'].firstOcc = i;
            }
            else
                arr[s.charAt(i)-'a'].secondOcc=i;
        }
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].firstOcc !=-1 && arr[i].secondOcc !=-1){
                HashSet<Character> hs= new HashSet<>();
                for(int j=arr[i].firstOcc+1;j<arr[i].secondOcc;j++){
                    hs.add(s.charAt(j));
                }
                cnt+=hs.size();
            }
        }
        return cnt;
    }
}

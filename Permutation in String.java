/*
567. Permutation in String
Medium
Topics
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a 
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
          
          if(s1.length()==0){
            return true;
          }
          if(s2.length()<s1.length()){
            return false;
          }
          int[] arr1=new int[26];
          int[] arr2=new int[26];
          for(int i=0;i<s1.length();i++){
             char ch=s1.charAt(i);
             arr1[ch-'a']++;
          }
          for(int i=0;i<s1.length();i++){
            char ch=s2.charAt(i);
            arr2[ch-'a']++;
          }
          boolean flag=true;;
          for(int i=0;i<26;i++){
             if(arr1[i]!=arr2[i]){
                flag=false;
             }
          }
          if(flag==true){
            return true;
          }
          for(int i=s1.length();i<s2.length();i++){
            char ch=s2.charAt(i);
            int rem=i-s1.length();
            char remch=s2.charAt(rem);
            arr2[remch-'a']--;
            arr2[ch-'a']++;
            boolean flag1=true;
            for(int j=0;j<26;j++){
                if(arr1[j]!=arr2[j]){
                    flag1=false;
                    break;
                }
            }
            if(flag1==true){
                return true;
            }
          } 
          return false;       

    }
}

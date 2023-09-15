package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

public class MaxNumOfVovelsInSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Integer k = Integer.parseInt(br.readLine());

        MaxNumOfVovelsInSubarray sol = new MaxNumOfVovelsInSubarray();
        System.out.println(sol.maxVovels(s, k));
    }

    public int maxVovels(String s, int k){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxVowels = 0;
        return maxVowels;
    }
}

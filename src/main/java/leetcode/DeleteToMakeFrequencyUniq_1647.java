package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//A string s is called good if there are no two different characters in s that have the same frequency.
//Given a string s, return the minimum number of characters you need to delete to make s good.
//The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab",
// the frequency of 'a' is 2, while the frequency of 'b' is 1.

public class DeleteToMakeFrequencyUniq_1647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();


        DeleteToMakeFrequencyUniq_1647 sol = new DeleteToMakeFrequencyUniq_1647();
        System.out.println(sol.minDeletions(s));
    }


    public int minDeletions(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        for(Character c: s.toCharArray()){
            freqs.put(c, freqs.getOrDefault(c, 0)+1);
        }
        List<Integer> frs = new ArrayList<>();
        for(Map.Entry<Character, Integer> me: freqs.entrySet()){
            frs.add(me.getValue());
        }
        frs.sort(Collections.reverseOrder());

        int minDels = 0;
        int secPointer = 0;
        for(int i=1; i<frs.size(); i++){
             if(frs.get(i) + (i - secPointer) < frs.get(secPointer)){
                 secPointer = i;
             }else{
                 minDels += Math.min(frs.get(i), Math.max((i - secPointer) + (frs.get(i) - frs.get(secPointer)), 0));
             }
        }
        return minDels;
    }
}

package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinSizeSubarray_209 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        String[] numbersString = br.readLine().split(" ");
        int[] nums = new int[numbersString.length];
        for(int i = 0; i < numbersString.length; i++){
            nums[i] = Integer.parseInt(numbersString[i]);
        }

        MinSizeSubarray_209 sol = new MinSizeSubarray_209();
        System.out.println(sol.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minSeq = nums.length;
        int currSeqLength = 0;
        int currSeq = 0;
        int subSeqPointer = 0;
        boolean found = false;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>=target) return 1;
            currSeq += nums[i];
            if(currSeq >= target){
                found = true;
                while(subSeqPointer < i && currSeq >= target){
                    currSeq = currSeq - nums[subSeqPointer];
                    subSeqPointer++;
                }
                currSeqLength = i-subSeqPointer+2;
                if(minSeq > currSeqLength){
                    minSeq = currSeqLength;
                }
            }
        }
        if(!found) return 0;
        return minSeq;
    }
}

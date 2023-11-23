package Yandex.Algo_course.Sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint4E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ca = br.readLine().toCharArray();
        int ans = 1;
        int[] posArr = new int[26];
        for(int k = 0; k<26; k++){
            posArr[k] = -1;
        }
        int leftPointer = -1;
        for(int i = 0; i<ca.length; i++){
            if(posArr[ca[i] - 'a'] == -1 || posArr[ca[i] - 'a'] < leftPointer){
                ans = Math.max(i-leftPointer, ans);
            }else{
                leftPointer = posArr[ca[i] - 'a'];
            }
            posArr[ca[i] - 'a'] = i;
        }
        System.out.println(ans);
    }
}

package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint7K {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        String[] fs = br.readLine().split(" ");
        int[] fArr = stringToIntArr(fs);

        int second = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");
        int[] sArr = stringToIntArr(ss);

        int[][] dp = new int[first+1][second+1];

        List<Integer> firstIndexes = new ArrayList<>();
        List<Integer> secondIndexes = new ArrayList<>();

        for(int f = 1; f<first+1; f++){
            for(int s = 1; s<second+1; s++){
                if(fArr[f-1] == sArr[s-1]){
                    dp[f][s] = dp[f-1][s-1]+1;
                }else{
                    dp[f][s] = Math.max(dp[f][s-1], dp[f-1][s]);
                }
            }
        }

        System.out.println(dp[first][second]);

        while(first > 0 || second > 0){
            if(dp[first][second] == 0){
                break;
            }
            if(fArr[first-1] == sArr[second-1]){
                firstIndexes.add(first);
                secondIndexes.add(second);
                first--;
                second--;
            }else{
                if(dp[first-1][second] == dp[first][second]){
                    first--;
                }else{
                    second--;
                }
            }
        }

        printList(firstIndexes);
        printList(secondIndexes);
    }

    public static void printList(List<Integer> list){
        Collections.reverse(list);
        for(Integer i: list){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static int[] stringToIntArr(String[] s){
        int[] arr = new int[s.length];
        for(int i = 0; i<s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }
}

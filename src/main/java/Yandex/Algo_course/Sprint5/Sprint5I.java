package Yandex.Algo_course.Sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint5I {
    public static int[] sums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        sums = new int[val+1];
        sums[0] = 1;
        sums[1] = 1;
        fillSums(val);
        System.out.println(sums[val]);
    }

    public static void fillSums(int val){
        for(int v = 2; v <= val; v++){
            if(sums[v] == 0){
                getSum(v);
            }
        }
    }

    public static void getSum(int v){
        int sum = 0;
        for(int i = 1; i<=v;i++){
            int qLeft = i-1;
            int qRight = v-i;
            sum += sums[qLeft]*sums[qRight];
        }
        sums[v] = sum;
    }

}

package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Sprint7A {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int[] stocks = new int[days];
        int[] sumPref = new int[days];

        StringTokenizer St = new StringTokenizer(br.readLine());

        int profit = 0;

        for (int i = 0; i < days; i++) {
            stocks[i] = Integer.parseInt(St.nextToken());
            if(i > 0){
                int localProfit = stocks[i] - stocks[i-1];
                if(localProfit > 0){
                    profit += localProfit;
                }
            }
        }



        System.out.println(profit);

    }
}

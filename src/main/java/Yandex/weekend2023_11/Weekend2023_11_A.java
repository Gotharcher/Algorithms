package Yandex.weekend2023_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Weekend2023_11_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tQty = Integer.parseInt(br.readLine());
        if(tQty == 1){
            System.out.println(-1);
            return;
        }

        int[] tasks = new int[tQty];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<tQty; i++){
            tasks[i] = Integer.parseInt(st.nextToken());
        }

        int pairSum = tasks[0] + tasks[tQty-1];

        for(int k=1; k<tQty; k++){
            if(tasks[k] + tasks[tQty-1-k] != pairSum){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(pairSum);
    }
}

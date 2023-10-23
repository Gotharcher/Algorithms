package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint3E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpData = br.readLine().split(" ");
        int housesQty = Integer.parseInt(inpData[0]);
        int[] houses = new int[housesQty];
        int money = Integer.parseInt(inpData[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<housesQty;i++){
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);

        int ans = 0;
        for(int i = 0; i<housesQty;i++){
            if(houses[i] <= money){
                ans++;
                money -= houses[i];
            }else{
                break;
            }
        }
        System.out.println(ans);
    }
}

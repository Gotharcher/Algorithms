package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint3O_countSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int isleQ = Integer.parseInt(br.readLine());
        int[] isles = new int[isleQ];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < isleQ; i++) {
            isles[i] = Integer.parseInt(st.nextToken());
        }
        long ansNumber = Long.parseLong(br.readLine());

        //Arrays.sort(isles);

        int[] diffsVals = new int[1000000];
        for(int i = 0; i<isleQ;i++){
            for (int j = i+1; j<isleQ;j++){
                diffsVals[(Math.abs(isles[i]-isles[j]))]++;
            }
        }

        for(int i = 0; i<diffsVals.length; i++){
            ansNumber = ansNumber - diffsVals[i];
            if(ansNumber<=0){
                System.out.println(i);
                return;
            }
        }
    }
}

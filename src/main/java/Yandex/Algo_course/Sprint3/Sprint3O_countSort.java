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

        Arrays.sort(isles);

        List<Integer> diffs = new ArrayList<>();
        List<Integer> dCurrDiffs = new ArrayList<>();

        int[] diffsVals = new int[1000000];
        for(int i = 0; i<isleQ;i++){
            for (int j = i+1; j<isleQ;j++){
                int absDiff = Math.abs(isles[i] - isles[j]);
                diffs.add(absDiff);
                diffsVals[absDiff]++;
            }
        }

        int dCurr = 0;
        for(int d=1; d<isleQ;d++){
            dCurr += isleQ-d;
            if(dCurr >= ansNumber){
                System.out.println("dCurr: " + d);
                dCurr = d;
                break;
            }
        }

        int l = 0; int r = dCurr;
        while(r < isleQ){
            dCurrDiffs.add(isles[r]-isles[l]);
            l++; r++;
        }
        Collections.sort(dCurrDiffs);
        Collections.sort(diffs);

        printList(dCurrDiffs);



        for(int i = 0; i<diffsVals.length; i++){
            ansNumber = ansNumber - diffsVals[i];
            if(ansNumber<=0){
                System.out.println(i);
                return;
            }
        }
    }

    public static void printList(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(Integer i: list){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

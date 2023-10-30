package Yandex.Algo_course.Sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sprint4G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rounds = Integer.parseInt(br.readLine());
        int[] pfix = new int[rounds+1];
        pfix[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rounds; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == 0) {
                pfix[i+1] = pfix[i]-1;
            }
            if (v == 1) {
                pfix[i+1] = pfix[i]+1;
            }
        }
        int ans = 0;
        Map<Integer, Integer> enters = new HashMap<>();
        enters.put(0, 0);
        for(int p = 1; p<rounds+1;p++){
            if(enters.containsKey(pfix[p])){
                ans = Math.max(ans, p - enters.get(pfix[p]));
            }else{
                enters.put(pfix[p], p);
            }
        }
        System.out.println(ans);
    }
}

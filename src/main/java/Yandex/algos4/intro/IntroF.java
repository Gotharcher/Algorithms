package Yandex.algos4.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntroF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int capa = Integer.parseInt(br.readLine());
        int levels = Integer.parseInt(br.readLine());
        long ans = 0;
        int[] people = new int[levels];
        for(int i = 0; i < levels; i++){
            people[i] = Integer.parseInt(br.readLine());
        }
        for(int k = levels-1; k>=0; k--){
            int paths = (int) Math.ceil((double) people[k] / capa);
            ans += ((long) paths * 2 * (k+1));
            people[k] -= paths * capa;
            if(people[k] < 0 && k > 0){
                people[k-1] += people[k];
            }
        }
        System.out.println(ans);
    }
}

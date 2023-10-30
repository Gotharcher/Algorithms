package Yandex.algos4.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntroJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for(int t = 0; t<tests; t++){
            String[] ask = br.readLine().split(" ");
            int ppl = Integer.parseInt(ask[0]);
            int f = Integer.parseInt(ask[1]);
            int s = Integer.parseInt(ask[2]);
            if(ppl == f || ppl == s){
                System.out.println("YES");
                return;
            }
            if(ppl/f > ppl/s){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

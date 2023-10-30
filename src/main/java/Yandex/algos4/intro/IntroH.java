package Yandex.algos4.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntroH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

//        int minFirst = a/1;
//        int maxSecond = (int) Math.floor((double) b/c);
//
//        if(minFirst > maxSecond){
//            System.out.println("YES");
//        }else{
//            System.out.println("NO");
//        }

        if(((a-1)*n)+1 > b){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

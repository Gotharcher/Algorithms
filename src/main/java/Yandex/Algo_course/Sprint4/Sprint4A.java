package Yandex.Algo_course.Sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint4A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int base = Integer.parseInt(br.readLine());
        int mod = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long sum = 0;
        char[] ca = s.toCharArray();
        int sLen = s.length();
        for(int i = 0; i<sLen; i++){
            sum += (ca[i] * (long) Math.pow(base, sLen-i-1))%mod;
            sum = sum%mod;
        }


        System.out.println(sum);
    }
}

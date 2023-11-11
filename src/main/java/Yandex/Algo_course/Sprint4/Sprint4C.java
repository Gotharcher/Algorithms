package Yandex.Algo_course.Sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint4C {
    public static int base;
    public static int mod;
    public static long totalHash;
    public static String s;
    public static long[] prefixLeft, powArr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        base = Integer.parseInt(br.readLine());
        mod = Integer.parseInt(br.readLine());

        s = br.readLine();
        int asks = Integer.parseInt(br.readLine());
        prefixLeft  = new long[s.length()+1];
        prefixLeft[0] = 0;
        powArr  = new long[s.length()+1];
        powArr[0] = 1;
        powArr[1] = base;

        int sLen = s.length();

        for(int i = 0; i<sLen; i++){
            prefixLeft[i+1] = ((prefixLeft[i]*base)%mod + s.charAt(i))%mod;
        }
        for(int i = 2; i<=sLen;i++){
            powArr[i] = (powArr[i-1] * base)%mod;
        }

        for(int i = 0; i < asks; i++){
            String[] askStringArr = br.readLine().split(" ");
            int sIdx = Integer.parseInt(askStringArr[0]);
            int fIdx = Integer.parseInt(askStringArr[1]);
            System.out.println(calcSubHash(sIdx, fIdx));
        }
    }

    public static long calcSubHash(int sIdx, int fIdx){
        long subHash = prefixLeft[fIdx] - prefixLeft[sIdx-1]*powArr[fIdx-sIdx+1];
        subHash %= mod;
        subHash += mod;
        subHash %= mod;
        return subHash;
    }
}

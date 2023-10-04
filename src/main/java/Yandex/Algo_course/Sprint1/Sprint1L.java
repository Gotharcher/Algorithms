package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint1L {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fSeq = br.readLine();
        String sSeq = br.readLine();
        int fTotal = getStringCharsSum(fSeq);
        int sTotal = getStringCharsSum(sSeq);
        System.out.println(Character.toChars(sTotal-fTotal));
    }

    public static int getStringCharsSum(String s){
        int val = 0;
        char[] ca = s.toCharArray();
        for(int i=0; i<ca.length; i++){
            val += ca[i];
        }
        return val;
    }
}

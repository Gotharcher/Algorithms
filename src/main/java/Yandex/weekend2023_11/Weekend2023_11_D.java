package Yandex.weekend2023_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Weekend2023_11_D {
    static final int MODE = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        String hours = s[0];
        String minutes = s[1];

        int maxField = Math.max(hours.length(), minutes.length());

        int[] hoursDigits = new int[maxField];
        int[] minutesDigits = new int[maxField];
        int[] combis = new int[maxField];

        int hoursIdx = 0;
        while (hoursIdx + hours.length() < maxField){
            hoursDigits[hoursIdx] = 0;
            hoursIdx++;
        }
        for(char c: hours.toCharArray()){
            hoursDigits[hoursIdx] = Character.getNumericValue(c);
            hoursIdx++;
        }

        int minutesIdx = 0;
        while (minutesIdx + minutes.length() < maxField){
            minutesDigits[minutesIdx] = 0;
            minutesIdx++;
        }
        for(char c: minutes.toCharArray()){
            minutesDigits[minutesIdx] = Character.getNumericValue(c);
            minutesIdx++;
        }

        hoursDigits[maxField-1] --;
        minutesDigits[0] --;
        for(int k = 1; k<maxField; k++){
//            if(minutesDigits[])
        }



        for(int k = 0; k<maxField; k++){
            int vars = Math.min(hoursDigits[k], minutesDigits[maxField-1-k]) + 1;
            combis[k] = vars;
        }

        long ans = combis[0];

        for(int k = 1; k<maxField; k++){
            ans += ((long) combis[k] * ans) % MODE;
        }

        System.out.println(ans);
    }
}

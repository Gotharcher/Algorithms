package Yandex.weekend2023_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Weekend2023_11_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int hours = Integer.parseInt(s[0]);
        int mins = Integer.parseInt(s[1]);

        int maxField = Math.max(hours, mins) -1;
        int maxLen = Integer.toString(maxField).length();

        int ans = 0;

        for(int i = 0; i<hours;i++){
            StringBuilder sb = new StringBuilder();
            for(char c: Integer.toString(i).toCharArray()){
                sb.append(c);
            }
            sb.reverse();
            while(sb.length() < maxLen){
                sb.append(0);
            }
            if(Integer.parseInt(sb.toString()) < mins){
                ans++;
            }
        }
        System.out.println(ans);
    }
}

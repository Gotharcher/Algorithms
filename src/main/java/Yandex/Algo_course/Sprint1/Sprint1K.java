package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint1K {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String seq = br.readLine();
        String[] digits = seq.split(" ");
        String sStr = br.readLine();
        char[] sCharArr = sStr.toCharArray();
        StringBuilder sb = new StringBuilder();

        int appendix = 0;
        int sLen = sStr.length();
        int maxLength = Math.max(sLen, len);
        for(int i=1; i<=maxLength; i++){
            int firstDigit = 0;
            if(i<=len){
                firstDigit = Integer.parseInt(digits[len-i]);
            }
            int secondDigit = 0;
            if(i<=sLen) {
                secondDigit = Character.getNumericValue(sCharArr[sLen - i]);

            }
            int val = firstDigit+secondDigit+appendix;
            sb.append(val%10);
            sb.append(" ");
            appendix = val/10;
        }
        if(appendix>0){
            sb.append(appendix);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
        System.out.println(sb);
    }
}

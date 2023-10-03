package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint1H {
    public static int fSize = 0;
    public static int sSize = 0;
    public static char[] fCharArr;
    public static char[] sCharArr;
    public static StringBuilder sb = new StringBuilder();
    public static int appendix = 0;

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fVal = br.readLine();
        fCharArr = fVal.toCharArray();
        fSize = fCharArr.length;
        String sVal = br.readLine();
        sCharArr = sVal.toCharArray();
        sSize = sCharArr.length;
        int maxIter = Math.max(fSize, sSize);
        for(int iter = 0; iter < maxIter; iter++){
            countPos(iter);
        }
        if(appendix == 1){
            sb.append(1);
        }
        sb.reverse();
        System.out.println(sb);
    }

    public static void countPos(int iter){
        int fDigit = Character.getNumericValue(getArrDigit(iter, true));
        int sDigit = Character.getNumericValue(getArrDigit(iter, false));
        int res = fDigit + sDigit + appendix;
        sb.append(res%2);
        appendix = res/2;
    }

    public static char getArrDigit(int iter, boolean first){
        int index;
        if(first){
            index = fSize-iter-1;
            if(index<0){
                return '0';
            }else{
                return fCharArr[index];
            }
        }else{
            index = sSize-iter-1;
            if(index<0){
                return '0';
            }else{
                return sCharArr[index];
            }
        }
    }
}

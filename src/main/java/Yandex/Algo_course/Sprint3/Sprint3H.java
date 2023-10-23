package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint3H {
    public static int totalNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalNums = Integer.parseInt(br.readLine());
        String[] nums = new String[totalNums];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalNums; i++) {
            nums[i] = st.nextToken();
        }

        sortMyStrings(nums);

//        System.out.println(Arrays.toString(nums));

        StringBuilder sb = new StringBuilder();
        for (int i = totalNums - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }
        System.out.println(sb);
    }

    public static void sortMyStrings(String[] sArr) {
        for (int i = 0; i < totalNums; i++) {
            for (int j = 0; j < totalNums - 1; j++) {
                if (biggerString(sArr[j], sArr[j + 1])) {
                    String buf = sArr[j + 1];
                    sArr[j + 1] = sArr[j];
                    sArr[j] = buf;
                }
            }
        }
    }

    public static boolean biggerString(String a, String b){
        return recStringCompare(a.toCharArray(), b.toCharArray(), 0);
    }

    public static boolean recStringCompare(char[] a, char[] b, int idx) {
        if(idx >= a.length && idx >= b.length){
            return a[a.length-1] > b[b.length-1];
        }else {
            char aComp = getCompChar(a, idx);
            char bComp = getCompChar(b, idx);
            if (aComp == bComp) {
                return recStringCompare(a, b, idx + 1);
            } else {
                return aComp > bComp;
            }
        }
    }

    public static char getCompChar(char[] ca, int idx){
        if(idx >= ca.length){
            return ca[0];
        }else{
            return ca[idx];
        }
    }
}

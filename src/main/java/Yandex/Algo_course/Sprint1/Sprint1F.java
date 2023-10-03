package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint1F {

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] charArr = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(!Character.isLetterOrDigit(charArr[left])){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(charArr[right])){
                right--;
                continue;
            }
            if(Character.toLowerCase(charArr[left]) != Character.toLowerCase(charArr[right])){
                System.out.println("False");
                return;
            }
            left++; right--;
        }
        System.out.println("True");
    }
}

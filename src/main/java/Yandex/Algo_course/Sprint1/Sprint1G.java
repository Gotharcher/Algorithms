package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint1G {

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int decVal = Integer.parseInt(br.readLine());
        if(decVal == 0){
            System.out.println(0);
            return;
        }
        while(decVal>1){
            sb.append(decVal%2);
            decVal = decVal/2;
        }
        if(decVal ==1) {
            sb.append(decVal);
        }
        sb.reverse();
        System.out.println(sb);
    }
}

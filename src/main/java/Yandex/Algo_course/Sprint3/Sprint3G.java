package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint3G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int items = Integer.parseInt(br.readLine());
        int[] colors = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            colors[Integer.parseInt(st.nextToken())]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<colors.length; i++){
            for(int k=0;k<colors[i];k++){
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }
}

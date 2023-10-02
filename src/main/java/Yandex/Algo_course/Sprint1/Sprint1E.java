package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint1E {

    public static void main(String[] ars) throws IOException {
        int ans = 0;
        String word = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalLength = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            String currWord = st.nextToken();
            if(currWord.length() > ans){
                ans = currWord.length();
                word = currWord;
            }
        }
        System.out.println(word);
        System.out.println(ans);
    }

}

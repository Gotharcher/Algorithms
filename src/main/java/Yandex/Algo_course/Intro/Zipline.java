package Yandex.Algo_course.Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Zipline {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        StringTokenizer arrayOne = new StringTokenizer(br.readLine());
        StringTokenizer arrayTwo = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arraySize; i++){
            sb.append(arrayOne.nextToken());
            sb.append(" ");
            sb.append(arrayTwo.nextToken());
            sb.append(" ");
        }

        System.out.println(sb);
    }
}

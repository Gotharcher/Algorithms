package Yandex.Algo_course.Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlitherMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        int window = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        float curSum = 0;
        for(int i=0; i< window; i++){
            curSum+= Integer.parseInt(array[i]);
        }
        sb.append(curSum/window);
        sb.append(" ");
        for(int k=window; k<arraySize; k++){
            curSum+=Integer.parseInt(array[k]);
            curSum-=Integer.parseInt(array[k-window]);
            sb.append(curSum/window);
            sb.append(" ");
        }
        System.out.println(sb);
    }

}

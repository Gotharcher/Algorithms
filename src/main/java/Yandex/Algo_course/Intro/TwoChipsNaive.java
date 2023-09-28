package Yandex.Algo_course.Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoChipsNaive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        int sum = Integer.parseInt(br.readLine());
        for(int i=0; i<arraySize; i++){
            int firstVal = Integer.parseInt(array[i]);
            for(int j = i + 1; j < arraySize; j++) {
                if (firstVal + Integer.parseInt(array[j]) == sum) {
                    System.out.println(array[i] + " " + array[j]);
                    return;
                }
            }
        }
        System.out.println("None");
    }
}

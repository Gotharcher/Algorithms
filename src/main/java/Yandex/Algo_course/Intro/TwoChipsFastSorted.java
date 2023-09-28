package Yandex.Algo_course.Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoChipsFastSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        String[] stringArray = br.readLine().split(" ");
        int sum = Integer.parseInt(br.readLine());
        int[] array = new int[arraySize];
        for(int i=0; i< arraySize; i++){
            array[i] = Integer.parseInt(stringArray[i]);
        }
        Arrays.sort(array);
        int alef = 0;
        int omeg = arraySize-1;
        for(;;){
            if(alef == omeg){
                System.out.println("None");
                return;
            }
            int arraySum = array[alef] + array[omeg];
            if(arraySum == sum){
                System.out.println(array[alef] + " " + array[omeg]);
                return;
            }
            if(arraySum > sum){
                omeg--;
            }
            if(arraySum < sum){
                alef++;
            }
        }
    }
}

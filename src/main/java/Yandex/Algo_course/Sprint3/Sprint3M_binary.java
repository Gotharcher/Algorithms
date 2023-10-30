package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Sprint3M_binary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        String[] firstArr = br.readLine().split(" ");
        String[] secondArr = br.readLine().split(" ");

        float[] floatArrF = new float[first];
        for(int i=0; i<first;i++){
            floatArrF[i] = Float.parseFloat(firstArr[i]);
        }

        float[] floatArrS = new float[second];
        for(int i=0; i<second;i++){
            floatArrS[i] = Float.parseFloat(secondArr[i]);
        }


        float medF = getMed(firstArr, first);
        float medS = getMed(secondArr, second);
        float bothMed = (medF+medS)/2;

        int posF = Arrays.binarySearch(floatArrF, bothMed);
        int posS = Arrays.binarySearch(floatArrS, bothMed);


        System.out.println("medS: " + medF + ", medS: " + medS + ", bothMed: " + bothMed);
        System.out.println("posF: " + posF + ", posS: " + posS);

    }

    public static float getMed(String[] ss, int size){
        if(size%2==1){
            return Integer.parseInt(ss[size/2]);
        }else{
            return  (float) (Integer.parseInt((ss[size / 2])) + Integer.parseInt(ss[(size / 2) - 1])) / 2;
        }
    }
}

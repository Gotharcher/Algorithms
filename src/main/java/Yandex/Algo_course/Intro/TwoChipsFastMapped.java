package Yandex.Algo_course.Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TwoChipsFastMapped {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        int sum = Integer.parseInt(br.readLine());
        Set<Integer> chipsSet = new HashSet<>();
        for(int i=0; i< arraySize; i++){
            int val = Integer.parseInt(array[i]);
            if(chipsSet.contains(sum-val)){
                System.out.println(val + " " + (sum-val));
                return;
            }
            chipsSet.add(val);
        }
        System.out.println("None");
    }
}

package Yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example_2023_5 {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int reciepts = Integer.parseInt(br.readLine()) - 2;
        int[][] cookbook = new int[reciepts][2];
        for(int i=0; i< reciepts; i++) {
            String[] reciept = br.readLine().split(" ");
        }
        int questions = Integer.parseInt(br.readLine());
        for(int i=0; i< questions; i++) {
            String[] ask = br.readLine().split(" ");
        }
    }
}

package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint3L {
    public static int totalDays;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalDays = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bikePrice = Integer.parseInt(br.readLine());
        int[] prices = new int[totalDays];
        for (int i = 0; i < totalDays; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

//        int firstBike = binarySearch(prices, bikePrice,0, totalDays-1)+1;
//        int secondBike = binarySearch(prices, bikePrice*2, 0, totalDays-1)+1;

        int firstBike = recursionSearch(prices, bikePrice)+1;
        int secondBike = recursionSearch(prices, bikePrice*2)+1;

        System.out.println(firstBike + " " + secondBike);
    }

    public static int builtInBinarySearch(int[] arr, int val){
        return Arrays.binarySearch(arr, val);
    }

    public static int recursionSearch(int[] arr, int val) {
        int buildFound = builtInBinarySearch(arr, val);
        if (buildFound < 0) {
            int absVal = Math.abs(buildFound);
            if (absVal > totalDays) {
                return -2;
            } else {
                buildFound = absVal-1;
            }
        }
        while (buildFound >= 0) {
            int lefterVal = builtInBinarySearch(Arrays.copyOfRange(arr, 0, buildFound), val);
            if (lefterVal >= 0) {
                buildFound = lefterVal;
            } else {
                return buildFound;
            }
        }

        return -2;
    }
}

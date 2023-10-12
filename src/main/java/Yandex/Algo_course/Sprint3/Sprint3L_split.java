package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Сравнение строк во встроенном бинарном поиске не работает

public class Sprint3L_split {
    public static int totalDays;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalDays = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] prices = br.readLine().split(" ");
        String bikePrice = br.readLine();
        String twoBikesPrice = (Integer.parseInt(bikePrice)*2) + "";

//        System.out.println(bikePrice);
//        System.out.println(twoBikesPrice);

        int firstBike = recursionSearch(prices, bikePrice) + 1;
        int secondBike = recursionSearch(prices, twoBikesPrice) + 1;

        System.out.println(firstBike + " " + secondBike);
    }

    public static int builtInBinarySearch(String[] arr, String val) {
        return Arrays.binarySearch(arr, val);
    }

    public static int recursionSearch(String[] arr, String val) {
        int buildFound = builtInBinarySearch(arr, val);
        if (buildFound < 0) {
            int absVal = Math.abs(buildFound);
            if (absVal > totalDays) {
                return -2;
            } else {
                buildFound = absVal - 1;
                return buildFound;
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

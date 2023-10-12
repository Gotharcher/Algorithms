package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint3L_flat {
    public static int totalDays;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalDays = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bikePrice = Integer.parseInt(br.readLine());
        int firstDay = -1;
        int secondDay = -1;
        for (int i = 1; i <= totalDays; i++) {
            int currMoney = Integer.parseInt(st.nextToken());
            if (firstDay == -1 && bikePrice <= currMoney) {
                firstDay = i;
            }
            if (firstDay != -1 && secondDay == -1 && bikePrice * 2 <= currMoney) {
                secondDay = i;
            }
        }

//        int firstBike = recursionSearch(prices, bikePrice) + 1;
//        int secondBike = recursionSearch(prices, bikePrice * 2) + 1;

        System.out.println(firstDay + " " + secondDay);
    }
}

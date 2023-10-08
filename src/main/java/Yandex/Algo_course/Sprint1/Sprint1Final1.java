// ID 92019083

package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sprint1Final1 {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String[] houses = br.readLine().split(" ");

        int[] ansArr = new int[len];                    //10^6 интов -> 4 мегабайта. Тут храним ответы, расстояния.
        List<Integer> zeroList = new ArrayList<>(len);  //может быть так, что все дома - нули, а расширять лист с "10" до "1кк" - многовато раз.
        for (int i = 0; i < len; i++) {                        //формируем лист с нулями
            if (houses[i].equals("0")) {
                zeroList.add(i);
            }
        }
        for (int i = 0; i < len; i++) {    //для каждого дома ищем два ближайших участка (тот же номер участка искать не нужно)
            if (houses[i].equals("0")) {
                ansArr[i] = 0;
                continue;
            }
            ansArr[i] = binarySearchNearestValue(zeroList, i); //ищем бинарно, чтобы было быстрее, у нас нет времени каждый раз искать (10^6)/2
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < len; k++) {
            sb.append(ansArr[k]);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearchNearestValue(List<Integer> arr, int val) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right - 1) {
            int med = (left + right) / 2;
            if (arr.get(med) > val) {
                right = med;
            }
            if (arr.get(med) < val) {
                left = med;
            }
            if (arr.get(med) == val) {
                break;
            }
        }
        return Math.abs(Math.min(val - arr.get(left), arr.get(right) - val));
    }
}

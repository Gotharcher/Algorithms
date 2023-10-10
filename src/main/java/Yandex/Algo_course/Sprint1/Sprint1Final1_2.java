// ID 92491534

package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sprint1Final1_2 {
    static int len;
    static int[] ansArr;

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        String[] houses = br.readLine().split(" ");

        ansArr = new int[len];                    //10^6 интов -> 4 мегабайта. Тут храним ответы, расстояния.
        List<Integer> zeroList = new ArrayList<>(len);  //может быть так, что все дома - нули, а расширять лист с "10" до "1кк" - многовато раз.
        for (int i = 0; i < len; i++) {                        //формируем лист с нулями
            if (houses[i].equals("0")) {
                zeroList.add(i);
            }
        }
        fillAnsArr(zeroList);
        printAns();
    }

    public static void printAns() {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < len; k++) {
            sb.append(ansArr[k]);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void fillAnsArr(List<Integer> zeroArr) {
        fillLeftArr(zeroArr.get(0));
        fillRightArr(zeroArr.get(zeroArr.size() - 1));
        for (int i = 0; i < zeroArr.size() - 1; i++) {
            fillMiddleArr(zeroArr.get(i), zeroArr.get(i + 1));
        }
    }

    public static void fillLeftArr(int zeroPos) {
        for (int i = 0; i < zeroPos; i++) {
            ansArr[i] = zeroPos - i;
        }
    }

    public static void fillRightArr(int zeroPos) {
        for (int i = zeroPos; i < len; i++) {
            ansArr[i] = i - zeroPos;
        }
    }

    public static void fillMiddleArr(int left, int right) {
        for (int i = left; i < right; i++) {
            ansArr[i] = Math.min(i - left, right - i);
        }
    }
}

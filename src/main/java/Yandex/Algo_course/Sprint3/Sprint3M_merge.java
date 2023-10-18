package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sprint3M_merge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        String[] firstArr = br.readLine().split(" ");
        String[] secondArr = br.readLine().split(" ");

        int ansPos;
        boolean needNext = (first + second) % 2 == 0;
        if (needNext) {
            ansPos = ((first + second) / 2) - 1;
        } else {
            ansPos = (first + second) / 2;
        }

        List<Integer> merged = new ArrayList<>();

        while (true) {
            if (first > 0 && second > 0) {
                if (Integer.parseInt(firstArr[firstArr.length - first]) < Integer.parseInt(secondArr[secondArr.length - second])) {
                    merged.add(Integer.parseInt(firstArr[firstArr.length - first]));
                    first--;
                } else {
                    merged.add(Integer.parseInt(secondArr[secondArr.length - second]));
                    second--;
                }
            } else {
                if (first > 0) {
                    merged.add(Integer.parseInt(firstArr[firstArr.length - first]));
                    first--;
                }
                if (second > 0) {
                    merged.add(Integer.parseInt(secondArr[secondArr.length - second]));
                    second--;
                }
            }
            if (first == 0 && second == 0) {
                break;
            }
        }
        float ans;
        if (needNext) {
            ans = ((float) (merged.get(ansPos + 1) + merged.get(ansPos)) / 2);
            if (ans % 1.0 != 0)
                System.out.printf("%s", ans);
            else
                System.out.printf("%.0f", ans);
        } else {
            ans = merged.get(ansPos);
            System.out.println(ans);
        }
    }
}

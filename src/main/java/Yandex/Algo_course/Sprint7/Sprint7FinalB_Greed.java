package Yandex.Algo_course.Sprint7;

/*
ПРИНЦИП РАБОТЫ
Сумма должна делиться на 2 без остатка.
Потом динамически наберем "рюкзак" цифрами до половины суммы очков.
 */


/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
 */

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint7FinalB_Greed {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int qty = Integer.parseInt(br.readLine());
        int[] vals = new int[qty];

        int totalSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < qty; i++) {
            vals[i] = Integer.parseInt(st.nextToken());
            totalSum += vals[i];
        }

        //Если исходное количество очков нечётное, сразу на выход.
        if (totalSum % 2 != 0) {
            System.out.println("False");
            return;
        }

        Arrays.sort(vals);

        int lSum = 0;
        int rSum = 0;

        for (int i = qty; i > 0; i--) {
            if (lSum > rSum) {
                rSum += vals[i - 1];
            } else {
                lSum += vals[i - 1];
            }
        }

        //Контест, почему ты не принимаешь булево?!
        if (rSum == lSum) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

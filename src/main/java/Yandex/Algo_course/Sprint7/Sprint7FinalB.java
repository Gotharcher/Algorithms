//102981164
//https://contest.yandex.ru/contest/25597/run-report/102981164/

package Yandex.Algo_course.Sprint7;

/*
ПРИНЦИП РАБОТЫ
Сумма должна делиться на 2 без остатка.
Потом динамически наберем "рюкзак" цифрами до половины суммы очков. Если в последней ячейке dp будет нужная сумма - всё ок.

N - количество чисел. S - их сумма.
 */

/*
ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ
Решением будет аналог задачи о рюкзаке, где "ценностью" будет искомая сумма, объемом рюкзака - достижимые суммы, а грузами - исходные числа.
Базой будет нулевой вес и нулевой груз.
Переходом будет возможность разместить текущий груз в рюкзаке и забить остаток веса данными из предыдущей строки для остаточного веса, или забить весь доступный вес данными из предыдущей строки.
Больше полусуммы значений в полях не будет - это ограничение "рюкзака". Если искомая сумма собрана раньше последней строки,
то она упадет вниз, к полю ответа, переходом по условию "вес из предыдущей строки". То есть ответ будет корректен даже в том случае, если числа ниже не дадут искомой суммы в различных комбинациях.
 */


/*
ВРЕМЕННАЯ СЛОЖНОСТЬ
Изначальное заполнение данных занимает O(N).
Необходимо пройти каждое число из выданных до половины суммы - O(N*S/2). Еще время потребуется на копирование dp-строк, зависящее от их размера (N*S/2).
Итоговая сложность: O(N*S)
 */

/*
ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ
Данные dp хранятся только в двух строках, поэтому пространственная сложность зависит только от суммы чисел - это размер массива-строки, который равен половине суммы.
Хранится исходный массив данных и две строки - O(N + 2* S/2)
Итоговая сложность: O(S)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint7FinalB {
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

        //Это необязательное действие, но с ним гораздо проще в голове прокручивать решение
        Arrays.sort(vals);

        int fSum = totalSum / 2;

        //матрица ДП упирается в размер, поэтому обойдемся двумя строками.
        int[] prev = new int[fSum + 1];
        int[] curr = new int[fSum + 1];

        for (int val = 1; val < qty + 1; val++) {
            int currVal = vals[qty - val];
            for (int desSum = 1; desSum < fSum + 1; desSum++) {
                if (currVal > desSum) {
                    //В сортированном массиве, кстати, этого не произойдёт
                    curr[desSum] = prev[desSum];
                } else {
                    curr[desSum] = Math.max(prev[desSum], prev[desSum - currVal] + currVal);
                }
            }
            prev = curr.clone();
        }

        //Контест, почему ты не принимаешь булево?!
        if (curr[fSum] == fSum) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

package Yandex.Algo_course.Sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sprint8L {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String mask = br.readLine();
        String repTo = br.readLine();

        List<Integer> enters = search(mask, s);

        int entersIdx = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (entersIdx < enters.size()) {
                if (i == enters.get(entersIdx)) {
                    i += mask.length() - 1;
                    sb.append(repTo);
                    entersIdx++;
                } else {
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
    }


    public static List<Integer> search(String p, String text) {
        // Функция возвращает все позиции вхождения шаблона в тексте.
        List<Integer> result = new ArrayList<>();
        String s = p + "#" + text;
        int[] arr = new int[p.length()];  // Массив длины |p|.
        Arrays.fill(arr, 0);
        int arr_prev = 0;
        for (int i = 1; i < s.length(); i++) {
            int k = arr_prev;
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = arr[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            // Запоминаем только первые |p| значений arr-функции.
            if (i < p.length()) {
                arr[i] = k;
            }
            // Запоминаем последнее значение arr-функции.
            arr_prev = k;
            // Если значение arr-функции равно длине шаблона, то вхождение найдено.
            if (k == p.length()) {
                // i - это позиция конца вхождения шаблона.
                // Дважды отнимаем от него длину шаблона, чтобы получить позицию начала:
                //  - чтобы «переместиться» на начало найденного шаблона,
                //  - чтобы не учитывать добавленное "pattern#".
                result.add(i - 2 * p.length());
            }
        }
        return result;
    }
}

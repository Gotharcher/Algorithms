//ID 92022876

package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Sprint1Final2 {
    public static final int DATA_ROWS = 4;
    public static final int GAME_CYCLES = 9;
    public static final int PLAYERS_COUNT = 2;
    public static Map<Integer, Integer> digitsCount = new HashMap<>();
    //нет требований к положению "рук", поэтому просто сравним число пальцев (которыми оперируют игроки) с числом кнопок

    public static void main(String[] ars) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxInput = Integer.parseInt(br.readLine()) * PLAYERS_COUNT;
        for (int i = 1; i <= DATA_ROWS; i++) { //4 строки с данными
            stringToMap(br.readLine());
        }
        for (int i = 1; i <= GAME_CYCLES; i++) {
            if (digitsCount.get(i) != null && digitsCount.get(i) <= maxInput) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void stringToMap(String s) {
        char[] ca = s.toCharArray();
        for (char c : ca) {
            if (c == '.') {
                continue;
            }
            digitsCount.put(Character.getNumericValue(c), digitsCount.getOrDefault(Character.getNumericValue(c), 0) + 1);
        }
    }
}

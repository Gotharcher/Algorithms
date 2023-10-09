//ID 92491235

package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint1Final2_2 {
    public static final int DATA_ROWS = 4; //4 строки с данными
    public static final int GAME_CYCLES = 9; //раунды, с 1 по 9
    public static final int PLAYERS_COUNT = 2;
    public static int[] buttons = new int[GAME_CYCLES];
    //нет требований к положению "рук", поэтому просто сравним число пальцев (которыми оперируют игроки) с числом кнопок

    public static void main(String[] ars) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxInput = Integer.parseInt(br.readLine()) * PLAYERS_COUNT;
        for (int i = 1; i <= DATA_ROWS; i++) {
            stringToMap(br.readLine());
        }
        for (int i = 1; i <= GAME_CYCLES; i++) {
            if (buttons[i-1] != 0 && buttons[i-1] <= maxInput) {
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
            buttons[Character.getNumericValue(c)-1]++;
        }
    }
}

package Yandex.Algo_course.Sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint8L {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            int k = arr[i - 1];
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = arr[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            arr[i] = k;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);
    }

}
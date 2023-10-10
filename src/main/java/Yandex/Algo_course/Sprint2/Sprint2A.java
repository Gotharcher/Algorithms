package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sprint2A {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < cols; k++) {
                matrix[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int k = 0; k < rows; k++) {
                sb.append(matrix[k][i]);
                sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
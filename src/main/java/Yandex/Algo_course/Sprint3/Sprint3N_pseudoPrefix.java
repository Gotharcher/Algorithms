package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint3N_pseudoPrefix {
    public static PrintWriter pw;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        pseudoPrefixSolution();

        pw.close();
    }

    public static void pseudoPrefixSolution() throws IOException {
        int slices = Integer.parseInt(br.readLine());
        int[] gardeners = new int[10000001];
        for (int i = 0; i < slices; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gardeners[Integer.parseInt(st.nextToken())]++;
            gardeners[Integer.parseInt(st.nextToken())]--;
        }
        int diggedTimes = 0;
        boolean digged = false;
        for(int i =0; i<gardeners.length;i++){
            diggedTimes += gardeners[i];
            if (diggedTimes > 0) {
                if (!digged) {
                    pw.print(i + " ");
                    digged = true;
                }
            } else {
                if (digged) {
                    pw.println(i);
                    digged = false;
                }
            }
        }
    }
}

package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Sprint3N {
    public static PrintWriter pw;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        arraySolution();

        pw.close();
    }

    public static void arraySolution() throws IOException {
        int slices = Integer.parseInt(br.readLine());

        int[][] gardeners = new int[slices][2];
//        boolean[] field = new boolean[10000000]; //10 MBs

        for (int i = 0; i < slices; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            fillArray(field, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            gardeners[i][0] = Integer.parseInt(st.nextToken());
            gardeners[i][1] = -Integer.parseInt(st.nextToken());
        }
//        printBoolArray(field);

        Arrays.sort(gardeners, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        printDoubleArray(gardeners);

        pw.close();
    }

    public static void printDoubleArray(int[][] arr) {
        int start = arr[0][0];
        int fin = -arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= fin) {
            } else {
                pw.println(start + " " + fin);
                start = arr[i][0];
            }
            fin = Math.max(fin, -arr[i][1]);
        }
        pw.println(start + " " + fin);
    }

    public static void printBoolArray(boolean[] field) {
        boolean digged = false;
        for (int k = 0; k < field.length; k++) {
            if (field[k]) {
                if (!digged) {
                    pw.print(k + " ");
                    digged = true;
                }
            } else {
                if (digged) {
                    pw.println(k);
                    digged = false;
                }
            }
        }
    }


    public static void fillArray(boolean[] arr, int start, int stop) {
        for (int i = start; i < stop; i++) {
            arr[i] = true;
        }
        //TL, well, this was obviously - 10^5 * 10^7 >>> 2 secs.
    }

}

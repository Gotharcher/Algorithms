package Yandex.Algo_course.Sprint3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sprint3A {
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        Integer size = sc.nextInt();

        printSeq(size, size, "");

        pw.close();
    }

    public static void printSeq(int left, int right, String ans) {
        if (right == 0) {
            pw.println(ans);
        } else {
            if (left > 0) {
                printSeq(left - 1, right, ans + "(");
            }
            if (left < right) {
                printSeq(left, right - 1, ans + ")");
            }
        }
    }
}

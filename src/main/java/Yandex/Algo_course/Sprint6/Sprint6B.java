package Yandex.Algo_course.Sprint6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprint6B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] inpSS = br.readLine().split(" ");
        int v = Integer.parseInt(inpSS[0]);
        int e = Integer.parseInt(inpSS[1]);

        int[][] matrix = new int[v][v];

        for(int i = 0; i<e; i++){
            String[] ss = br.readLine().split(" ");
            matrix[Integer.parseInt(ss[0])-1][Integer.parseInt(ss[1])-1] = 1;
        }

        for(int k=0; k<v;k++){
            for(int m=0; m<v;m++){
                pw.print(matrix[k][m]);
                pw.print(" ");
            }
            pw.println();
        }
        br.close();
        pw.close();
    }
}

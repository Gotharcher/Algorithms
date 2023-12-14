package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint7L {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int qty = Integer.parseInt(inp[0]);
        int weight = Integer.parseInt(inp[1]);

        int[] golds = new int[qty];

        int[][] dp = new int[qty + 1][weight + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < qty; i++) {
            golds[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(golds);

        int[] prevLine;
        int[] currLine = dp[0];

        for (int q = 1; q < qty + 1; q++) {
            prevLine = dp[q - 1];
            currLine = dp[q];
            for (int w = 0; w < weight + 1; w++) {
                if (golds[qty - q] > w) {
                    currLine[w] = Math.max(0, prevLine[w]);
                } else {
                    if (w - golds[qty - q] < 0) {
                        currLine[w] = Math.max(golds[qty - q], prevLine[w]);
                    } else {
                        currLine[w] = Math.max(golds[qty - q] + prevLine[w - golds[qty - q]], prevLine[w]);
                    }
                }

            }
        }
        System.out.println(currLine[weight]);
    }
}

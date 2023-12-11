package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint7F {
    public static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        Integer strsQty = Integer.parseInt(ss[0]);
        Integer jump = Integer.parseInt(ss[1]);

        int[] stairs = new int[strsQty + jump - 1];

        stairs[jump - 1] = 1;

        int slither = 1;
        for (int i = jump; i < strsQty + jump - 1; i++) {
            stairs[i] = slither;
            slither += stairs[i];
            slither = slither % MOD;
            slither -= stairs[i - jump];
            slither = (slither + MOD) % MOD;
        }

        System.out.println(stairs[strsQty + jump - 2]);

        br.close();
    }
}


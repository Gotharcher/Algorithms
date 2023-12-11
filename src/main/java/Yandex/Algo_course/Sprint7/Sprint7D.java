package Yandex.Algo_course.Sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint7D {
    public static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer intern = Integer.parseInt(br.readLine());

        if (intern == 0 || intern == 1) {
            System.out.println(1);
            return;
        }
        int res = fiboInterns(intern);
        System.out.println(res);
    }

    public static int fiboInterns(int intern) {
        int prePre = 1;
        int pre = 1;
        int cur = 0;
        for (int i = 2; i < intern + 1; i++) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur % MOD;
        }
        return cur % MOD;
    }
}


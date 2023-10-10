package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint2L {
    public static int mod;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpData = br.readLine().split(" ");
        Integer intern = Integer.parseInt(inpData[0]);
        Integer modPow = Integer.parseInt(inpData[1]);
        mod = (int) Math.pow(10, modPow);
        if(intern == 0 || intern == 1){
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
            pre = cur%mod;
        }
        return cur%mod;
    }
}

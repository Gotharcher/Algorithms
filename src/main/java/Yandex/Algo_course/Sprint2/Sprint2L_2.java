package Yandex.Algo_course.Sprint2;

import java.io.IOException;
import java.util.Scanner;

public class Sprint2L_2 {
    public static int mod;
    public static int[] arrVals;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inpData = br.readLine().split(" ");
        Scanner scanner = new Scanner(System.in);
        int intern = scanner.nextInt();
        int modPow = scanner.nextInt();
//        Integer intern = Integer.parseInt(inpData[0]);
//        Integer modPow = Integer.parseInt(inpData[1]);
        if (intern == 0 || intern == 1) {
            System.out.println(1);
            return;
        }
//        long tms = System.currentTimeMillis();
        arrVals = new int[intern + 1];
        arrVals[0] = 1;
        arrVals[1] = 1;
        mod = (int) Math.pow(10, modPow);
        int res = recFiboWithArray(intern);
        System.out.println(res);
//        System.out.println("time spent: " + (System.currentTimeMillis() - tms));
    }

    public static int recFiboWithArray(int step) {
        if (arrVals[step] == 0) {
            arrVals[step] = (recFiboWithArray(step - 1) + recFiboWithArray(step - 2)) % mod;
        }
        return arrVals[step];
    }
}

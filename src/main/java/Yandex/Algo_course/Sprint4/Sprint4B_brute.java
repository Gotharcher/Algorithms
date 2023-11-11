package Yandex.Algo_course.Sprint4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Sprint4B_brute {
    public static int base = 1000;
    public static int mod = 123987123;
    public static boolean found = false;
    public static Map<Long, String> hashesMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100000; i++) {
            if (found) {
                return;
            }
            randomHash(20);
//            randomHash(23);
        }
    }

    public static void randomHash(int sizeLimit) {
        Random r = new Random();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < sizeLimit; i++) {
            int rCharGap = r.nextInt('z' - 'a');
            sb1.append((char) ('a' + rCharGap));
        }
        long hash1 = calcHash(sb1.toString());
        if (hashesMap.containsKey(hash1)) {
            System.out.println(hashesMap.get(hash1));
            System.out.println(sb1);
            found = true;
            return;
        } else {
            hashesMap.put(hash1, sb1.toString());
        }
    }

    public static long calcHash(String s) {
        long sum = 0;
        char[] ca = s.toCharArray();
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            if (i == sLen - 1) {
                sum = ((sum + ca[i])) % mod;
            } else {
                sum = ((sum + ca[i]) * base) % mod;
            }
        }
        return sum;
    }
}

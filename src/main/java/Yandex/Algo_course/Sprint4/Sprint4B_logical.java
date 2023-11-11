package Yandex.Algo_course.Sprint4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Sprint4B_logical {
    public static int base = 1000;
    public static int mod = 123987123;
    public static Map<Long, String> hashesMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println(calcHash("aaaaa"));
        System.out.println(calcHash("bbbbb"));
    }

    public static void addRecHash(String initS) {
        if(initS.length() > 10){
            return;
        }
        for (int i = 'a'; i < 'z'; i++) {
            long hashRes = calcHash(initS + (char) i);
            if (hashesMap.containsKey(hashRes)) {
                System.out.println(hashesMap.get(hashRes));
                System.out.println(initS + (char) i);
                return;
            }
            addRecHash(initS + (char) i);
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

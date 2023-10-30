package Yandex.algos4.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IntroD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] one = br.readLine().toCharArray();
        char[] two = br.readLine().toCharArray();
        if(one.length != two.length){
            System.out.println("NO");
            return;
        }
        Map<Character, Integer> oneMap = new HashMap<>();
        Map<Character, Integer> twoMap = new HashMap<>();
        for(int i = 0; i< one.length; i++){
            oneMap.put(one[i], oneMap.getOrDefault(one[i], 0)+1);
        }
        for(int i = 0; i< two.length; i++){
            twoMap.put(two[i], twoMap.getOrDefault(two[i], 0)+1);
        }

        for(Map.Entry<Character, Integer> me: oneMap.entrySet()){
            if(!Objects.equals(me.getValue(), twoMap.get(me.getKey()))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

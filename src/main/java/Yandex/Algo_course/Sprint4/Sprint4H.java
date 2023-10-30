package Yandex.Algo_course.Sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sprint4H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String one = br.readLine();
        String two = br.readLine();
        if(one.length() != two.length()){
            System.out.println("NO");
            return;
        }
        char[] oneCA = one.toCharArray();
        char[] twoCA = two.toCharArray();

        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> usedChars = new HashSet<>();

        for(int i = 0; i<one.length();i++){
            if(!charMap.containsKey(oneCA[i])){
                if(usedChars.contains(twoCA[i])){
                    System.out.println("NO");
                    return;
                }
                charMap.put(oneCA[i], twoCA[i]);
                usedChars.add(twoCA[i]);
            }else{
                if(charMap.get(oneCA[i]) != twoCA[i]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }
}

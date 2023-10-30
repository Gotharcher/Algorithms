package Yandex.Algo_course.Sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Sprint4D {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int circles = Integer.parseInt(br.readLine());
        Set<Integer> circlesSet = new HashSet<>();
        List<String> circlesStrings = new ArrayList<>();
        for(int i = 0; i<circles;i++){
            String s = br.readLine();
            int hash = getStringSetHash(s);
            if(!circlesSet.contains(hash)){
                circlesSet.add(hash);
                circlesStrings.add(s);
            }
        }
        for(String s: circlesStrings){
            pw.println(s);
        }

        br.close();
        pw.close();
    }

    public static int getStringSetHash(String s){
        return s.hashCode();
//        int i = 0;
//        for(char c: s.toCharArray()){
//            i += c;
//        }
//        return i*s.length();
    }
}

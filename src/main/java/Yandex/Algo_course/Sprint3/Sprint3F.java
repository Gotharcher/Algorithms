package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sprint3F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int qty = Integer.parseInt(br.readLine());
        List<Integer> sides = new ArrayList<>(qty);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<qty;i++){
            sides.add(Integer.parseInt(st.nextToken()));
        }

        sides.sort(Collections.reverseOrder());

        for(int i=0; i<qty-2;i++){
            if(sides.get(i) < sides.get(i+1) + sides.get(i+2)){
                System.out.println(sides.get(i) + sides.get(i+1) + sides.get(i+2));
                return;
            }
        }
    }
}

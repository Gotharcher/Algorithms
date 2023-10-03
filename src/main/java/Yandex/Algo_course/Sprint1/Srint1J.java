package Yandex.Algo_course.Sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Srint1J {
    public static int val;
    public static List<Integer> divs = new ArrayList<>(32);
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        val = Integer.parseInt(br.readLine());
        while(val > 1){
            divide();
        }
        for(Integer k: divs){
            System.out.print(k +" ");
        }
    }

    public static void divide(){
        for(int i=2; i<Math.sqrt(val)+1; i++){
            if(val%i == 0){
                divs.add(i);
                val = val/i;
                return;
            }
        }
        divs.add(val);
        val = 1;
    }

}

package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint3C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] check = br.readLine().toCharArray();
        char[] init = br.readLine().toCharArray();

        int idxCheck = 0;
        for(int i=0; i<init.length; i++){
            if (idxCheck == check.length){
                System.out.println("True");
                return;
            }
            if(init[i]==check[idxCheck]){
                idxCheck++;
            }
        }
        if (idxCheck == check.length) {
            System.out.println("True");
        }else System.out.println("False");
    }
}

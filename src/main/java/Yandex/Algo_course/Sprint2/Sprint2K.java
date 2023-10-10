package Yandex.Algo_course.Sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint2K {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer intern = Integer.parseInt(br.readLine());
        int val = 0;
        val = fiboInterns(intern);
        System.out.println(val);
    }

    public static int fiboInterns(int intern){
        if(intern == 0 || intern == 1){
            return 1;
        }
        if(intern < 0){
            return 0;
        }
           return fiboInterns(intern-1) + fiboInterns(intern-2);
    }
}

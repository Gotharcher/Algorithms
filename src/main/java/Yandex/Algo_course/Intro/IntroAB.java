package Yandex.Algo_course.Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntroAB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aVal = Integer.parseInt(br.readLine());
        int bVal = Integer.parseInt(br.readLine());
        System.out.println(aVal+bVal);
    }
}

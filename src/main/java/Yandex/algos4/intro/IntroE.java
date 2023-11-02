package Yandex.algos4.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Идея - так как по неубыванию, "левые" результаты будут идти от 0 к минус беск (1-1, 1-3, 1-4), а правые к 0 справа (4-1, 4-3, 4-4).
//Соотв, я сдвигаю префиксный массив слева в минус, а справа к 0 на "n * (p[i-1]-p[i])".

public class IntroE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int studs = Integer.parseInt(br.readLine());
        int[] rating = new int[studs];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < studs; i++) {
            rating[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int leftleftsum = 0;
        for (int i = 0; i < studs; i++) {
            leftleftsum += Math.abs(rating[0] - rating[i]);
        }
        sb.append(leftleftsum).append(" ");

        for (int i = 1; i < studs; i++) {
            int dt = rating[i] - rating[i - 1];
            leftleftsum += (dt * i) - (dt * (studs - i));

            sb.append(leftleftsum).append(" ");
        }

        System.out.println(sb);
    }
}

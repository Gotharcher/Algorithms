package Yandex.algos4.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntroB {
    public static int top = 0;
    public static int bot = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpData = br.readLine().split(" ");
        int a = Integer.parseInt(inpData[0]);
        int b = Integer.parseInt(inpData[1]);
        int c = Integer.parseInt(inpData[2]);
        int d = Integer.parseInt(inpData[3]);

        top = a*d + c*b;
        bot = b*d;
        factorize();
        System.out.println(top + " " + bot);
    }

    public static void factorize(){
        for(int i = 2; i <= top; i++){
            if(top%i == 0){
                if(bot%i == 0){
                    top = top/i;
                    bot = bot/i;
                    factorize();
                }
            }
        }
    }
}

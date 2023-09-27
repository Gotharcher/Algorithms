package Yandex.Algo_course;

//D. Хаотичность погоды

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprint1D {



    public static void main(String[] ars) throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalDays = Integer.parseInt(br.readLine());
        if(totalDays == 1){
            System.out.println(1);
            return;
        }
        String[] days = br.readLine().split(" ");
        if(Integer.parseInt(days[0]) > Integer.parseInt(days[1])){
            ans++;
        }
        for(int i=1; i<totalDays-1; i++){
            if(Integer.parseInt(days[i]) > Integer.parseInt(days[i-1]) && Integer.parseInt(days[i]) > Integer.parseInt(days[i+1])){
                ans++;
            }
        }
        if(Integer.parseInt(days[totalDays-1]) > Integer.parseInt(days[totalDays-2])){
            ans++;
        }
        System.out.println(ans);
    }


}

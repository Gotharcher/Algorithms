package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprint3D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int children = Integer.parseInt(br.readLine());
        int [] greedsVal = new int[children];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<children; i++){
            greedsVal[i] = Integer.parseInt(st.nextToken());
        }

        int cookiesQty = Integer.parseInt(br.readLine());
        int [] cookies = new int[cookiesQty];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<cookiesQty; i++){
            cookies[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        Arrays.sort(greedsVal);
        Arrays.sort(cookies);

        int cookiePointer = 0;

        for(int k = 0; k<children;k++){
            while(cookiePointer < cookiesQty && greedsVal[k] > cookies[cookiePointer] ){
                   cookiePointer++;
            }
            if(cookiePointer<cookiesQty && greedsVal[k] <= cookies[cookiePointer] ){
                ans++;
                cookiePointer++;
            }
        }
        System.out.println(ans);
    }
}

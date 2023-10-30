package Yandex.algos4.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntroA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpData = br.readLine().split(" ");
        int length = Integer.parseInt(inpData[0]);
        int asks = Integer.parseInt(inpData[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[length];
        for (int i = 0; i < length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < asks; k++) {
            String[] ask = br.readLine().split(" ");
            findAns(seq, Integer.parseInt(ask[0]), Integer.parseInt(ask[1]));
        }
    }

    public static void findAns(int[] arr, int startIdx, int stopIdx) {
        int min = arr[startIdx];
        for (int s = startIdx + 1; s <= stopIdx; s++) {
            if (arr[s] > min) {
                System.out.println(arr[s]);
                return;
            }else if(arr[s] < min){
                System.out.println(min);
                return;
            }
        }
        System.out.println("NOT FOUND");

    }
}

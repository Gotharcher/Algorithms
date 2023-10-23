package Yandex.Algo_course.Sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sprint3J {
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int[] inputIntArr = new int[arrSize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            inputIntArr[i] = Integer.parseInt(st.nextToken());
        }
        pw = new PrintWriter(System.out);
        boolean sorted = true;
        for (int i = 0; i < arrSize; i++) {
            sorted = false;
            for (int j=0; j<arrSize-1; j++){
                if(inputIntArr[j] > inputIntArr[j+1]){
                    int buf = inputIntArr[j+1];
                    inputIntArr[j+1] = inputIntArr[j];
                    inputIntArr[j] = buf;
                    sorted = true;
                }
            }
            if(!sorted){
                if(i==0){
                    printArrVals(inputIntArr);
                }
                break;
            }else{
                printArrVals(inputIntArr);
            }

        }

        pw.close();
    }

    public static void printArrVals(int[] arr){
        for(int v:arr){
            pw.print(v + " ");
        }
        pw.println("");
    }

}
